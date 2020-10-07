package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.entidades.Usuario;
import com.desafiolatam.entidades.UsuarioSigno;
import com.desafiolatam.facade.Facade;

/**
 * Servlet implementation class Administracion
 */
@WebServlet("/Administracion")
public class Administracion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Administracion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Administracion GET");
		HttpSession miSesion = request.getSession(true);
		String sesion = "";
		sesion = (String) miSesion.getAttribute("login");
		System.out.println(sesion);
		try {
			if(sesion.equals("")||sesion==null) {
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
			
		List<UsuarioSigno> listUS = new ArrayList<UsuarioSigno>();
	
	Facade fac = new Facade();
	try {
		listUS = fac.obtenerTodo();
		System.out.println("LISTUS "+listUS);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(listUS != null || listUS.size() > 0) {
		//HttpSession miSesion = request.getSession(true);
		miSesion.setAttribute("listUS", listUS);
	}
		RequestDispatcher rd = request.getRequestDispatcher("/administracion.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Administracion POST");
		HttpSession miSesion = request.getSession(true);
		String sesion = "";
		sesion = (String) miSesion.getAttribute("login");
		System.out.println(sesion);
		try {
			if(sesion.equals("")||sesion==null) {
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		
		miSesion.setAttribute("nombreSigno", null);
		int idSigno = -1;
		String buscar ="";
		try {
			buscar = request.getParameter("buscar");
		}catch(Exception e) {
			System.out.println("Error en administracion por no encontrar el parametro buscar");
			e.getMessage();
			doGet(request, response);
		}
		if(buscar!= null && !buscar.equals("") && buscar.equals("buscar")) {

			idSigno = Integer.parseInt(request.getParameter("signo"));
		
		if(idSigno ==-1) {
			miSesion.setAttribute("nombreSigno", null);
		}else {
			
		
		Facade fac = new Facade();
		String nombreSigno ="";
		try {
			nombreSigno = fac.buscarSignoPorId(idSigno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		miSesion.setAttribute("nombreSigno", nombreSigno);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
		rd.forward(request, response);
		}else {
			doGet(request, response);
		}
	}

}

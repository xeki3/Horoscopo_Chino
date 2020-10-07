package com.desafiolatam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.entidades.Usuario;
import com.desafiolatam.facade.Facade;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
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
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Crear Usuario POST");
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
		
		
		
		
		// TODO Auto-generated method stub
Usuario user = null;
		Facade fac = new Facade();
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		user = fac.obtenerUsuario(nombre, clave);
		
		if(user == null) {
			int resultado =0;
			user = new Usuario();
			user.setNombre(nombre);
			user.setClave(clave);
			user.setFechaNacimiento(request.getParameter("date"));
			user.setIdSigno(Integer.parseInt(request.getParameter("signo")));	
			try {
			resultado =	fac.insertarUsuario(user);
			System.out.println("Resultado "+resultado);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(resultado==1) {
				RequestDispatcher rd = request.getRequestDispatcher("/Administracion");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	
	}
		
	

}

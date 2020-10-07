package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Modificar Usuario POST");
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
		
		miSesion.setAttribute("usuarioEditar", null);
		
		int buscar = Integer.parseInt(request.getParameter("buscar"));
		
		if(buscar==1) {
			int id =Integer.parseInt(request.getParameter("seleccionEditar"));
			Facade fac = new Facade();
			Usuario user = new Usuario();
			try {
				user = fac.obtenerUsurioPorId(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			miSesion.setAttribute("usuarioEditar", user);
			RequestDispatcher rd = request.getRequestDispatcher("/administracion.jsp");
			rd.forward(request, response);
		}else {
			int result=0;
			String nombreEdit = request.getParameter("nombreEdit");
			String claveEdit = request.getParameter("claveEdit");
			int signoEdit = Integer.parseInt(request.getParameter("signoEdit"));
			System.out.println("signo ql"+signoEdit);
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			String fecha = request.getParameter("dateEdit");
			Usuario user = new Usuario();
			user.setIdUser(idUser);
			user.setNombre(nombreEdit);
			user.setClave(claveEdit);
			user.setFechaNacimiento(fecha);
			user.setIdSigno(signoEdit);
			
			Facade fac = new Facade();
			try {
			result =fac.updateUsuario(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Resultado "+result);
			if(result==1) {
				System.out.println("Usuario editado...");
				miSesion.setAttribute("editado", true);
				RequestDispatcher rd = request.getRequestDispatcher("/Administracion");
				rd.forward(request, response);
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
	}

}

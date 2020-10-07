package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class LoginAndRegister
 */
@WebServlet("/LoginAndRegister")
public class LoginAndRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAndRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login And Register GET");
		String nombre;
		String clave;
		Usuario user = null;
		String login = request.getParameter("login");
		if(login.equals("second")) {
			Facade fac = new Facade();
			nombre = request.getParameter("nombre");
			clave = request.getParameter("clave");
			user = fac.obtenerUsuario(nombre, clave);
			if(user != null) {
				HttpSession miSesion = request.getSession(true);
				miSesion.setAttribute("login", nombre);
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}else {
			Facade fac = new Facade();
			nombre = request.getParameter("nombre");
			clave = request.getParameter("clave");
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
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(resultado==1) {
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package com.desafiolatam.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.dao.SignoDao;
import com.desafiolatam.dao.UsuarioDAO;
import com.desafiolatam.dao.UsuarioSignoDAO;
import com.desafiolatam.entidades.Usuario;
import com.desafiolatam.entidades.UsuarioSigno;

public class Facade {
	UsuarioDAO userDao = new UsuarioDAO();
	UsuarioSignoDAO usd = new UsuarioSignoDAO();
	SignoDao signoDao = new SignoDao();
	
	public Usuario obtenerUsuario(String nombre, String clave) {
		try {
			return userDao.obtenerUsuario(nombre, clave);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int insertarUsuario(Usuario user) throws Exception {
	
		int respuesta=0;
		respuesta = userDao.insert(user);
		return respuesta;
		
	}
	
	public int updateUsuario(Usuario user) throws Exception {
		int respuesta = userDao.updateUsuario(user);
		return respuesta;
		
	}
	
	public List<Usuario> obtenerListaUsuariosAll() throws SQLException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = userDao.obtenerListaUsuariosAll();
		return usuarios;
		
	}
	
	public List<UsuarioSigno> obtenerTodo() throws SQLException{
		
		return usd.obtenerTodo();
		
	}
	public int deletePorId(int id) throws Exception {
		
		return userDao.deletePorId(id);
		
	}
	
	public String buscarSignoPorId(int id) throws SQLException {
		
		return signoDao.buscarSignoPorId(id);
	}
	
	public Usuario obtenerUsurioPorId(int id) throws SQLException {
		
		return userDao.obtenerUsurioPorId(id);
	}
}

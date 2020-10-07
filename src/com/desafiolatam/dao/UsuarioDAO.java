package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.entidades.Usuario;
import com.desafiolatam.conexion.Conexion;


public class UsuarioDAO {

	public Usuario obtenerUsuario(String nombre, String clave) throws SQLException {

		String consultaSql = "select * from usuario Where nombre ='"+nombre+"' AND clave = '"+clave+"'";

		Connection cnn = Conexion.getDataSource().getConexion();

		PreparedStatement ps = cnn.prepareStatement(consultaSql);

		ResultSet rs = ps.executeQuery();
		Usuario user= null;
			while(rs.next()) {
				user = new Usuario();
				user.setNombre(rs.getString("nombre"));
				user.setClave(rs.getString("clave"));
				user.setFechaNacimiento(rs.getString("fechaNacimiento"));
				user.setIdSigno(rs.getInt("idSigno"));
				//System.out.println("USER "+user);

			}
		

			cnn.close();
		return user;
	}

	public List<Usuario> obtenerListaUsuariosAll() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String consultaSql = "select * from usuario";

		Connection cnn = Conexion.getDataSource().getConexion();

		PreparedStatement ps = cnn.prepareStatement(consultaSql);

		ResultSet rs = ps.executeQuery();
		Usuario user= null;


			while(rs.next()) {
				user = new Usuario();
				user.setIdUser(rs.getInt("idUser"));
				user.setNombre(rs.getString("nombre"));
				user.setClave(rs.getString("clave"));
				user.setFechaNacimiento(rs.getString("fechaNacimiento"));
				user.setIdSigno(rs.getInt("idSigno"));
				usuarios.add(user);
			}
			cnn.close();
		return usuarios;
	}

	public int obtenerIdPorNombre(String nombre) throws SQLException {
		String consultaSql = "select idUser from usuario Where nombre ='"+nombre;

		Connection cnn = Conexion.getDataSource().getConexion();

		PreparedStatement ps = cnn.prepareStatement(consultaSql);

		ResultSet rs = ps.executeQuery();
		cnn.close();
		return rs.getInt(0);
	}

	public int insert(Usuario user) throws Exception {

		int registro = 0;
		//String consultaProximoId = "select MAX(id_insc) + 1 as id_insc from inscripcion;";
		String insertarUsuario = "insert into usuario(nombre, clave, fechaNacimiento, idSigno) values(?,?,?,?);";

		Connection cnn = Conexion.getDataSource().getConexion();

		//PreparedStatement ps1 = cnn.prepareStatement(consultaProximoId);
		PreparedStatement ps2 = cnn.prepareStatement(insertarUsuario);

		ps2.setString(1, user.getNombre());
		ps2.setString(2, user.getClave());
		ps2.setString(3, user.getFechaNacimiento());
		ps2.setInt(4, user.getIdSigno());
		registro = ps2.executeUpdate();
		if(registro != 1) {
			throw new Exception("Ha ocurrido un error en la inserción");
		}
		cnn.close();
		return registro;
	}

	public int updateUsuario(Usuario user) throws Exception {
		int registro = 0;
		String updateUsuario = "UPDATE usuario SET nombre=?,clave=?,fechaNacimiento=?, idSigno=? WHERE idUser = ?";
		Connection cnn = Conexion.getDataSource().getConexion();

		PreparedStatement ps = cnn.prepareStatement(updateUsuario);
		ps.setString(1, user.getNombre());
		ps.setString(2,user.getClave());
		ps.setString(3,user.getFechaNacimiento());
		ps.setInt(4,user.getIdSigno());
		ps.setInt(5, user.getIdUser());

		registro = ps.executeUpdate();
		if(registro != 1) {
			throw new Exception("Ha ocurrido un error en la inserción");
		}
		cnn.close();
		return registro;

	}
	
	public int deletePorId(int id) throws Exception {
		int registro = 0;
		//String consultaProximoId = "select MAX(id_insc) + 1 as id_insc from inscripcion;";
		String eliminarUsuario = "DELETE FROM usuario WHERE idUser = ?";

		Connection cnn = Conexion.getDataSource().getConexion();

		//PreparedStatement ps1 = cnn.prepareStatement(consultaProximoId);
		PreparedStatement ps2 = cnn.prepareStatement(eliminarUsuario);

		ps2.setInt(1, id);
		registro = ps2.executeUpdate();
		if(registro != 1) {
			throw new Exception("Ha ocurrido un error en la eliminacion");
		}
		cnn.close();
		return registro;
	}
	
	public Usuario obtenerUsurioPorId(int id) throws SQLException {
		
		String consultaSql = "select * from usuario WHERE idUser = "+id;

		Connection cnn = Conexion.getDataSource().getConexion();

		PreparedStatement ps = cnn.prepareStatement(consultaSql);

		ResultSet rs = ps.executeQuery();
		Usuario user= null;


			while(rs.next()) {
				user = new Usuario();
				user.setIdUser(rs.getInt("idUser"));
				user.setNombre(rs.getString("nombre"));
				user.setClave(rs.getString("clave"));
				user.setFechaNacimiento(rs.getString("fechaNacimiento"));
				user.setIdSigno(rs.getInt("idSigno"));
			}
			cnn.close();
		return user;
		
	}
}

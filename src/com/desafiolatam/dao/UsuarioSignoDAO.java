package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.Conexion;
import com.desafiolatam.entidades.Signo;
import com.desafiolatam.entidades.Usuario;
import com.desafiolatam.entidades.UsuarioSigno;

public class UsuarioSignoDAO {

	public List<UsuarioSigno> obtenerTodo() throws SQLException{

		List<UsuarioSigno> usuariosSignos = new ArrayList<UsuarioSigno>();
		String consultaSql = "SELECT u.idUser, u.nombre, u.clave, u.fechaNacimiento, u.idSigno, s.nombre as newtabla FROM usuario u JOIN signo s ON u.idSigno = s.idSigno;";

		Connection cnn = Conexion.getDataSource().getConexion();

		PreparedStatement ps = cnn.prepareStatement(consultaSql);

		ResultSet rs = ps.executeQuery();
		Usuario user= null;
		Signo signo = null;
		UsuarioSigno us = null;

			while(rs.next()) {
				user = new Usuario();
				signo = new Signo();
				us = new UsuarioSigno();

				user.setIdUser(rs.getInt("idUser"));
				user.setNombre(rs.getString("nombre"));
				user.setClave(rs.getString("clave"));
				user.setFechaNacimiento(rs.getString("fechaNacimiento"));
				user.setIdSigno(rs.getInt("idSigno"));
				signo.setIdSigno(rs.getInt("idSigno"));
				signo.setNombre(rs.getString(6));
				
				
				us.setSigno(signo);
				us.setUser(user);
				
				usuariosSignos.add(us);
				
			}
		
			cnn.close();
		return usuariosSignos;

	}

}

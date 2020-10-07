package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.desafiolatam.conexion.Conexion;
import com.desafiolatam.entidades.Usuario;

public class SignoDao {
	
	public String buscarSignoPorId(int id) throws SQLException {
		
		
		
		String consultaSql = "select nombre from signo Where idSigno ="+id;

		Connection cnn = Conexion.getDataSource().getConexion();

		PreparedStatement ps = cnn.prepareStatement(consultaSql);

		ResultSet rs = ps.executeQuery();
		String nombre= "";
			while(rs.next()) {
				nombre = rs.getString("nombre");

			}
		

cnn.close();
		return nombre;
		
	}

}

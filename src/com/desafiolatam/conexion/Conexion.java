package com.desafiolatam.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.desafiolatam.conexion.Conexion;

public class Conexion {

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String BASE_DE_DATOS = "horoscopo_chino";
	private final String URL = "jdbc:mysql://127.0.0.1:3306/" + BASE_DE_DATOS + "?serverTimezone=UTC";
	private final String USUARIO = "root";
	private final String CLAVE = "";
	
	private static Conexion dataSource;
	private BasicDataSource basicDataSource = null;
	
	private Conexion() {
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(DRIVER);
		basicDataSource.setUrl(URL);
		basicDataSource.setUsername(USUARIO);
		basicDataSource.setPassword(CLAVE);
		
	}
	
	public static Conexion getDataSource() {
		if(dataSource == null) {
			dataSource = new Conexion();
			return dataSource;
		}else {
			return dataSource;
		}
	}
	
	public Connection getConexion() throws SQLException {
		return this.basicDataSource.getConnection();
	}
	
	
}

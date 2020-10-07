package com.desafiolatam.entidades;

import java.util.Date;

public class Usuario {
	
	private int idUser;
	private String nombre;
	private String clave;
	private String fechaNacimiento;
	private int idSigno;
	
	
	
	public Usuario() {
		super();
	}



	public Usuario(int idUser, String nombre, String clave, String fechaNacimiento, int idSigno) {
		super();
		this.idUser = idUser;
		this.nombre = nombre;
		this.clave = clave;
		this.fechaNacimiento = fechaNacimiento;
		this.idSigno = idSigno;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	public String getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public int getIdSigno() {
		return idSigno;
	}



	public void setIdSigno(int idSigno) {
		this.idSigno = idSigno;
	}



	public int getIdUser() {
		return idUser;
	}
	



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	@Override
	public String toString() {
		return "Usuario [idUser=" + idUser + ", nombre=" + nombre + ", clave=" + clave + ", fechaNacimiento="
				+ fechaNacimiento + ", idSigno=" + idSigno + "]";
	}
	
	
	

}

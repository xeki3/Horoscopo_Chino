package com.desafiolatam.entidades;

public class Signo {
	private int idSigno;
	private String nombre;
	
	
	
	public Signo() {
		super();
	}



	public Signo(int idSigno, String nombre) {
		super();
		this.idSigno = idSigno;
		this.nombre = nombre;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getIdSigno() {
		return idSigno;
	}

	


	public void setIdSigno(int idSigno) {
		this.idSigno = idSigno;
	}



	@Override
	public String toString() {
		return "Signo [idSigno=" + idSigno + ", nombre=" + nombre + "]";
	}
	

}

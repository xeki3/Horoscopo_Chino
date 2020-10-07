package com.desafiolatam.entidades;

public class UsuarioSigno {

	private Usuario user;
	private Signo signo;
	
	
	
	public UsuarioSigno() {
		super();
	}

	public UsuarioSigno(Usuario user, Signo signo) {
		super();
		this.user = user;
		this.signo = signo;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Signo getSigno() {
		return signo;
	}

	public void setSigno(Signo signo) {
		this.signo = signo;
	}

	@Override
	public String toString() {
		return "UsuarioSigno [user=" + user + ", signo=" + signo + "]";
	}
	
	
	
}

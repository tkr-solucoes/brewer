package com.tkr.brewer.model;

public class Cidade {

	String estado;
	String nome;
	
public Cidade() {
		
		
	}
	public Cidade(String estado, String nome) {
		
		this.estado = estado;
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}

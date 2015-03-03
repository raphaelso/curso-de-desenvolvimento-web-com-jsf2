package com.raphael.cursojsf2;

// import javax.faces.bean.ManagedBean; // import do managebean

// @ManagedBean //notação para funcionar o managebean
public class OlaMundoBean {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void enviar(){
		this.setNome(this.getNome().toUpperCase());
	}

}

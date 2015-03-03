package com.raphael.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.raphael.cursojsf2.dominio.Livro;

@ManagedBean
@SessionScoped
public class CatalogaLivro implements Serializable {

	private List<Livro> listaLivros;
	private Livro livro;
	
	public CatalogaLivro(){
		this.listaLivros = new ArrayList<Livro>();
		this.livro = new Livro();
	}
	
	public Livro getLivro(){
		return livro;
	}
	
	public List<Livro> getListaLivros(){
		return listaLivros;
	}
	
	public void incluirLivro(){
		this.listaLivros.add(livro);
		this.livro = new Livro();
	}
	
}

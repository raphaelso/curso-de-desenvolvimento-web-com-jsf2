package com.raphael.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.raphael.cursojsf2.dominio.Livro;

@ManagedBean
@SessionScoped
public class CatalogaLivro implements Serializable {
	
	private String tituloPesquisa;
	private List<Livro> listaLivros;
	private List<Livro> listaLivrosFiltrados;
	private Livro livro;
	private Livro livroSelecionado;
	
	public CatalogaLivro() {
		this.listaLivros = new ArrayList<Livro>();
		this.listaLivrosFiltrados = new ArrayList<Livro>();
		this.livro = new Livro();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public List<Livro> getListaLivros() {
		return listaLivros;
	}
	
	public void incluirLivro() {
		this.listaLivros.add(livro);
		this.livro = new Livro();
	}
	
	public void excluir() {
		this.listaLivros.remove(this.livroSelecionado);
	}
	
	public Livro getLivroSelecionado() {
		return livroSelecionado;
	}
	
	public void setLivroSelecionado(Livro livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}
	
	public void tituloPesquisaAlterado(ValueChangeEvent e) {
		this.listaLivrosFiltrados.clear();
		
		for (Livro livro : this.listaLivros) {
			if ( livro.getTitulo() != null && 
					livro.getTitulo().toLowerCase().startsWith(e.getNewValue().toString().toLowerCase()) ) {
				this.listaLivrosFiltrados.add(livro);
			}
		}
	}
	
	public String getTituloPesquisa(){
		return tituloPesquisa;
	}
	
	public void setTituloPesquisa(String tituloPesquisa) {
		this.tituloPesquisa = tituloPesquisa;
	}
	
	public List<Livro> getListaLivrosFiltrados() {
		return listaLivrosFiltrados;
	}
	
	public String listaLivros() {
		return "CatalogaLivro?faces-redirect=true";
	}
	
	public String telaInicial() {
		return "CatalogaLivroInicial?faces-redirect=true";
	}
	
	public String obterAjuda() {
		if (this.listaLivros.isEmpty()) {
			return "CatalogaLivroAjudaSemRegistros?faces-redirect=true";
		}else {
			return "CatalogaLivroAjudaComRegistros?faces-redirect=true";
		}
	}
}

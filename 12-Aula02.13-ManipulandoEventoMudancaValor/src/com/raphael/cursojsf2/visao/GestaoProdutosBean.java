package com.raphael.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.raphael.cursojsf2.dominio.Produto;

@ManagedBean
@SessionScoped
public class GestaoProdutosBean implements Serializable{

	private String nomePesquisa;
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;
	private Produto produto;
	
	private Produto produtoSelecionado;
	
	public GestaoProdutosBean(){
		this.listaProdutos = new ArrayList<Produto>();
		this.listaProdutosFiltrados = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void nomePesquisaAlterado(ValueChangeEvent e ){
		System.out.println("Evento de mudança de valor...");
		
		System.out.println("Valor atual: " + this.nomePesquisa);
		System.out.println("Valor atual digitado: " + e.getNewValue());
		
		this.listaProdutosFiltrados.clear();
		
		for (Produto produto : this.listaProdutos) {
			if( produto.getNome() != null & produto.getNome().toLowerCase()
					.startsWith(e.getNewValue().toString().toLowerCase()) ) {
				this.listaProdutosFiltrados.add(produto);
			}
		}
	}
	
	public void incluir(){
		this.listaProdutos.add(this.produto);
		this.produto = new Produto();
	}
	
	public void excluir(){
		this.listaProdutos.remove(this.produtoSelecionado);
	}
	
	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}
	
	public List<Produto> getProdutosFiltrados() {
		return listaProdutosFiltrados;
	}
	
}

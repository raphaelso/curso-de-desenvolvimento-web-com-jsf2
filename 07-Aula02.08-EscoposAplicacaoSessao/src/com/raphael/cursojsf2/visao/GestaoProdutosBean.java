package com.raphael.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.raphael.cursojsf2.dominio.Produto;

@ManagedBean
//@ApplicationScoped // usar quando for compartilhar informações
@SessionScoped // usado para que cada um tenha uma sessão independente
public class GestaoProdutosBean {
	
	private List<Produto> listaProdutos;
	private Produto produto;
	
	public GestaoProdutosBean(){
		this.listaProdutos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public Produto getProduto(){
		return produto;
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void incluir(){
		this.listaProdutos.add(produto);
		this.produto = new Produto();
	}
}

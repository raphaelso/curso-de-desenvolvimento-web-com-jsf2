package com.raphael.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.raphael.cursojsf2.dominio.Produto;

@ManagedBean
//@ViewScoped //ViewScoped tem o tempo menor do que o escopo anterior usado ou seja ele vai até você encerrar a aplicação ou seja enquanto a tela está aberta
//@RequestScoped //Um escopo padrão mesmo sem definir ele já é o escopo existente, cada requisição ele finaliza e reinicia esse escopo - tempo de vida curto
//@NoneScoped // escopo que não tem tempo de vida, inicia por demanda, inicia e instancia sempre que necessário - nem chega a executar @PreDestroy porque já finaliza na hora
@SessionScoped // usado para que cada um tenha uma sessão independente
public class GestaoProdutosBean implements Serializable {

	private List<Produto> listaProdutos;
	private Produto produto;
	private Produto produtoSelecionado;
	

	public GestaoProdutosBean(){
		this.listaProdutos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void excluir(){
		this.listaProdutos.remove(this.produtoSelecionado);
	}
	
	public void verificarInclusao(ActionEvent e){
		System.out.println("verificando ...");
		if ( "".equals(this.produto.getFabricante()) ) {
			this.produto.setFabricante("Sem fabricante");
		}
		
		if ( "".equals(this.produto.getCategoria()) ) {
			this.produto.setCategoria("Sem categoria");
		}
	}
	
	public String obterAjuda(){
		if (this.listaProdutos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		}else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}
	
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public Produto getProduto(){
		return produto;
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void incluir(){
		System.out.println("incluindo...");
		this.listaProdutos.add(produto);
		this.produto = new Produto();
	}

	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializou bean");
	}
	
	@PreDestroy
	public void finalizar(){
		System.out.println("Finalizando bean");
	}
}

package br.edu.insper.desagil.decor;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario{
	private List<Produto> produtos;
	
	public Vendedor(String nome) {
		super(nome);
		produtos = new ArrayList<>();
	}
	
	private List<Produto> getProdutos() {
		return produtos;
	}

	public void cadastraProduto(String nome, double preco) {
		this.getProdutos().add(new Produto(nome, preco));
	}

}

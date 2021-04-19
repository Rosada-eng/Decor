package br.edu.insper.desagil.decor;

import java.util.HashMap;
import java.util.Map;

public class Video {
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Map<String, Integer> avaliacoes;
	
	public Video(int id, Usuario usuario, Produto produto) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		avaliacoes = new HashMap<>();
	}

	public int getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	private Usuario getUsuario() {
		return usuario;
	}

	private Map<String, Integer> getAvaliacoes() {
		return avaliacoes;
	}

	public void adicionaAvaliacao(Usuario usuario, int nota) {
		if (!usuario.getNome().equals(this.getUsuario().getNome()) && (nota >= 1 && nota<= 5)) {
			
			this.getAvaliacoes().put(usuario.getNome(), nota);
		}
	}
	
	public int mediaAvaliacoes() {
		int soma = 0;
		double media = 0.0;
		
		for (int nota: this.getAvaliacoes().values()) {
			soma += nota;
		}
		
		media = (double) soma / this.getAvaliacoes().size();
		
		return (int) Math.round(media);
	}
}

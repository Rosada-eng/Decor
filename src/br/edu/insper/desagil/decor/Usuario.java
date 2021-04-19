package br.edu.insper.desagil.decor;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private List<Video> videos;
	
	
	public Usuario(String nome) {
		super();
		this.nome = nome;
		videos = new ArrayList<>();
	}


	public String getNome() {
		return nome;
	}
		
	private List<Video> getVideos() {
		return videos;
	}


	public Video postaVideo(int id, Produto produto) {
		Video video = new Video(id, this, produto);
		this.getVideos().add(video);
		
		return video;
	}
	
	public int mediaAvaliacoes() {
		int soma = 0;		
		for(Video video: videos) {
			soma += video.mediaAvaliacoes();			
		}
		
		return soma;
	}
	

}

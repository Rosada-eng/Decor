package br.edu.insper.desagil.decor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecorTest {
	private Usuario usuarioAutor;
	private Usuario avaliador;
	private Video videoA;
	private Video videoB;
	
	@BeforeEach
	public void init () {
		usuarioAutor = new Usuario("James Cameron");
		avaliador = new Usuario("Nicolas Cage");
		videoA = usuarioAutor.postaVideo(11, new Produto("Cama", 200.0));
		videoB = usuarioAutor.postaVideo(22, new Produto("Sofa", 300.0));
	}
	

	@Test
	public void umVideoAvaliacoesInvalidas() {
		videoA.adicionaAvaliacao(usuarioAutor, 4);
		videoA.adicionaAvaliacao(avaliador, 0);
		videoA.adicionaAvaliacao(avaliador, 7);
		
		int somaMedias = usuarioAutor.mediaAvaliacoes();
		int somaMediasEsperada = 0;
		
		assertEquals(somaMediasEsperada, somaMedias);
		
	}
	
	@Test
	public void umVideoUmaAvaliacaoValida() {
		videoA.adicionaAvaliacao(avaliador, 3);
		
		int somaMedias = usuarioAutor.mediaAvaliacoes();
		int somaMediasEsperada = 3;
		
		assertEquals(somaMediasEsperada, somaMedias);
	}
	
	@Test
	public void umVideoDuasAvaliacoesValidas() {
		videoA.adicionaAvaliacao(avaliador, 3);
		videoA.adicionaAvaliacao(avaliador, 4);
		
		int somaMedias = usuarioAutor.mediaAvaliacoes();
		int somaMediasEsperadas = 4; // arredCima 3.5 = 4
		
		assertEquals(somaMediasEsperadas, somaMedias);
	}
	
	@Test
	public void umVideoTresAvaliacoesValidas() {
		videoA.adicionaAvaliacao(avaliador, 3);
		videoA.adicionaAvaliacao(avaliador, 4);
		videoA.adicionaAvaliacao(avaliador, 3);
		
		int somaMedias = usuarioAutor.mediaAvaliacoes();
		int somaMediasEsperadas = 3; // arredBaixo 3.33 = 3
		
		assertEquals(somaMediasEsperadas, somaMedias);		
	}
	
	@Test
	public void doisVideosTresAvaliacoesValidas() {
		videoA.adicionaAvaliacao(avaliador, 3);
		videoA.adicionaAvaliacao(avaliador, 4);
		videoB.adicionaAvaliacao(avaliador, 3);
		
		int somaMedias = usuarioAutor.mediaAvaliacoes();
		int somaMediasEsperadas = 4 + 3;
		
		assertEquals(somaMediasEsperadas, somaMedias);
	}

}

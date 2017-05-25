package br.com.livraria.dao;

import java.math.BigDecimal;

import java.util.List;

import org.junit.Ignore;

import org.junit.Test;

import br.com.livraria.DAO.LivroDAO;

import br.com.livraria.DAO.entity.Livro;

public class LivrosDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Livro livros = new Livro();
		livros.setNome_livro("SOMOS GENIOS");
		livros.setAno_publicacao(2015);
		livros.setAutor("Esta funfando");
		livros.setCategoria("TI");
		livros.setEdicao(10);
		livros.setEditora("Arqueiro");
		livros.setIdioma("Portugues");
		livros.setNum_paginas(new Short("100"));
		livros.setQuantidade(new Short("2"));
		livros.setPreco(new BigDecimal("20.00"));
		LivroDAO livrosDAO = new LivroDAO();
		livrosDAO.salvar(livros);
		System.out.println("Livro salvo com sucesso");

	}

	@Test
	@Ignore
	public void listar() {
		LivroDAO livrosDAO = new LivroDAO();
		List<Livro> resultado = livrosDAO.listar();
		for (Livro livros : resultado) {
			System.out.println("Nome do Livro: " + livros.getNome_livro());
			System.out.println("Ano de Publicação: " + livros.getAno_publicacao());
			System.out.println("Autor do Livro: " + livros.getAutor());
			System.out.println("Categoria do Livro: " + livros.getCategoria());
			System.out.println("Edição do Livro: " + livros.getEdicao());
			System.out.println("Editora do Livro: " + livros.getEditora());
			System.out.println("Idioma do Livro: " + livros.getIdioma());
			System.out.println("Numero de páginas : " + livros.getNum_paginas());
			System.out.println("Quantidade de páginas : " + livros.getQuantidade());
			System.out.println("Preço do livro : " + livros.getPreco());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 7L;
		LivroDAO livrosDAO = new LivroDAO();
		Livro livros = livrosDAO.buscar(codigo);
		System.out.println("Nome do Livro: " + livros.getNome_livro());
		System.out.println("Ano de Publicação: " + livros.getAno_publicacao());
		System.out.println("Autor do Livro: " + livros.getAutor());
		System.out.println("Categoria do Livro: " + livros.getCategoria());
		System.out.println("Edição do Livro: " + livros.getEdicao());
		System.out.println("Editora do Livro: " + livros.getEditora());
		System.out.println("Idioma do Livro: " + livros.getIdioma());
		System.out.println("Numero de páginas : " + livros.getNum_paginas());
		System.out.println("Quantidade de páginas : " + livros.getQuantidade());
		System.out.println("Preço do livro : " + livros.getPreco());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 8L;
		LivroDAO livrosDAO = new LivroDAO();
		Livro livros = livrosDAO.buscar(codigo);
		livrosDAO.excluir(livros);
		System.out.println("Ano de Publicação: " + livros.getAno_publicacao());
		System.out.println("Autor do Livro: " + livros.getAutor());
		System.out.println("Categoria do Livro: " + livros.getCategoria());
		System.out.println("Edição do Livro: " + livros.getEdicao());
		System.out.println("Editora do Livro: " + livros.getEditora());
		System.out.println("Idioma do Livro: " + livros.getIdioma());
		System.out.println("Nome do Livro: " + livros.getNome_livro());
		System.out.println("Numero de páginas : " + livros.getNum_paginas());
		System.out.println("Quantidade de páginas : " + livros.getQuantidade());
		System.out.println("Preço do livro : " + livros.getPreco());
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoLivros = 7L;
		LivroDAO livrosDAO = new LivroDAO();
		Livro livros = livrosDAO.buscar(codigoLivros);
		System.out.println("Ano de Publicação: " + livros.getAno_publicacao());
		System.out.println("Autor do Livro: " + livros.getAutor());
		System.out.println("Categoria do Livro: " + livros.getCategoria());
		System.out.println("Edição do Livro: " + livros.getEdicao());
		System.out.println("Editora do Livro: " + livros.getEditora());
		System.out.println("Idioma do Livro: " + livros.getIdioma());
		System.out.println("Nome do Livro: " + livros.getNome_livro());
		System.out.println("Numero de páginas : " + livros.getNum_paginas());
		System.out.println("Quantidade de páginas : " + livros.getQuantidade());
		System.out.println("Preço do livro : " + livros.getPreco());
		livros.setAno_publicacao(2020);
		livrosDAO.editar(livros);
	}
}
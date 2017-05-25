package br.com.livraria.DAO.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Livro extends GenericEntity {

	@Column(nullable = false)
	private Short quantidade;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal preco;

	@Column(length = 80, nullable = false)
	private String nome_livro;

	@Column(length = 20, nullable = false)
	private String autor;

	@Column(length = 50, nullable = false)
	private String editora;

	@Column(length = 2, nullable = false)
	private int edicao;

	@Column(length = 4, nullable = false)
	private int ano_publicacao;

	@Column(nullable = false)
	private int num_paginas;

	@Column(length = 50, nullable = false)
	private String idioma;

	@Column(length = 50, nullable = false)
	private String categoria;

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getNome_livro() {
		return nome_livro;

	}

	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getAno_publicacao() {
		return ano_publicacao;
	}

	public void setAno_publicacao(int ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}

	public int getNum_paginas() {
		return num_paginas;
	}

	public void setNum_paginas(int num_paginas) {
		this.num_paginas = num_paginas;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}

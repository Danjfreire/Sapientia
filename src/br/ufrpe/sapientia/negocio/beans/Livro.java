package br.ufrpe.sapientia.negocio.beans;

public class Livro {
	
	private String titulo;
	private String autor;
	private String edicao;
	private String ano;
	private String ISBN;
	private String categoria;
	private String resumo;
	
	public Livro(String titulo, String autor, String edicao, String ano, String iSBN, String categoria, String resumo) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.ano = ano;
		ISBN = iSBN;
		this.categoria = categoria;
		this.resumo = resumo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	
	
}

package br.ufrpe.sapientia.negocio.beans;

public class Livro {
	
	private int id;
	private String titulo;
	private String autor;
	private String edicao;
	private String ano;
	private String isbn;
	private String categoria;
	private String resumo;
	private String volume;
	private int estoque;
	private int total;
	public Livro(String titulo, String autor, String edicao, String ano, String isbn, String categoria, String resumo,
			String volume, int estoque, int total) {
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.ano = ano;
		this.isbn = isbn;
		this.categoria = categoria;
		this.resumo = resumo;
		this.volume = volume;
		this.estoque = estoque;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", edicao=" + edicao + ", ano=" + ano
				+ ", isbn=" + isbn + ", categoria=" + categoria + ", resumo=" + resumo + ", volume=" + volume
				+ ", estoque=" + estoque + ", total=" + total + "]";
	}
	
}

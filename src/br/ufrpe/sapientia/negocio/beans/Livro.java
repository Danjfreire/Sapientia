package br.ufrpe.sapientia.negocio.beans;

public class Livro {
	
	private int id;
	private String titulo;
	private String autor;
	private String edicao;
	private String ano;
	private String ISBN;
	private String categoria;
	private String resumo;
	private String volume;
	private int estoque;
	
	
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
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
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", edicao=" + edicao + ", ano=" + ano
				+ ", ISBN=" + ISBN + ", categoria=" + categoria + ", resumo=" + resumo + ", volume=" + volume + "]";
	}
	
}

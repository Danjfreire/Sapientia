package br.ufrpe.sapientia.negocio.beans;

import java.util.Calendar;

public class Historico {
	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;
	private int id;
	private String isbnLivro;
	private String cpfCliente;
	private String cpfFuncionario;
	private String tituloLivro;
	public Historico(Calendar dataEmprestimo, Calendar dataDevolucao, String isbnLivro, String cpfCliente,
			String cpfFuncionario, String tituloLivro) {
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.isbnLivro = isbnLivro;
		this.cpfCliente = cpfCliente;
		this.cpfFuncionario = cpfFuncionario;
		this.tituloLivro = tituloLivro;
	}
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbnLivro() {
		return isbnLivro;
	}
	public void setIsbnLivro(String isbnLivro) {
		this.isbnLivro = isbnLivro;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getCpfFuncionario() {
		return cpfFuncionario;
	}
	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	public String toString() {
		return "Historico [dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", id=" + id
				+ ", isbnLivro=" + isbnLivro + ", cpfCliente=" + cpfCliente + ", cpfFuncionario=" + cpfFuncionario
				+ ", tituloLivro=" + tituloLivro + "]";
	}
	
}

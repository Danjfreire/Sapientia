package br.ufrpe.sapientia.negocio.beans;
import java.util.Calendar;

public class Emprestimo {

	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;
	private int idEmprestimo;
	private String status;
	private String isbnLivro;
	private String cpfCliente;
	private String cpfFuncionario;
	private String tituloLivro;
	public Emprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status,
			String isbnLivro, String cpfCliente, String cpfFuncionario, String tituloLivro) {
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.idEmprestimo = idEmprestimo;
		this.status = status;
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
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "Emprestimo [dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", idEmprestimo="
				+ idEmprestimo + ", status=" + status + ", isbnLivro=" + isbnLivro + ", cpfCliente=" + cpfCliente
				+ ", cpfFuncionario=" + cpfFuncionario + ", tituloLivro=" + tituloLivro + "]";
	}
	
}

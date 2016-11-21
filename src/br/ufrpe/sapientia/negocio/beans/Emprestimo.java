package br.ufrpe.sapientia.negocio.beans;
import java.util.Calendar;

public class Emprestimo {

	Calendar dataEmprestimo;
	Calendar dataDevolucao;
	private int IDEmprestimo;
	private String status;
	private Livro livro;
	private Usuario cliente;
	private Usuario funcionario;
	
	public Emprestimo(Calendar dataEmprestimo, Calendar dataDevolucao,int iDEmprestimo, String status, Livro livro, Usuario cliente,Usuario funcionario) {
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		IDEmprestimo = iDEmprestimo;
		this.status = status;
		this.livro = livro;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public int getIDEmprestimo() {
		return IDEmprestimo;
	}

	public void setIDEmprestimo(int iDEmprestimo) {
		IDEmprestimo = iDEmprestimo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	public Usuario getFuncionario(){
		return this.funcionario;
	}
	
	
}

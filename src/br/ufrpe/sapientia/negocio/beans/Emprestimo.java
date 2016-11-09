package br.ufrpe.sapientia.negocio.beans;

public class Emprestimo {

	//dataEmprestimo
	//dataDevolucao
	private int IDEmprestimo;
	private String status;
	private Livro livro;
	private Cliente cliente;
	
	public Emprestimo(int iDEmprestimo, String status, Livro livro, Cliente cliente) {
		super();
		IDEmprestimo = iDEmprestimo;
		this.status = status;
		this.livro = livro;
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}

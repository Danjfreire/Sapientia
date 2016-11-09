package br.ufrpe.sapientia.negocio.beans;

public class Funcionario extends Usuario{

	private String CPF;
	private String nome;
	private int ID;
	//nascimento
	public Funcionario(String email, String login, String senha, String sexo, String endereco, String cpf, String nome, int id) {
		super(email, login, senha, sexo, endereco);
		
		this.CPF = cpf;
		this.nome = nome;
		this.ID = ID;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
	
}

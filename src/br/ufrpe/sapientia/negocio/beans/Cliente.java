package br.ufrpe.sapientia.negocio.beans;

public class Cliente extends Usuario{

	private String CPF;
	private String nome;
	private String contato;
	//nascimento
	
	public Cliente(String tipo, String email, String login, String senha, String sexo, String endereco,String cpf, String nome,String contato) {
		super(tipo, nome, cpf, contato, email, login, senha, sexo, endereco);
		this.CPF = cpf;
		this.nome = nome;
		this.contato = contato;
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

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
	
}

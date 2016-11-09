package br.ufrpe.sapientia.negocio.beans;

public class Usuario {

	private String email;
	private String login;
	private String senha;
	private String sexo;
	private String endereco;
	
	public Usuario(String email, String login, String senha, String sexo, String endereco) {
		super();
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.sexo = sexo;
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}

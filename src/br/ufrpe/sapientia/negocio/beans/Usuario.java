package br.ufrpe.sapientia.negocio.beans;

public class Usuario {

	private int id; //acho que não precisa de id e poderiamos utilizar o cpf pra maioria das coisas assim como na rural
	private String nome;
	private String cpf;
	private String contato;
	private String email;
	private String login;
	private String senha;
	private String sexo;
	private String endereco;
	private String tipo;
	
	public Usuario(){
		
	}
	
	public Usuario(String tipo, String nome, String cpf, String contato, 
			String email, String login, String senha,String sexo, String endereco){ 
		
		this.tipo = tipo;
		this.email = email;
		this.login = login;
		this.senha = senha;
		
		if(tipo == "cliente" || tipo == "funcionario"){
			this.nome = nome;
			this.cpf = cpf;
			this.endereco = endereco;
			this.contato = contato;
			this.sexo = sexo;
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return "Usuario [nome=" + nome + ", cpf=" + cpf + ", contato=" + contato + ", id=" + id + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + ", sexo=" + sexo + ", endereco=" + endereco + ", tipo="
				+ tipo + "]";
	}
	
}

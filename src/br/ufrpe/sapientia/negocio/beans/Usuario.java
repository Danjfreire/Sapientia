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
	private String tipo;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	public Usuario(String nome, String cpf, String contato, String email, String login, String senha,
			String sexo, String tipo, String logradouro, int numero, String bairro, String cidade, String estado) {
		this.nome = nome;
		this.cpf = cpf;
		this.contato = contato;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.sexo = sexo;
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", contato=" + contato + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + ", sexo=" + sexo + ", tipo=" + tipo + ", logradouro="
				+ logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ "]";
	}
	
}

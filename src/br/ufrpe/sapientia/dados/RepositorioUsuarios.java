package br.ufrpe.sapientia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Usuario;



public class RepositorioUsuarios implements IRepositorioUsuarios{
	private Connection connection;
	
	public RepositorioUsuarios(){
		this.connection = new Conexao().construirConexao();
	}
	public boolean cadastrar(Usuario u){
		/*
		 * N�o sei se esse m�todo precisa de alguma mudan�a visto que criei um construtor para usu�rio
		 */
		boolean s = false;
		String sql = "insert into usuario (cpf_usuario, nome_usuario, telefone_usuario,"
				+ " endereco_usuario, email_usuario, login_usuario, senha_usuario, tipo_usuario, sexo_usuario)"
				+ " value(?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, u.getCpf());
			stmt.setString(2, u.getNome());
			stmt.setString(3, u.getContato());
			stmt.setString(4, u.getEndereco());
			stmt.setString(5, u.getEmail());
			stmt.setString(6, u.getLogin());
			stmt.setString(7, u.getSenha());
			stmt.setString(8, u.getTipo());
			stmt.setString(9, u.getSexo());
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("Cadastrado");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return s;
	}
	
	public boolean remover(String cpf){
		boolean s = false;
		String sql = "delete from usuario where cpf_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("removido");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return s;
	}
	
	public boolean atualizar(Usuario u){
		/*
		 * Acho que pode ficar recebendo um usu�rio mesmo mas o ideal � que ele busque no banco um usu�rio que tenha o mesmo CPF 
		 * do usu�rio passado como par�metro e atualize os dados dele com os dados do usu�rio passado como parametro.
		 * Isso porque esse m�todo vai ser sempre usado depois de uma busca ou depois de um usu�rio estar logado ent�o sempre saberemos
		 * o cpf do usu�rio que vai ser atualizado.
		 * Como o adm basicamente s� possui login e senha e s� existe um, seria bom criar um m�todo separado atualizarADM que busca 
		 * o unico adm do sistema e modifica com os valores passado por parametro. Ex: boolean atualizarADM(String login, String senha) 
		 */
		boolean s = false;
		String sql = "update usuario set nome_usuario = ?, telefone_usuario = ?,"+
		"endereco_usuario = ?, email_usuario = ?, login_usuario = ?, senha_usuario = ?,"+
		"tipo_usuario = ?, cpf_usuario = ?, sexo_usuario = ? where id_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getContato());
			stmt.setString(3, u.getEndereco());
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getLogin());
			stmt.setString(6, u.getSenha());
			stmt.setString(7, u.getTipo());
			stmt.setString(8, u.getCpf());
			stmt.setString(9, u.getSexo());
			stmt.setInt(10, u.getId());
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("atualizado");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return s;
	}
	
	public List<Usuario> pesquisarTodos(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Usuario u = new Usuario();
				preencherUsuario(rs,u);
				usuarios.add(u);
			}
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public List<Usuario> pesquisarNome(String nome){
		/*
		 * Nesse caso a melhor op��o seria o m�todo tamb�m receber o tipo buscado como par�metro para s� buscar clientes ou
		 * s� buscar funcion�rios porque podem existir funcion�rios e clientes com o mesmo nome. 
		 * 
		 * Ex:
		 * pesquisarNome(String nome, String tipo)
		 * if(tipo == "cliente")
		 * 	....
		 * else
		 *  ....
		 */
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario where nome_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Usuario u = new Usuario();
				preencherUsuario(rs,u);
				usuarios.add(u);
			}
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario pesquisarCPF(String cpf){
		/*
		 * O mesmo caso de cima, deve possuir um parametro de tipo porque existem casos em que a busca s� pode retornar um cliente
		 * ou s� um funcion�rio, n�o faz sentido uma busca por um cliente retornar um funcion�rio caso o cpf seja inserido incorretamente
		 */
		Usuario u = new Usuario();
		String sql = "select * from usuario where cpf_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				preencherUsuario(rs,u);
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
	
	private void preencherUsuario(ResultSet rs, Usuario u){
		try {
			u.setId(rs.getInt("id_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			u.setNome(rs.getString("nome_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			u.setCpf(rs.getString("cpf_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			u.setEndereco(rs.getString("endereco_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			u.setEmail(rs.getString("email_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			u.setLogin(rs.getString("login_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			u.setSenha(rs.getString("senha_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			u.setTipo(rs.getString("tipo_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			u.setContato(rs.getString("telefone_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			u.setSexo(rs.getString("sexo_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package br.ufrpe.sapientia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Usuario;



public class RepositorioUsuarios {
	private Connection connection;
	
	public RepositorioUsuarios(){
		this.connection = new Conexao().construirConexao();
	}
	public boolean cadastrar(Usuario u){
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
	
	public boolean remover(int cpf){
		boolean s = false;
		String sql = "delete from usuario where cpf_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, cpf);
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
	
	public List<Usuario> pesquisarCPF(String cpf){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario where cpf_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
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

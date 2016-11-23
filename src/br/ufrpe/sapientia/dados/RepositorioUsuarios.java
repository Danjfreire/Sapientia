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
			//System.out.println("Cadastrado");
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
	
	public boolean atualizar(String cpf, String nome, String contato, String endereco, 
			String email, String login, String senha, String tipo, String sexo){
		
		boolean s = false;
		String sql = "update usuario set nome_usuario = ?, telefone_usuario = ?,"+
		"endereco_usuario = ?, email_usuario = ?, login_usuario = ?, senha_usuario = ?,"+
		"tipo_usuario = ?, sexo_usuario = ? where cpf_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, contato);
			stmt.setString(3, endereco);
			stmt.setString(4, email);
			stmt.setString(5, login);
			stmt.setString(6, senha);
			stmt.setString(7, tipo);
			stmt.setString(8, sexo);
			stmt.setString(9, cpf);
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
			while(rs.next())
				usuarios.add(preencherUsuario(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public List<Usuario> pesquisarNome(String nome, String tipo){
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario where nome_usuario = ? and tipo_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, tipo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())				
				usuarios.add(preencherUsuario(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario pesquisarCPF(String cpf, String tipo){
		/*
		 * O mesmo caso de cima, deve possuir um parametro de tipo porque existem casos em que a busca só pode retornar um cliente
		 * ou só um funcionário, não faz sentido uma busca por um cliente retornar um funcionário caso o cpf seja inserido incorretamente
		 */
		Usuario u = null;
		String sql = "select * from usuario where cpf_usuario = ? and tipo_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.setString(2, tipo);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				 u = preencherUsuario(rs);
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
	
	public Usuario pesquisarLoginSenha(String login, String senha){
		Usuario u = null;
		String sql = "select * from usuario where login_usuario = ? and senha_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				 u = preencherUsuario(rs);
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
	
	private Usuario preencherUsuario(ResultSet rs){
		Usuario u = null;
		try{
			int id = rs.getInt("id_usuario");
			String nome = rs.getString("nome_usuario");
			String cpf = rs.getString("cpf_usuario");
			String endereco = rs.getString("endereco_usuario");
			String email = rs.getString("email_usuario");
			String login = rs.getString("login_usuario");
			String senha = rs.getString("senha_usuario");
			String contato = rs.getString("telefone_usuario");
			String tipo = rs.getString("tipo_usuario");
			String sexo = rs.getString("sexo_usuario");
			u = new Usuario(tipo, nome, cpf, contato, email, login, senha, sexo, endereco);
			u.setId(id);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
 }


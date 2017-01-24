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
	public boolean cadastrar(Usuario u) throws Exception{
		boolean s = false;
		String sql = "insert into usuario (cpf_usuario, nome_usuario, telefone_usuario,"
				+ " email_usuario, login_usuario, senha_usuario, tipo_usuario, sexo_usuario, logradouro, numero, bairro, cidade, estado)"
				+ " value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, u.getCpf());
			stmt.setString(2, u.getNome());
			stmt.setString(3, u.getContato());
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getLogin());
			stmt.setString(6, u.getSenha());
			stmt.setString(7, u.getTipo());
			stmt.setString(8, u.getSexo());
			stmt.setString(9, u.getLogradouro());
			stmt.setInt(10, u.getNumero());
			stmt.setString(11, u.getBairro());
			stmt.setString(12, u.getCidade());
			stmt.setString(13, u.getEstado());
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("Cadastrado");
		}catch(SQLException e){
			System.out.print(e.getMessage());
			throw new Exception("Falha ao cadastrar o usuário!");
		}
		return s;
	}
	
	public boolean remover(String cpf) throws Exception{
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
			System.out.print(e.getMessage());
			throw new Exception("Falha ao remover o usuário!");
		}
		return s;
	}
	
	public boolean atualizar(String cpf, String nome, String contato, 
			String email, String login, String senha, String tipo, String sexo, String logradouro, 
			int numero, String bairro, String cidade, String estado) throws Exception{
		
		boolean s = false;
		String sql = "update usuario set nome_usuario = ?, telefone_usuario = ?,"+
		" email_usuario = ?, login_usuario = ?, senha_usuario = ?,"+
		"tipo_usuario = ?, sexo_usuario = ?, logradouro = ?, numero = ?"
		+ ", bairro = ?, cidade = ?, estado = ? where cpf_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, contato);
			stmt.setString(3, email);
			stmt.setString(4, login);
			stmt.setString(5, senha);
			stmt.setString(6, tipo);
			stmt.setString(7, sexo);
			stmt.setString(8, logradouro);
			stmt.setInt(9, numero);
			stmt.setString(10, bairro);
			stmt.setString(11, cidade);
			stmt.setString(12, estado);
			stmt.setString(13, cpf);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("atualizado");
		}catch(SQLException e){
			System.out.print(e.getMessage());
			throw new Exception("Falha ao atualizar o usuário");
		}
		return s;
	}
	
	public List<Usuario> pesquisarTodos(String tipo) throws Exception{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario where tipo_usuario = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, tipo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				usuarios.add(preencherUsuario(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			System.out.print(e.getMessage());
			throw new Exception("Falha na pesquisa!");
		}
		return usuarios;
	}
	
	public List<Usuario> pesquisarNome(String nome, String tipo) throws Exception{
		
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
			System.out.print(e.getMessage());
			throw new Exception("Falha na pesquisa do nome!");
		}
		return usuarios;
	}
	
	public Usuario pesquisarCPF(String cpf, String tipo) throws Exception{
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
			System.out.print(e.getMessage());
			throw new Exception("Falha na pesquisa do cpf!");
		}
		return u;
	}
	
	public Usuario pesquisarLoginSenha(String login, String senha) throws Exception{
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
			System.out.print(e.getMessage());
			throw new Exception("Falha na pesquisa do login e senha!");
		}
		return u;
	}
	
	private Usuario preencherUsuario(ResultSet rs){
		Usuario u = null;
		try{
			int id = rs.getInt("id_usuario");
			String nome = rs.getString("nome_usuario");
			String cpf = rs.getString("cpf_usuario");
			String email = rs.getString("email_usuario");
			String login = rs.getString("login_usuario");
			String senha = rs.getString("senha_usuario");
			String contato = rs.getString("telefone_usuario");
			String tipo = rs.getString("tipo_usuario");
			String sexo = rs.getString("sexo_usuario");
			String logradouro = rs.getString("logradouro");
			int numero = rs.getInt("numero");
			String bairro = rs.getString("bairro");
			String cidade = rs.getString("cidade");
			String estado = rs.getString("estado");
			u = new Usuario(nome, cpf, contato, email, login, senha, sexo, tipo, logradouro, numero, bairro, cidade, estado);
			u.setId(id);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
 }


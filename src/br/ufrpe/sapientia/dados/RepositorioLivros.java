package br.ufrpe.sapientia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ufrpe.sapientia.negocio.beans.Livro;

public class RepositorioLivros implements IRepositorioLivros{
	private Connection connection;
	
	public RepositorioLivros(){
		this.connection = new Conexao().construirConexao();
	}
	public boolean cadastrar(String titulo, String autor, String edicao, int ano, String isbn
			, String volume, String categoria, String resumo, int estoque, int total) throws SQLException{
		
		boolean s = false;
		String sql = "insert into livro (titulo_livro, autor_livro, edicao_livro,"
				+ " ano_livro, isbn_livro, volume_livro, categoria_livro, resumo_livro, estoque_livro, total_livro)"
				+ " value(?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, titulo);
			stmt.setString(2, autor);
			stmt.setString(3, edicao);
			stmt.setInt(4, ano);
			stmt.setString(5, isbn);
			stmt.setString(6, volume);
			stmt.setString(7, categoria);
			stmt.setString(8, resumo);
			stmt.setInt(9, estoque);
			stmt.setInt(10, total);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("Cadastrado");
		}catch(SQLException e){
			throw e;
		}
		return s;
	}
	
	public boolean remover(String Isbn) throws SQLException{
		boolean s = false;
		String sql = "delete from livro where isbn_livro = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, Isbn);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("removido");
		}catch(SQLException e){
			throw e;
		}
		return s;
	}
	
	public boolean atualizar(String isbn, String titulo, String autor, String edicao, int ano
			, String volume, String categoria, String resumo, int estoque, int total) throws SQLException{
		
		boolean s = false;
		String sql = "update livro set titulo_livro = ?, autor_livro = ?,"+
		"edicao_livro = ?, ano_livro = ?, volume_livro = ?, categoria_livro = ?,"+
		"resumo_livro = ?, estoque_livro = ?, total_livro = ? where isbn_livro = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, titulo);
			stmt.setString(2, autor);
			stmt.setString(3, edicao);
			stmt.setInt(4, ano);
			stmt.setString(5, volume);
			stmt.setString(6, categoria);
			stmt.setString(7, resumo);
			stmt.setInt(8, estoque);
			stmt.setInt(9, total);
			stmt.setString(10, isbn);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("atualizado");
		}catch(SQLException e){
			throw e;
		}
		return s;
	}
	
	public List<Livro> pesquisarTodos() throws SQLException{
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "select * from livro order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				livros.add(preencherLivro(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return livros;
	}
	
	public List<Livro> pesquisarTodosEstoque() throws SQLException{
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "select * from livro where estoque_livro > 0 order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				livros.add(preencherLivro(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return livros;
	}
	
	public List<Livro> pesquisarTitulo(String titulo) throws SQLException{
		List<Livro> livros = new ArrayList<Livro>();
		String consulta = '%' + titulo + '%';
		String sql = "select * from livro where titulo_livro like ? order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, consulta);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				livros.add(preencherLivro(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return livros;
	}
	
	public Livro pesquisarISBN(String isbn) throws SQLException{
		Livro l = null;
		String sql = "select * from livro where isbn_livro = ? order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, isbn);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				l = preencherLivro(rs);
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return l;
	}
	
	public List<Livro> pesquisarAutor(String autor) throws SQLException{
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "select * from livro where autor_livro = ? order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, autor);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				livros.add(preencherLivro(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return livros;

	}
	
	private Livro preencherLivro(ResultSet rs) throws SQLException{
		Livro l = null;
		try {
			String titulo = rs.getString("titulo_livro");
			String autor = rs.getString("autor_livro");
			String edicao = rs.getString("edicao_livro");
			int ano = rs.getInt("ano_livro");
			String isbn = rs.getString("isbn_livro");
			String volume = rs.getString("volume_livro");
			String categoria = rs.getString("categoria_livro");
			String resumo = rs.getString("resumo_livro");
			int estoque = rs.getInt("estoque_livro");
			int total = rs.getInt("total_livro");
			l = new Livro(titulo, autor, edicao, ano, isbn, categoria, resumo, volume, estoque, total);
		} catch (SQLException e) {
			throw e;
		}
		return l;
	}
}

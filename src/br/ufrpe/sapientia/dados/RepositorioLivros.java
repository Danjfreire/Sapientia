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
	public boolean cadastrar(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque){
		
		boolean s = false;
		String sql = "insert into livro (titulo_livro, autor_livro, edicao_livro,"
				+ " ano_livro, isbn_livro, volume_livro, categoria_livro, resumo_livro, estoque)"
				+ " value(?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, titulo);
			stmt.setString(2, autor);
			stmt.setString(3, edicao);
			stmt.setString(4, ano);
			stmt.setString(5, isbn);
			stmt.setString(6, volume);
			stmt.setString(7, categoria);
			stmt.setString(8, resumo);
			stmt.setInt(9, estoque);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("Cadastrado");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return s;
	}
	
	public boolean remover(String Isbn){
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
			e.printStackTrace();
		}
		return s;
	}
	
	public boolean atualizar(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque){
		
		boolean s = false;
		String sql = "update livro set titulo_livro = ?, autor_livro = ?,"+
		"edicao_livro = ?, ano_livro = ?, volume_livro = ?, categoria_livro = ?,"+
		"resumo_livro = ?  estoque = ? where isbn_livro = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, titulo);
			stmt.setString(2, autor);
			stmt.setString(3, edicao);
			stmt.setString(4, ano);
			stmt.setString(5, volume);
			stmt.setString(6, categoria);
			stmt.setString(7, resumo);
			stmt.setInt(8, estoque);
			stmt.setString(9, isbn);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("atualizado");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return s;
	}
	
	public List<Livro> pesquisarTodos(){
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "select * from livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				livros.add(preencherLivro(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return livros;
	}
	
	public List<Livro> pesquisarTitulo(String titulo){
		List<Livro> livros = new ArrayList<Livro>();
		String consulta = '%' + titulo + '%';
		String sql = "select * from livro where titulo_livro like ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, consulta);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				livros.add(preencherLivro(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return livros;
	}
	
	public Livro pesquisarISBN(String isbn){
		Livro l = null;
		String sql = "select * from livro where isbn_livro = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, isbn);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				l = preencherLivro(rs);
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return l;
	}
	
	private Livro preencherLivro(ResultSet rs){
		Livro l = null;
		try {
			int id = rs.getInt("id_livro");
			String titulo = rs.getString("titulo_livro");
			String autor = rs.getString("autor_livro");
			String edicao = rs.getString("edicao_livro");
			String ano = rs.getString("ano_livro");
			String isbn = rs.getString("isbn_livro");
			String volume = rs.getString("volume_livro");
			String categoria = rs.getString("categoria_livro");
			String resumo = rs.getString("resumo_livro");
			int estoque = rs.getInt("estoque");
			l = new Livro(titulo, autor, edicao, ano, isbn, categoria, resumo, volume, estoque);
			l.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
}

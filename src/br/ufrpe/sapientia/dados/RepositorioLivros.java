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
	public boolean cadastrar(Livro l){
		/*
		 * não esquecer de colocar o estoque
		 */
		boolean s = false;
		String sql = "insert into livro (titulo_livro, autor_livro, edicao_livro,"
				+ " ano_livro, isbn_livro, volume_livro, categoria_livro, resumo_livro)"
				+ " value(?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, l.getTitulo());
			stmt.setString(2, l.getAutor());
			stmt.setString(3, l.getEdicao());
			stmt.setString(4, l.getAno());
			stmt.setString(5, l.getISBN());
			stmt.setString(6, l.getVolume());
			stmt.setString(7, l.getCategoria());
			stmt.setString(8, l.getResumo());
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
	
	/*
	 *Precisa de um método que decrementa a quantidade de estoque de um livro, esse método será chamado na hora do empréstimo
	 *Esse método será chamado depois que o livro já tiver sido buscado então acho que pode receber um livro como parametro
	 *e só atualizaria o estoque 
	 */
	
	public boolean atualizar(Livro l){
		/*
		 * esse método vai ser basicamente utilizado para corrigir algum erro de cadastro ou para modificar
		 * o estoque do livro então tem que adicionar o estoque
		 */
		boolean s = false;
		String sql = "update livro set titulo_livro = ?, autor_livro = ?,"+
		"edicao_livro = ?, ano_livro = ?, volume_livro = ?, categoria_livro = ?,"+
		"resumo_livro = ? where isbn_livro = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, l.getTitulo());
			stmt.setString(2, l.getAutor());
			stmt.setString(3, l.getEdicao());
			stmt.setString(4, l.getAno());
			stmt.setString(5, l.getVolume());
			stmt.setString(6, l.getCategoria());
			stmt.setString(7, l.getResumo());
			stmt.setString(8, l.getISBN());
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("atualizado");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return s;
	}
	/*
	 * Seria bom um método que busca livros por categoria mas não é necessário agora
	 * 
	 * Ex:
	 * List<Livro>pesquisarCategoria(String categoria) 
	 * só busca livros da categoria passada
	 */
	
	public List<Livro> pesquisarTodos(){
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "select * from livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Livro l = new Livro();
				preencherLivro(rs,l);
				livros.add(l);
			}
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return livros;
	}
	
	public List<Livro> pesquisarTitulo(String titulo){
		/*
		 * se esse método retorna uma lista de livros, então idealmente ele deveria buscar livros com título parecido ou igual
		 * ao título passado como parametro, talvez uma boa forma de implementar isso seria utilizar o método contains de String
		 */
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "select * from livro where titulo_livro = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, titulo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Livro l = new Livro();
				preencherLivro(rs,l);
				livros.add(l);
			}
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return livros;
	}
	
	public Livro pesquisarISBN(String isbn){
		Livro l = new Livro();
		String sql = "select * from livro where isbn_livro = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, isbn);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				preencherLivro(rs,l);
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return l;
	}
	
	private void preencherLivro(ResultSet rs, Livro l){
		/*
		 * não esquecer do estoque
		 */
		try {
			l.setId(rs.getInt("id_livro"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			l.setTitulo(rs.getString("titulo_livro"));;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			l.setAutor(rs.getString("autor_livro"));;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			l.setEdicao(rs.getString("edicao_livro"));;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			l.setAno(rs.getString("ano_livro"));;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			l.setISBN(rs.getString("isbn_livro"));;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			l.setVolume(rs.getString("volume_livro"));;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			l.setCategoria(rs.getString("categoria_livro"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			l.setResumo(rs.getString("resumo_livro"));;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

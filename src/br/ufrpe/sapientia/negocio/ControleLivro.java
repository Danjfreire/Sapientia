package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.dados.*;

import java.sql.SQLException;
import java.util.List;

public class ControleLivro implements IControleLivro{

	private IRepositorioLivros repositorio;
	
	public ControleLivro(){
		this.repositorio = new RepositorioLivros();
	}

	@Override
	public boolean atualizarLivro(String isbn, String titulo, String autor, String edicao, int ano
			, String volume, String categoria, String resumo, int estoque, int total) throws Exception{
		return repositorio.atualizar(isbn, titulo, autor, edicao, ano, volume, categoria, resumo, estoque, total);
	}

	@Override
	public boolean removerLivro(String isbn) throws Exception{
		return repositorio.remover(isbn);
	}

	@Override
	public Livro buscaISBN(String isbn) throws Exception{
		return repositorio.pesquisarISBN(isbn);
	}
	
	@Override
	public List<Livro> buscaTitulo(String titulo) throws Exception{
		return repositorio.pesquisarTitulo(titulo);
	}
	
	@Override
	public List<Livro> buscaAutor(String autor) throws Exception{
		return repositorio.pesquisarAutor(autor);
	}
	
	@Override
	public List<Livro> pesquisarTodos() throws Exception{
		return repositorio.pesquisarTodos();
	}
	
	public List<Livro> pesquisarTodosEstoque() throws SQLException{
		return repositorio.pesquisarTodosEstoque();
	}
	
	@Override
	public boolean cadastraLivro(String titulo, String autor, String edicao, int ano, String isbn
			, String volume, String categoria, String resumo, int estoque, int total) throws Exception{
		return repositorio.cadastrar(titulo, autor,edicao , ano, isbn, volume, categoria, resumo, estoque, total);
	}
	
	
}

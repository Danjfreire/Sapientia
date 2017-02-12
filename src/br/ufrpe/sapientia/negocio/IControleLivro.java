package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.negocio.beans.*;

import java.sql.SQLException;
import java.util.List;

public interface IControleLivro {

	boolean atualizarLivro(String isbn, String titulo, String autor, String edicao, int ano
			, String volume, String categoria, String resumo, int estoque, int total) throws Exception;
	boolean removerLivro(String isbn) throws Exception;
	List<Livro> buscaTitulo(String titulo) throws Exception;
	Livro buscaISBN(String isbn) throws Exception;
	boolean cadastraLivro(String titulo, String autor, String edicao, int ano, String isbn
			, String volume, String categoria, String resumo, int estoque, int total) throws Exception;
	List<Livro> pesquisarTodos() throws Exception;
	List<Livro> buscaAutor(String autor) throws Exception;
	List<Livro> pesquisarTodosEstoque() throws SQLException;
}

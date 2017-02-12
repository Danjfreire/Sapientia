package br.ufrpe.sapientia.dados;
import br.ufrpe.sapientia.negocio.beans.*;

import java.sql.SQLException;
import java.util.List;

public interface IRepositorioLivros {

	boolean cadastrar(String titulo, String autor, String edicao, int ano, String isbn, 
			String volume, String categoria, String resumo, int estoque, int total) throws Exception;
	boolean remover(String isbn) throws Exception;
	boolean atualizar(String isbn, String titulo, String autor, String edicao, int ano
			, String volume, String categoria, String resumo, int estoque, int total) throws Exception;
	List<Livro>pesquisarTodos() throws Exception;
	List<Livro>pesquisarTitulo(String titulo) throws Exception;
	Livro pesquisarISBN(String isbn) throws SQLException;
	List<Livro> pesquisarAutor(String autor) throws Exception;
	List<Livro> pesquisarTodosEstoque() throws SQLException;
}

package br.ufrpe.sapientia.dados;
import br.ufrpe.sapientia.negocio.beans.*;
import java.util.List;

public interface IRepositorioLivros {

	boolean cadastrar(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque, int total) throws Exception;
	boolean remover(String isbn) throws Exception;
	boolean atualizar(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque, int total) throws Exception;
	List<Livro>pesquisarTodos() throws Exception;
	List<Livro>pesquisarTitulo(String titulo) throws Exception;
	Livro pesquisarISBN(String isbn) throws Exception;
	List<Livro> pesquisarAutor(String autor) throws Exception;
	
}

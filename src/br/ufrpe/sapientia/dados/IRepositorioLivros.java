package br.ufrpe.sapientia.dados;
import br.ufrpe.sapientia.negocio.beans.*;
import java.util.List;

public interface IRepositorioLivros {

	boolean cadastrar(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, String estoque);
	boolean remover(String isbn);
	boolean atualizar(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, String estoque);
	List<Livro>pesquisarTodos();
	List<Livro>pesquisarTitulo(String titulo);
	Livro pesquisarISBN(String isbn);
	
}

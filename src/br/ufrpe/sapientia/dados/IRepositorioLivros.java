package br.ufrpe.sapientia.dados;
import br.ufrpe.sapientia.negocio.beans.*;
import java.util.List;

public interface IRepositorioLivros {

	boolean cadastrar(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque, int total);
	boolean remover(String isbn);
	boolean atualizar(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque, int total);
	List<Livro>pesquisarTodos();
	List<Livro>pesquisarTitulo(String titulo);
	Livro pesquisarISBN(String isbn);
	
}

package br.ufrpe.sapientia.dados;
import br.ufrpe.sapientia.negocio.beans.*;
import java.util.List;

public interface IRepositorioLivros {

	boolean cadastrar(Livro livro);
	boolean remover(String isbn);
	boolean atualizar(Livro livro);
	List<Livro>pesquisarTodos();
	List<Livro>pesquisarTitulo(String titulo);
	Livro pesquisarISBN(String isbn);
	
}

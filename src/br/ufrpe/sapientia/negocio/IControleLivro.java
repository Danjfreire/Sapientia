package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.negocio.beans.*;
import java.util.List;

public interface IControleLivro {

	boolean atualizarLivro(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque, int total);
	boolean removerLivro(String isbn);
	List<Livro> buscaTitulo(String titulo);
	Livro buscaISBN(String isbn);
	boolean cadastraLivro(String titulo, String autor, String edicao, String ano, String isbn
			, String volume, String categoria, String resumo, int estoque, int total);
	List<Livro> pesquisarTodos();
	List<Livro> buscaAutor(String autor);
}

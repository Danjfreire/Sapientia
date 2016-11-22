package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.dados.*;
import java.util.List;

public class ControleLivro implements IControleLivro{

	private IRepositorioLivros repositorio;
	
	public ControleLivro(){
		this.repositorio = new RepositorioLivros();
	}

	@Override
	public boolean atualizarLivro(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, String estoque) {
		return repositorio.atualizar(isbn, titulo, autor, edicao, ano, volume, categoria, resumo, estoque);
	}

	@Override
	public boolean removerLivro(String isbn) {
		return repositorio.remover(isbn);
	}

	@Override
	public Livro buscaISBN(String isbn) {
		return repositorio.pesquisarISBN(isbn);
	}
	
	@Override
	public List<Livro> buscaTitulo(String titulo){
		return repositorio.pesquisarTitulo(titulo);
	}
	
	@Override
	public List<Livro> pesquisarTodos(){
		return repositorio.pesquisarTodos();
	}

	@Override
	public boolean cadastraLivro(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, String estoque) {
		return repositorio.cadastrar(isbn, titulo, autor, edicao, ano, volume, categoria, resumo, estoque);
	}
	
	
}

package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.negocio.beans.*;

public interface IControleLivro {

	boolean atualizarLivro(Livro livro);
	Livro removerLivro();
	Livro buscaLivro();
	boolean cadastraLivro();
}

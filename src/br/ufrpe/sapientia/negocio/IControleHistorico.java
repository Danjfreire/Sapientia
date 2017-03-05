package br.ufrpe.sapientia.negocio;

import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Historico;

public interface IControleHistorico {

	List<Historico> pesquisarHistoricoTitulo(String titulo) throws Exception;
	List<Historico> pesquisarHistoricoFuncionario(String funcionario_cpf) throws Exception;
	List<Historico> pesquisarHistoricoCliente(String cliente_cpf) throws Exception;
	List<Historico> pesquisarHistoricoISBN(String isbn_livro) throws Exception;
	List<Historico> pesquisarHistoricoTodos() throws Exception;
	
}

package br.ufrpe.sapientia.negocio;
import java.util.List;

import br.ufrpe.sapientia.dados.*;
import br.ufrpe.sapientia.negocio.beans.Historico;

public class ControleHistorico implements IControleHistorico{

	private IRepositorioHistorico repositorio;
	
	public ControleHistorico(){
		this.repositorio = new RepositorioHistorico();
	}

	@Override
	public List<Historico> pesquisarHistoricoTitulo(String titulo) throws Exception {
		return repositorio.pesquisarHistoricoTitulo(titulo);
	}

	@Override
	public List<Historico> pesquisarHistoricoFuncionario(String funcionario_cpf) throws Exception {
		return repositorio.pesquisarHistoricoFuncionario(funcionario_cpf);
	}

	@Override
	public List<Historico> pesquisarHistoricoCliente(String cliente_cpf) throws Exception {
		return repositorio.pesquisarHistoricoCliente(cliente_cpf);
	}

	@Override
	public List<Historico> pesquisarHistoricoISBN(String isbn_livro) throws Exception {
		return repositorio.pesquisarHistoricoISBN(isbn_livro);
	}

	@Override
	public List<Historico> pesquisarHistoricoTodos() throws Exception {
		return repositorio.pesquisarHistoricoTodos();
	}
	
	
}

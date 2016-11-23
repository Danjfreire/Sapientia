package br.ufrpe.sapientia.dados;

import java.util.Calendar;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;

public interface IRepositorioEmprestimos {

    boolean cadastrar(Calendar dataEmprestimo, Calendar dataDevolucao, String status, int funcionario, int cliente);
	boolean remove(int id);
	boolean atualizar(int id, String status);
	List<Emprestimo> pesquisarTodos();
	List<Emprestimo> pesquisarEmrprestimoCliente(int id);
	List<Emprestimo> pesquisarEmrprestimo(int id);
}

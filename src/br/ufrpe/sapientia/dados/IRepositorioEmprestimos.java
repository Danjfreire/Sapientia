package br.ufrpe.sapientia.dados;

import java.util.Calendar;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;

public interface IRepositorioEmprestimos {

    boolean cadastrar(Calendar dataEmprestimo, Calendar dataDevolucao, String status, String funcionario, String cliente,String isbn);
	//cadastrar(Calendar dataEmprestimo, Calendar dataDevolucao, String status, Usuario funcionario, Usuario cliente
    boolean remove(int id);
	boolean atualizar(int id, String status);
	List<Emprestimo> pesquisarTodos();
	//List<Emprestimo> pesquisarEmrprestimoCliente(int id);
	List<Emprestimo> pesquisarEmrprestimoCliente(String cpf_cliente, String status);
	//List<Emprestimo> pesquisarEmrprestimo(int id);
	List<Emprestimo> pesquisarEmrprestimoFuncionario(String cpf_funcionario, String status);
	
}

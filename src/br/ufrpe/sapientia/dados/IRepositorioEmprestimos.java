package br.ufrpe.sapientia.dados;

import java.util.Calendar;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;

public interface IRepositorioEmprestimos {

    boolean cadastrar(String dataEmprestimo, String dataDevolucao, String status, String funcionario, String cliente,String isbn) throws Exception;
	//cadastrar(Calendar dataEmprestimo, Calendar dataDevolucao, String status, Usuario funcionario, Usuario cliente
    boolean remove(int id) throws Exception;
	boolean atualizar(int id, String status) throws Exception;
	List<Emprestimo> pesquisarTodos() throws Exception;
	//List<Emprestimo> pesquisarEmrprestimoCliente(int id);
	List<Emprestimo> pesquisarEmrprestimoCliente(String cpf_cliente, String status) throws Exception;
	//List<Emprestimo> pesquisarEmrprestimo(int id);
	List<Emprestimo> pesquisarEmrprestimoFuncionario(String cpf_funcionario, String status) throws Exception;
	
}

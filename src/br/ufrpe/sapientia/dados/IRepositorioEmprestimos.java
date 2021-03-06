package br.ufrpe.sapientia.dados;

import java.sql.SQLException;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;

public interface IRepositorioEmprestimos {

    boolean cadastrar(String dataEmprestimo, String dataDevolucao, String status, String funcionario, String cliente,String isbn) throws Exception;
    boolean remove(int id) throws Exception;
	boolean atualizar(int id, String status) throws Exception;
	List<Emprestimo> pesquisarTodos() throws Exception;
	List<Emprestimo> pesquisarEmprestimoCliente(String cpf_cliente) throws Exception;
	List<Emprestimo> pesquisarEmprestimoFuncionario(String cpf_funcionario) throws Exception;
	List<Emprestimo> pesquisarEmprestimoTitulo(String titulo) throws Exception;
	List<Emprestimo> pesquisarEmprestimoISBN(String isbn) throws Exception;
//	List<Emprestimo> selecaoEmprestimoISBN(String isbn_livro, boolean tipo) throws Exception;
//	List<Emprestimo> selecaoEmprestimoTitulo(String titulo_livro, boolean tipo) throws Exception
}

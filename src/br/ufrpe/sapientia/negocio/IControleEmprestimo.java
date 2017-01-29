package br.ufrpe.sapientia.negocio;

import java.util.List;
import java.util.Calendar;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public interface IControleEmprestimo {

	//boolean efetuarEmprestimo();
	//boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status, 
	//Usuario funcionario, Usuario cliente);

	boolean efetuarEmprestimo(String dataEmprestimo, String dataDevolucao, String status, String funcionario
			,String cliente, String isbn) throws Exception;

	List<Emprestimo>verificarPendenciasLivro(String isbn);
	List<Emprestimo>verificarPendenciasCliente(String cpf) throws Exception;
	List<Emprestimo>verificarEmprestimoLivro(String titulo) throws Exception;
	List<Emprestimo>verificarEmprestimoCliente(String cpf) throws Exception;
	List<Emprestimo>verificarEmprestimoISBN(String isbn)throws Exception;
	List<Emprestimo>verificarEmprestimoFunc(String cpf)throws Exception;
	List<Emprestimo>verificarTodosEmprestimos()throws Exception;
	
}
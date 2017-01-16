package br.ufrpe.sapientia.negocio;

import java.util.Calendar;

public interface IControleEmprestimo {

	//boolean efetuarEmprestimo();
	//boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status, 
	//Usuario funcionario, Usuario cliente);

	boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status, String funcionario
			,String cliente, String isbn);

}
package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.dados.*;
import java.util.Calendar;

public class ControleEmprestimo implements IControleEmprestimo{

	private IRepositorioEmprestimos repositorio ;
	
	public ControleEmprestimo(){
		repositorio = new RepositorioEmprestimos();
	}

	@Override
	public boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status, String funcionario
			,String cliente, String isbn) {
		return repositorio.cadastrar(dataEmprestimo, dataDevolucao, status, funcionario, cliente, isbn);
	
	}
	
//	public boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status,
//			Usuario funcionario, Usuario cliente)
//	return repositorio.cadastrar(dataEmprestimo, dataDevolucao, status, funcionario, cliente); 
//}
	
}

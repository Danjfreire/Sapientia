package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.dados.*;

public class ControleEmprestimo implements IControleEmprestimo{

	private IRepositorioEmprestimos repositorio ;
	
	public ControleEmprestimo(){
		repositorio = new RepositorioEmprestimos();
	}

	@Override
	public boolean efetuarEmprestimo() {
		// TODO Auto-generated method stub
		return false;
	}
	
//	public boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status,
//			Usuario funcionario, Usuario cliente)
//	return repositorio.cadastrar(dataEmprestimo, dataDevolucao, status, funcionario, cliente); 
//}
	
}

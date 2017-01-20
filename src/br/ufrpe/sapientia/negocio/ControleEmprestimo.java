package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.dados.*;
import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

import java.util.List;
import java.util.Calendar;

public class ControleEmprestimo implements IControleEmprestimo{

	private IRepositorioEmprestimos repositorio ;
	
	public ControleEmprestimo(){
		repositorio = new RepositorioEmprestimos();
	}

	@Override
	public boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status, String funcionario
			,String cliente, String isbn) throws Exception{
		return repositorio.cadastrar(dataEmprestimo, dataDevolucao, status, funcionario, cliente, isbn);
	
	}
	
	@Override
	public List<Emprestimo> verificarPendenciasLivro(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emprestimo> verificarPendenciasCliente(String cpf, String status) throws Exception{
		return repositorio.pesquisarEmrprestimoCliente(cpf, status);
	}

	@Override
	public List<Emprestimo> verificarEmprestimoLivro(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emprestimo> verificarEmprestimoCliente(String cpf) throws Exception{
		return repositorio.pesquisarEmrprestimoCliente(cpf, "E");
	}

	
//	public boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status,
//			Usuario funcionario, Usuario cliente)
//	return repositorio.cadastrar(dataEmprestimo, dataDevolucao, status, funcionario, cliente); 
//}
	
}

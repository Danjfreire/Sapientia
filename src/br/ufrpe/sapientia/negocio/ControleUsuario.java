package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.negocio.beans.*;
import br.ufrpe.sapientia.dados.*;

public class ControleUsuario implements IControleUsuario{

	private IRepositorioUsuarios repositorio;	
	
	public ControleUsuario(){
		this.repositorio = new RepositorioUsuarios();
	}

	@Override
	public boolean atualizarFuncionario(Usuario funcionario){ //AJUSTAR
		return false; 
	}

	@Override
	public boolean removerUsuario(String cpf) {
		return repositorio.remover(cpf);
	}

	@Override
	public Usuario buscaFuncionario() {
		return null;
	}

	@Override
	public boolean atualizarCliente(Usuario cliente) { //AJUSTAR
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario buscaCliente() { //AJUSTAR
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CadastrarUsuario(Usuario usuario) {
		return repositorio.cadastrar(usuario);
	}

	@Override
	public boolean atualizarADM() { //AJUSTAR
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

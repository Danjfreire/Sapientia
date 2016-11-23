package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.negocio.beans.*;
import br.ufrpe.sapientia.dados.*;
import java.util.List;

public class ControleUsuario implements IControleUsuario{

	private IRepositorioUsuarios repositorio;	
	
	public ControleUsuario(){
		this.repositorio = new RepositorioUsuarios();
	}

	@Override
	public boolean atualizarUsuario(String cpf, String nome, String contato, String endereco, 
			String email, String login, String senha, String tipo, String sexo){ //AJUSTAR
		return repositorio.atualizar(cpf, nome, contato, endereco, email, login, senha, tipo, sexo); 
	}

	@Override
	public boolean removerUsuario(String cpf) {
		return repositorio.remover(cpf);
	}

	@Override
	public Usuario buscarUsuarioCPF(String cpf,String tipo) {
		return repositorio.pesquisarCPF(cpf, tipo);
	}


	@Override
	public List<Usuario> buscarUsuarioNome(String nome, String tipo) { //AJUSTAR
		return repositorio.pesquisarNome(nome, tipo);
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
	
	@Override
	public List<Usuario> pesquisarTodos(String tipo){
		return repositorio.pesquisarTodos(tipo);
	}
	
}

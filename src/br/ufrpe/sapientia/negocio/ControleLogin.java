package br.ufrpe.sapientia.negocio;

import br.ufrpe.sapientia.negocio.beans.Usuario;
import br.ufrpe.sapientia.dados.*;

public class ControleLogin implements IControleLogin{

	private IRepositorioUsuarios repositorio;
	public ControleLogin(){
		this.repositorio = new RepositorioUsuarios();
	}

	@Override
	public Usuario efetuarLogin(String login, String senha) {
		return repositorio.pesquisarLoginSenha(login, senha);
	}
	
}

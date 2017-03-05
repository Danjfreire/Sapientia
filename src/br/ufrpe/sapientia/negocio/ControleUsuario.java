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
	public boolean atualizarUsuario(String cpf, String nome, String contato, String email, 
			String login, String senha, String tipo, String sexo, String logradouro, int numero, String bairro,
			String cidade, String estado) throws Exception{ //AJUSTAR
		return repositorio.atualizar(cpf, nome, contato, email, login, senha, tipo, sexo, logradouro, numero, bairro, cidade, estado); 
	}

	@Override
	public boolean removerUsuario(String cpf) throws Exception{
		return repositorio.remover(cpf);
	}

	@Override
	public Usuario buscarUsuarioCPF(String cpf,String tipo) throws Exception{
		return repositorio.pesquisarCPF(cpf, tipo);
	}


	@Override
	public List<Usuario> buscarUsuarioNome(String nome, String tipo) throws Exception{ //AJUSTAR
		return repositorio.pesquisarNome(nome, tipo);
	}

	@Override
	public boolean CadastrarUsuario(Usuario usuario) throws Exception{
		return repositorio.cadastrar(usuario);
	}

	@Override
	public boolean atualizarADM() throws Exception{ //AJUSTAR
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Usuario> pesquisarTodos(String tipo) throws Exception{
		return repositorio.pesquisarTodos(tipo);
	}
	
}

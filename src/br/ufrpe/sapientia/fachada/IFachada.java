package br.ufrpe.sapientia.fachada;

import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public interface IFachada {

	
	boolean efetuarEmprestimo();
	List<Emprestimo> verificarPendenciasLivro(Livro livro);
	List<Emprestimo> verificarPendenciasCliente(Usuario cliente);
	List<Emprestimo> verificarEmprestimoLivro(Livro livro);
	List<Emprestimo> verificarEmprestimoCliente(Usuario cliente);
	boolean atualizarLivro(Livro livro);
	Livro removerLivro();
	Livro buscaLivro();
	boolean cadastraLivro();
	Usuario efetuarLogin();
	boolean removerUsuario(String cpf);
	Usuario buscarUsuarioCPF(String cpf , String tipo);
	boolean atualizarUsuario(String cpf, String nome, String contato, String endereco, 
			String email, String login, String senha, String tipo, String sexo);
	//Usuario removerCliente();
	List<Usuario> buscarUsuarioNome(String nome, String tipo);
	boolean CadastrarUsuario(Usuario usuario);
	boolean atualizarADM();
	
}

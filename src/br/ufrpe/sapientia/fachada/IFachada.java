package br.ufrpe.sapientia.fachada;

import java.util.ArrayList;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public interface IFachada {

	
	boolean efetuarEmprestimo();
	ArrayList<Emprestimo> verificarPendenciasLivro(Livro livro);
	ArrayList<Emprestimo> verificarPendenciasCliente(Usuario cliente);
	ArrayList<Emprestimo> verificarEmprestimoLivro(Livro livro);
	ArrayList<Emprestimo> verificarEmprestimoCliente(Usuario cliente);
	boolean atualizarLivro(Livro livro);
	Livro removerLivro();
	Livro buscaLivro();
	boolean cadastraLivro();
	Usuario efetuarLogin();
	boolean atualizarFuncionario(Usuario funcionario);
	boolean removerUsuario(String cpf);
	Usuario buscaFuncionario();
	boolean atualizarCliente(Usuario cliente);
	//Usuario removerCliente();
	Usuario buscaCliente();
	boolean CadastrarUsuario(Usuario usuario);
	boolean atualizarADM();
	
}

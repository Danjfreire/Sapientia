package br.ufrpe.sapientia.fachada;

import java.util.Calendar;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public interface IFachada {

	
	boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status, String funcionario
			,String cliente, String isbn);
	//efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status, Usuario funcionario, Usuario cliente)
	List<Emprestimo> verificarPendenciasLivro(String isbn);
	List<Emprestimo> verificarPendenciasCliente(String cpf, String status);
	List<Emprestimo> verificarEmprestimoLivro(String isbn);
	List<Emprestimo> verificarEmprestimoCliente(String cpf);
	
	boolean atualizarLivro(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque, int total);
	boolean removerLivro(String isbn);
	List<Livro> buscaLivroTitulo(String titulo);
	Livro buscaLivroISBN(String isbn);
	List<Livro> buscaLivroAutor(String autor);
	List<Livro>exibirLivros();
	boolean cadastraLivro(String titulo, String autor, String edicao, String ano, String isbn
			, String volume, String categoria, String resumo, int estoque, int total);
	
	Usuario efetuarLogin(String login, String senha);
	
	boolean removerUsuario(String cpf);
	Usuario buscarUsuarioCPF(String cpf , String tipo);
	boolean atualizarUsuario(String cpf, String nome, String contato, String endereco, 
			String email, String login, String senha, String tipo, String sexo);
	
	List<Usuario> buscarUsuarioNome(String nome, String tipo);
	List<Usuario> exibirUsuarios(String tipo);
	boolean CadastrarUsuario(Usuario usuario);
	boolean atualizarADM();
	
	

	
}

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
	
	boolean atualizarLivro(String isbn, int id, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, String estoque);
	boolean removerLivro(String isbn, int id);
	List<Livro> buscaLivroTitulo(String titulo);
	Livro buscaLivroISBN(String isbn);
	List<Livro>exibirLivros();
	boolean cadastraLivro(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, String estoque);
	
	Usuario efetuarLogin();
	
	boolean removerUsuario(String cpf);
	Usuario buscarUsuarioCPF(String cpf , String tipo);
	boolean atualizarUsuario(String cpf, String nome, String contato, String endereco, 
			String email, String login, String senha, String tipo, String sexo);
	//Usuario removerCliente();
	List<Usuario> buscarUsuarioNome(String nome, String tipo);
	List<Usuario> exibirUsuarios();
	boolean CadastrarUsuario(Usuario usuario);
	boolean atualizarADM();
	
}

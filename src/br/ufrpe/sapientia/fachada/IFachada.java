package br.ufrpe.sapientia.fachada;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Historico;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public interface IFachada {

	
	boolean efetuarEmprestimo(String dataEmprestimo, String dataDevolucao, String status, String funcionario
			,String cliente, String isbn) throws Exception;
	//efetuarEmprestimo(Calendar dataEmprestimo, Calendar dataDevolucao, String status, Usuario funcionario, Usuario cliente)
	List<Emprestimo> verificarPendenciasLivro(String isbn);
	List<Emprestimo> verificarPendenciasCliente(String cpf) throws Exception;
	List<Emprestimo> verificarEmprestimoLivro(String titulo) throws Exception;
	List<Emprestimo> verificarEmprestimoCliente(String cpf) throws Exception;
	List<Emprestimo> verificarEmprestimoISBN(String isbn) throws Exception;
	List<Emprestimo> verificarEmprestimoFunc(String cpf) throws Exception;
	List<Emprestimo> verificarTodosEmprestimos() throws Exception;
	boolean removerEmprestimo(int id) throws Exception;
	
	List<Historico> pesquisarHistoricoTitulo(String titulo) throws Exception;
	List<Historico> pesquisarHistoricoFuncionario(String funcionario_cpf) throws Exception;
	List<Historico> pesquisarHistoricoCliente(String cliente_cpf) throws Exception;
	List<Historico> pesquisarHistoricoISBN(String isbn_livro) throws Exception;
	List<Historico> pesquisarHistoricoTodos() throws Exception;
	
	boolean atualizarLivro(String isbn, String titulo, String autor, String edicao, int ano
			, String volume, String categoria, String resumo, int estoque, int total) throws Exception;
	boolean removerLivro(String isbn) throws Exception;
	List<Livro> buscaLivroTitulo(String titulo) throws Exception;
	Livro buscaLivroISBN(String isbn) throws Exception;
	List<Livro> buscaLivroAutor(String autor) throws Exception;
	List<Livro>exibirLivros() throws Exception;
	List<Livro> pesquisarLivrosEstoque() throws SQLException;
	boolean cadastraLivro(String titulo, String autor, String edicao, int ano, String isbn
			, String volume, String categoria, String resumo, int estoque, int total) throws Exception;
	
	Usuario efetuarLogin(String login, String senha) throws Exception;
	
	boolean removerUsuario(String cpf) throws Exception;
	Usuario buscarUsuarioCPF(String cpf , String tipo) throws Exception;
	boolean atualizarUsuario(String cpf, String nome, String contato, 
			String email, String login, String senha, String tipo, String sexo,
			String logradouro, int numero, String bairro, String cidade, String estado) throws Exception;
	
	List<Usuario> buscarUsuarioNome(String nome, String tipo) throws Exception;
	List<Usuario> exibirUsuarios(String tipo) throws Exception;
	boolean CadastrarUsuario(Usuario usuario) throws Exception;
	boolean atualizarADM() throws Exception;
	
	

	
}

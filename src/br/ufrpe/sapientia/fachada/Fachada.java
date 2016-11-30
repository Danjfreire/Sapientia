package br.ufrpe.sapientia.fachada;
import java.util.List;

import br.ufrpe.sapientia.negocio.*;
import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public class Fachada implements IFachada {

	private IControleEmprestimo controleEmprestimo;
	private IControleHistorico controleHistorico;
	private IControleLivro controleLivro;
	private IControleLogin controleLogin;
	private IControleUsuario controleUsuario;
	public static Fachada instance;
	
	private Fachada(){
		this.controleEmprestimo = new ControleEmprestimo();
		this.controleHistorico = new ControleHistorico();
		this.controleLivro = new ControleLivro();
		this.controleUsuario = new ControleUsuario();
		this.controleLogin = new ControleLogin();
	}
	
	public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		return instance;
	}

	@Override
	public boolean efetuarEmprestimo() {
		return controleEmprestimo.efetuarEmprestimo();
	}

	@Override
	public List<Emprestimo> verificarPendenciasLivro(Livro livro) {
		return controleHistorico.verificarPendenciasLivro(livro);
	}

	@Override
	public List<Emprestimo> verificarPendenciasCliente(Usuario cliente) {
		return controleHistorico.verificarPendenciasCliente(cliente);
	}

	@Override
	public List<Emprestimo> verificarEmprestimoLivro(Livro livro) {
		return controleHistorico.verificarEmprestimoLivro(livro);
	}
	
	@Override
	public List<Emprestimo> verificarEmprestimoCliente(Usuario cliente) {
		return controleHistorico.verificarEmprestimoCliente(cliente);
	}

	@Override
	public boolean atualizarLivro(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque, int total) {
		return controleLivro.atualizarLivro(isbn, titulo, autor, edicao, ano, volume, categoria, resumo, estoque, total);
	}

	@Override
	public boolean removerLivro(String isbn) {
		return controleLivro.removerLivro(isbn);
	}

	@Override
	public Livro buscaLivroISBN(String isbn) {
		return controleLivro.buscaISBN(isbn);
	}
	
	@Override
	public List<Livro> buscaLivroTitulo(String titulo){
		return controleLivro.buscaTitulo(titulo);
	}
	
	@Override
	public List<Livro> exibirLivros(){
		return controleLivro.pesquisarTodos();
	}

	@Override
	public boolean cadastraLivro(String isbn, String titulo, String autor, String edicao, String ano
			, String volume, String categoria, String resumo, int estoque, int total) {
		return controleLivro.cadastraLivro(isbn, titulo, autor, edicao, ano, volume, categoria, resumo, estoque, total);
	}

	@Override
	public Usuario efetuarLogin(String login, String senha) {
		return controleLogin.efetuarLogin(login, senha);
	}

	@Override
	public boolean atualizarUsuario(String cpf, String nome, String contato, String endereco, 
			String email, String login, String senha, String tipo, String sexo) {
		return controleUsuario.atualizarUsuario(cpf, nome, contato, endereco, email, login, senha, tipo, sexo);
	}

	@Override
	public boolean removerUsuario(String cpf) {
		return controleUsuario.removerUsuario(cpf);
	}

	@Override
	public Usuario buscarUsuarioCPF(String cpf, String tipo) {
		return controleUsuario.buscarUsuarioCPF(cpf, tipo);
	}

	@Override
	public List<Usuario> exibirUsuarios(String tipo){
		return controleUsuario.pesquisarTodos(tipo);
	}
	//@Override
	//public Usuario removerCliente() {
	//	return controleUsuario.removerCliente();
	//}

	@Override
	public List<Usuario> buscarUsuarioNome(String nome, String tipo) {
		return controleUsuario.buscarUsuarioNome(nome, tipo);
	}

	@Override
	public boolean CadastrarUsuario(Usuario usuario) {
		return controleUsuario.CadastrarUsuario(usuario);
	}

	@Override
	public boolean atualizarADM() {
		return controleUsuario.atualizarADM();
	}
	
	
}

package br.ufrpe.sapientia.fachada;

import java.util.List;
import br.ufrpe.sapientia.negocio.*;
import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Historico;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public class Fachada implements IFachada {

	private IControleEmprestimo controleEmprestimo;
	private IControleLivro controleLivro;
	private IControleLogin controleLogin;
	private IControleUsuario controleUsuario;
	private IControleHistorico controleHistorico;
	public static Fachada instance;

	private Fachada() {
		this.controleEmprestimo = new ControleEmprestimo();
		this.controleLivro = new ControleLivro();
		this.controleUsuario = new ControleUsuario();
		this.controleLogin = new ControleLogin();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	@Override
	public boolean efetuarEmprestimo(String dataEmprestimo, String dataDevolucao, String status, String funcionario,
			String cliente, String isbn) throws Exception{
		return controleEmprestimo.efetuarEmprestimo(dataEmprestimo, dataDevolucao, status, funcionario, cliente, isbn);
	}
	// public boolean efetuarEmprestimo(Calendar dataEmprestimo, Calendar
	// dataDevolucao, String status, Usuario funcionario, Usuario cliente){
	// return controleEmprestimo.efetuarEmprestimo();
	// }

	@Override
	public List<Emprestimo> verificarPendenciasLivro(String isbn) {
		return controleEmprestimo.verificarPendenciasLivro(isbn);
	}

	@Override
	public List<Emprestimo> verificarPendenciasCliente(String cpf) throws Exception{
		return controleEmprestimo.verificarPendenciasCliente(cpf);
	}

	@Override
	public List<Emprestimo> verificarEmprestimoLivro(String titulo) throws Exception{
		return controleEmprestimo.verificarEmprestimoLivro(titulo);
	}
	
	@Override
	public List<Emprestimo> verificarEmprestimoISBN(String isbn) throws Exception{
		return controleEmprestimo.verificarEmprestimoISBN(isbn);
	}

	@Override
	public List<Emprestimo> verificarEmprestimoCliente(String cpf) throws Exception{
		return controleEmprestimo.verificarEmprestimoCliente(cpf);
	}
	
	@Override
	public List<Emprestimo> verificarEmprestimoFunc(String cpf) throws Exception{
		return controleEmprestimo.verificarEmprestimoFunc(cpf);
	}
	
	@Override
	public List<Emprestimo> verificarTodosEmprestimos()throws Exception{
		return controleEmprestimo.verificarTodosEmprestimos();
	}
	
	@Override
	public boolean removerEmprestimo(int id)throws Exception{
		return controleEmprestimo.removerEmprestimo(id);
	}
	
	@Override
	public boolean atualizarLivro(String isbn, String titulo, String autor, String edicao, int ano, String volume,
			String categoria, String resumo, int estoque, int total) throws Exception{
		return controleLivro.atualizarLivro(isbn, titulo, autor, edicao, ano, volume, categoria, resumo, estoque,
				total);
	}

	@Override
	public boolean removerLivro(String isbn) throws Exception{
		return controleLivro.removerLivro(isbn);
	}

	@Override
	public Livro buscaLivroISBN(String isbn) throws Exception{
		return controleLivro.buscaISBN(isbn);
	}

	@Override
	public List<Livro> buscaLivroAutor(String autor) throws Exception{
		return controleLivro.buscaAutor(autor);
	}

	@Override
	public List<Livro> buscaLivroTitulo(String titulo) throws Exception{
		return controleLivro.buscaTitulo(titulo);
	}

	@Override
	public List<Livro> exibirLivros() throws Exception{
		return controleLivro.pesquisarTodos();
	}

	@Override
	public boolean cadastraLivro(String titulo, String autor, String edicao, int ano, String isbn, String volume,
			String categoria, String resumo, int estoque, int total) throws Exception{
		return controleLivro.cadastraLivro(titulo, autor, edicao, ano, isbn, volume, categoria, resumo, estoque, total);
	}

	@Override
	public Usuario efetuarLogin(String login, String senha) throws Exception{
		return controleLogin.efetuarLogin(login, senha);
	}

	@Override
	public boolean atualizarUsuario(String cpf, String nome, String contato, String email,
			String login, String senha, String tipo, String sexo, String logradouro, int numero,
			String bairro, String cidade, String estado) throws Exception{
		return controleUsuario.atualizarUsuario(cpf, nome, contato, email, login, senha, tipo, sexo, logradouro, numero, bairro, cidade, estado);
	}

	@Override
	public boolean removerUsuario(String cpf) throws Exception{
		return controleUsuario.removerUsuario(cpf);
	}

	@Override
	public Usuario buscarUsuarioCPF(String cpf, String tipo) throws Exception{
		return controleUsuario.buscarUsuarioCPF(cpf, tipo);
	}

	@Override
	public List<Usuario> exibirUsuarios(String tipo) throws Exception{
		return controleUsuario.pesquisarTodos(tipo);
	}
	// @Override
	// public Usuario removerCliente() {
	// return controleUsuario.removerCliente();
	// }

	@Override
	public List<Usuario> buscarUsuarioNome(String nome, String tipo) throws Exception{
		return controleUsuario.buscarUsuarioNome(nome, tipo);
	}

	@Override
	public boolean CadastrarUsuario(Usuario usuario) throws Exception{
		return controleUsuario.CadastrarUsuario(usuario);
	}

	@Override
	public boolean atualizarADM() throws Exception{
		return controleUsuario.atualizarADM();
	}

	@Override
	public List<Historico> pesquisarHistoricoTitulo(String titulo) throws Exception {
		return controleHistorico.pesquisarHistoricoTitulo(titulo);
	}

	@Override
	public List<Historico> pesquisarHistoricoFuncionario(String funcionario_cpf) throws Exception {
		return controleHistorico.pesquisarHistoricoFuncionario(funcionario_cpf);
	}

	@Override
	public List<Historico> pesquisarHistoricoCliente(String cliente_cpf) throws Exception {
		return controleHistorico.pesquisarHistoricoCliente(cliente_cpf);
	}

	@Override
	public List<Historico> pesquisarHistoricoISBN(String isbn_livro) throws Exception {
		return controleHistorico.pesquisarHistoricoISBN(isbn_livro);
	}

	@Override
	public List<Historico> pesquisarHistoricoTodos() throws Exception {
		return controleHistorico.pesquisarHistoricoTodos();
	}

}

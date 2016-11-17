package br.ufrpe.sapientia.fachada;
import java.util.ArrayList;

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
	public ArrayList<Emprestimo> verificarPendenciasLivro(Livro livro) {
		return controleHistorico.verificarPendenciasLivro(livro);
	}

	@Override
	public ArrayList<Emprestimo> verificarPendenciasCliente(Usuario cliente) {
		return controleHistorico.verificarPendenciasCliente(cliente);
	}

	@Override
	public ArrayList<Emprestimo> verificarEmprestimoLivro(Livro livro) {
		return controleHistorico.verificarEmprestimoLivro(livro);
	}
	
	@Override
	public ArrayList<Emprestimo> verificarEmprestimoCliente(Usuario cliente) {
		return controleHistorico.verificarEmprestimoCliente(cliente);
	}

	@Override
	public boolean atualizarLivro(Livro livro) {
		return controleLivro.atualizarLivro(livro);
	}

	@Override
	public Livro removerLivro() {
		return controleLivro.removerLivro();
	}

	@Override
	public Livro buscaLivro() {
		return controleLivro.buscaLivro();
	}

	@Override
	public boolean cadastraLivro() {
		return controleLivro.cadastraLivro();
	}

	@Override
	public Usuario efetuarLogin() {
		return controleLogin.efetuarLogin();
	}

	@Override
	public boolean atualizarFuncionario(Usuario funcionario) {
		return controleUsuario.atualizarFuncionario(funcionario);
	}

	@Override
	public Usuario removerFuncionario() {
		return controleUsuario.removerFuncionario();
	}

	@Override
	public Usuario buscaFuncionario() {
		return controleUsuario.buscaFuncionario();
	}

	@Override
	public boolean atualizarCliente(Usuario cliente) {
		return controleUsuario.atualizarCliente(cliente);
	}

	@Override
	public Usuario removerCliente() {
		return controleUsuario.removerCliente();
	}

	@Override
	public Usuario buscaCliente() {
		return controleUsuario.buscaCliente();
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

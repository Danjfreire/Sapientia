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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Emprestimo> verificarPendenciasLivro(Livro livro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Emprestimo> verificarPendenciasCliente(Usuario cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Emprestimo> verificarEmprestimoLivro(Livro livro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Emprestimo> verificarEmprestimoCliente(Usuario cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizarLivro(Livro livro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Livro removerLivro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livro buscaLivro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastraLivro() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario efetuarLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizarFuncionario(Usuario funcionario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario removerFuncionario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscaFuncionario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizarCliente(Usuario cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario removerCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscaCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CadastrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizarADM() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

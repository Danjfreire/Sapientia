package br.ufrpe.sapientia.dados;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Historico;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public class Testes {
	public static void main(String [] args){
		RepositorioUsuarios ru = new RepositorioUsuarios();
		
		
			try {
				Usuario u = new Usuario("jose", "1", "84009198", "wallace@gmail", "j", "123", "M", "C", "Rua dracena", 241, "sancho", "recife", "PE");
				ru.cadastrar(u);
				Usuario u2 = new Usuario("jose", "2", "84009198", "wallace@gmail", "jo", "123", "M", "F", "Rua dracena", 241, "sancho", "recife", "PE");
				ru.cadastrar(u2);
				//ru.atualizar("07665546", "jose", "84009198", "wallace@gmail", "jool", "123", "M", "F", "Rua dracena", 241, "sancho", "recife", "PE");
			} catch (SQLException e1) {
				System.out.println(e1.getErrorCode() + "," + e1.getMessage());
				
			}
		List<Usuario> usuarios= new ArrayList<Usuario>();
		try {
			usuarios = ru.pesquisarTodos("F");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Usuario user : usuarios)
			System.out.println(user);
		try {
			usuarios = ru.pesquisarTodos("C");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Usuario user : usuarios)
			System.out.println(user);
		//ru.remover("78569");
		//ru.cadastrar(u);
		//ru.atualizar("785690", "wallace", "984009198", "Vila chan", "wallacesantana843@gmail", "wallace", "radiopatrulha", "C", "M");
		
		//System.out.println(ru.pesquisarNome("wallace", "C"));
		//List<Usuario> usuarios= new ArrayList<Usuario>();
		//usuarios = ru.pesquisarTodos();
		/*for(Usuario user : usuarios)
			System.out.println(user);*/
		
		RepositorioLivros rl = new RepositorioLivros();
		//rl.remover("12");
		//rl.atualizar("129", "harry poter", "j.k. rowling", "unico", "2000", "unico", "amor", "bruxos", 10, 10);
	
		try {
			rl.cadastrar("a culpa e das estrelas", "alice", "unico", 2000,"123",  "unico", "amor", "historia de amor", 10, 10);
		} catch (SQLException e1) {
			System.out.println(e1.getErrorCode() + "," + e1.getMessage());
		}
		List<Livro> livros = new ArrayList<Livro>();
		//System.out.println(rl.pesquisarISBN("129"));
		try {
			livros = rl.pesquisarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Livro l : livros)
			System.out.println(l);
		
		//RepositorioEmprestimos re = new RepositorioEmprestimos();
		
		RepositorioEmprestimos re = new RepositorioEmprestimos();
		try {
			re.remove(6);
			//re.cadastrar("31/1/1990", "35/13/2000", "ABERTO", "2", "1", "123");
		} catch (SQLException e1) {
			System.out.println(e1.getErrorCode() + "," + e1.getMessage());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		try{
			emprestimos = re.pesquisarTodos();
			for(Emprestimo e: emprestimos)
				System.out.println(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*RepositorioHistorico rh = new RepositorioHistorico();
		List<Historico> historicos = new ArrayList<Historico>();
		try {
			
			historicos = rh.pesquisarHistoricoCliente("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Historico h: historicos)
			System.out.println(h);*/
		//Calendar data = Calendar.getInstance();
		//System.out.println(data.get(Calendar.YEAR));*/
	}
}

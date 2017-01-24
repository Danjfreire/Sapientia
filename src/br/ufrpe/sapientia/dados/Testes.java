package br.ufrpe.sapientia.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Emprestimo;
import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public class Testes {
	public static void main(String [] args){
		RepositorioUsuarios ru = new RepositorioUsuarios();
		
		//Usuario u = new Usuario("jose", "07665566464", "84009198", "wallace@gmail", "wallace@lima", "123", "M", "C", "Rua dracena", 241, "sancho", "recife", "PE");
		/*try {
			ru.atualizar("07665566464" ,"jose", "84009198", "wallace@gmail", "wallace@lima", "123", "M", "C", "Rua dracena", 241, "sancho", "recife", "PE");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
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
		//rl.cadastrar("129", "a culpa e das estrelas", "alice", "unico", "2000", "unico", "amor", "historia de amor", 10, 10);
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
			re.cadastrar("31/12/1990", "31/12/2000", "P", "123", "1234", "2000");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		try {
			emprestimos = re.pesquisarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Emprestimo e : emprestimos)
			System.out.println(e);
	}
}

package br.ufrpe.sapientia.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public class Testes {
	public static void main(String [] args){
		//RepositorioUsuarios ru = new RepositorioUsuarios();
		
		//Usuario u = new Usuario("F", "dan", "7856923", "6324782684", "dan13@gmail.com", "logi", "senha", "H", "Rua um");
		//ru.cadastrar(u);
		//List<Usuario> usuarios= new ArrayList<Usuario>();
		//usuarios = ru.pesquisarTodos("F");
		/*for(Usuario user : usuarios)
			System.out.println(user);*/
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
		rl.cadastrar("129", "a culpa e das estrelas", "alice", "unico", "2000", "unico", "amor", "historia de amor", 10, 10);
		List<Livro> livros = new ArrayList<Livro>();
		//System.out.println(rl.pesquisarISBN("129"));
		livros = rl.pesquisarAutor("wallace");
		for(Livro l : livros)
			System.out.println(l);
		
		//RepositorioEmprestimos re = new RepositorioEmprestimos();
	}
}

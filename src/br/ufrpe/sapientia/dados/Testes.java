package br.ufrpe.sapientia.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public class Testes {
	public static void main(String [] args){
		RepositorioUsuarios ru = new RepositorioUsuarios();
		Usuario u = new Usuario("F", "wallaca", "785690", "84009198", "wallacesantana843@gmail.com", "wallace", "ruty", "M", "Rua Maria Augusta");
		ru.cadastrar(u);
		List<Usuario> usuarios= new ArrayList<Usuario>();
		usuarios = ru.pesquisarTodos();
		for(Usuario user : usuarios)
			System.out.println(user);
		
		
		RepositorioLivros rl = new RepositorioLivros();
		rl.cadastrar("129", "a culpa e das estrelas", "alice", "unico", "2000", "unico", "amor", "historia de amor", "D");
		List<Livro> livros = new ArrayList<Livro>();
		livros = rl.pesquisarTitulo("a culpa e das estrelas");
		for(Livro l : livros)
			System.out.println(l);
	
	}
}

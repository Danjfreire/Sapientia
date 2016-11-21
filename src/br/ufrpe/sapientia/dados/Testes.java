package br.ufrpe.sapientia.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Livro;
import br.ufrpe.sapientia.negocio.beans.Usuario;

public class Testes {
	public static void main(String [] args){
		RepositorioUsuarios ru = new RepositorioUsuarios();
		/*Usuario u = new Usuario("F", "wallaca", "78569", "84009198", 
				"wallacesantana843@gmail.com", "wallace", "ruty", "M", "Rua Maria Augusta");
		ru.atualizar("3", "wallace", "984009198", "wallace.lima", "wallacesantana843@gmail.com", "wallace.lima", "46576", "F", "M");

		ru.cadastrar(u);*/
		
		List<Usuario> usuarios= new ArrayList<Usuario>();
		//ru.cadastrar(u);
		//ru.remover("611");
		
		/*Usuario d = new Usuario();
		d.setNome("Daniel Freire");
		d.setCpf("10756365673");
		d.setEmail("danjfreire@gmail.com");
		d.setEndereco("r.antonio marciliano");
		d.setContato("76576769");
		d.setLogin("loginseguro");
		d.setSenha("senhasegura");
		d.setTipo("C");
		d.setSexo("M");
		d.setId(7);
		//ru.atualizar(d);
		Usuario w = ru.pesquisarCPF("10756365673");
		System.out.println(w);
		//ru.cadastrar(d);
		*/usuarios = ru.pesquisarTodos();
		usuarios = ru.pesquisarNome("wallaca", "C");
		for(Usuario user : usuarios)
			System.out.println(user);
		RepositorioLivros rl = new RepositorioLivros();
		rl.cadastrar("12", "a culpa e das estrelas", "alice", "unico", "2000", "unico", "amor", "historia de amor", "D");
		rl.remover("12", 7);
		List<Livro> livros = new ArrayList<Livro>();
		livros = rl.pesquisarTitulo("a culpa e das estrelas");
		for(Livro l : livros)
			System.out.println(l);
	
	}
}

package br.ufrpe.sapientia.fachada;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.*;
import br.ufrpe.sapientia.negocio.beans.*;

public class Test {

	public static void main(String[] args){
		ControleUsuario controle = new ControleUsuario();
		ControleLivro controleLivro = new ControleLivro();
		
		Usuario usuario1 = new Usuario("C", "Joao jose", "12345678", "81937539590",
				"email@email.com", "loginseguro", "senhasegura", "M", "Rua um");
		
		Usuario usuario2 = new Usuario("F", "Jose joao", "645679456", "79235743498",
				"email@email.com", "loginruim", "senharuim", "M", "Rua dois");
		
		Usuario usuario4 = new Usuario("C", "Repetido2", "645679456", "79235743498",
				"email@email.com", "loginruim", "senharuim", "M", "Rua dois");

		
		//controleLivro.cadastraLivro("1213122112", "titulo generico", "autor generico", "1 edição", "2016", "volume 1", "computação", "livro de computação muito bom e tals", "E");
		//controleLivro.cadastraLivro("ooooo", "livro diferente", "Joao jose", "1 edição", "2016", "volume 1", "aventura", "Aventuras aventurescas", "D");
		//controleLivro.removerLivro("1213122112",1 );
		//controleLivro.atualizarLivro("ooooo", 10, "livro diferente", "Jose joao", "2 edição", "2020", "volume 1", "aventura", "Aventuras aventurescas 2", "D");
		List<Livro> teste = controleLivro.pesquisarTodos();
		
		//Livro livro = controleLivro.buscaISBN("1213122112");
		//System.out.println(livro);
		//for(Livro livro : teste){
		//	System.out.println(livro);
		//}
		//controle.CadastrarUsuario(usuario4);
		//controle.CadastrarUsuario(usuario1);
		//controle.CadastrarUsuario(usuario2);
		
		controle.CadastrarUsuario(usuario2);
		List<Usuario> usuarios= new ArrayList<Usuario>();
		
		
		//controle.getRepo().atualizar("12345678", "nomeatualizado", "123456", "novo endereco", "novo@email.com", "novologin", "novasenha", "C", "M");
		//controle.getRepo().remover("12345678");
		usuarios = controle.getRepo().pesquisarTodos();
		
		//for(Usuario user : usuarios){
		//	System.out.println(user);
		//}
		//usuarios = controle.getRepo().pesquisarNome("Joao jose", "C");
		//System.out.println(result);
		
		for(Usuario user : usuarios){
				System.out.println(user);
			}
	}
}

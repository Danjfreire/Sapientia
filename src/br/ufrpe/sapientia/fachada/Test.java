package br.ufrpe.sapientia.fachada;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.*;
import br.ufrpe.sapientia.negocio.beans.*;

public class Test {

	public static void main(String[] args){
		ControleUsuario controle = new ControleUsuario();
		
		Usuario usuario1 = new Usuario("F", "Joao jose", "12345678", "81937539590",
				"email@email.com", "loginseguro", "senhasegura", "M", "Rua um");
		
		Usuario usuario2 = new Usuario("C", "Jose joao", "645679456", "79235743498",
				"email@email.com", "loginruim", "senharuim", "M", "Rua dois");
		
		Usuario usuario4 = new Usuario("C", "Repetido2", "645679456", "79235743498",
				"email@email.com", "loginruim", "senharuim", "M", "Rua dois");

		//controle.CadastrarUsuario(usuario4);
		//controle.CadastrarUsuario(usuario1);
		//controle.CadastrarUsuario(usuario2);
		
		
		List<Usuario> usuarios= new ArrayList<Usuario>();
		
		
		//controle.getRepo().atualizar("12345678", "nomeatualizado", "123456", "novo endereco", "novo@email.com", "novologin", "novasenha", "C", "M");
		//controle.getRepo().remover("12345678");
		//usuarios = controle.getRepo().pesquisarTodos();
		
		//for(Usuario user : usuarios){
		//	System.out.println(user);
		//}
		usuarios = controle.getRepo().pesquisarNome("Joao jose", "C");
		//System.out.println(result);
		
		for(Usuario user : usuarios){
				System.out.println(user);
			}
	}
}

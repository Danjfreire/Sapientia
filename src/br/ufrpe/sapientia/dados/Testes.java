package br.ufrpe.sapientia.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Usuario;

public class Testes {
	public static void main(String [] args){
		RepositorioUsuarios ru = new RepositorioUsuarios();
		Usuario u = new Usuario();
		List<Usuario> usuarios= new ArrayList<Usuario>();
		u.setNome("wallace santana");
		u.setCpf("6");
		u.setEmail("wallacesantana843@gmail.com");
		u.setEndereco("rua dracena 241");
		u.setLogin("wallace.lima");
		u.setSenha("wallacefrgb");
		u.setContato("984009198");
		u.setTipo("C");
		u.setSexo("M");
		u.setId(6);
		ru.atualizar(u);
		
		//dao.atualizar(u);
		//usuarios = dao.pesquisarCPF("07665566464");
		//usuarios = dao.pesquisarNome("wallace");
		usuarios = ru.pesquisarTodos();
		for(Usuario user : usuarios){
			System.out.println(user);
		}
		//LivroDao ldao = new LivroDao();
		//Livro l = new Livro();
		//List<Livro> livros = new ArrayList<Livro>();
		/*l.setAno_livro("2000");
		l.setAutor_livro("Sun Tzu");
		l.setCategoria_livro("belico");
		l.setEdicao_livro("8");
		l.setIsbn_livro("798597");
		l.setResumo_livro("livro conta estrategias militares da china antiga");
		l.setTitulo_livro("A arte da Guerra");
		l.setVolume_livro("1");
		ldao.cadastrar(l);
		//ldao.remove(l);
		//ldao.atualizar(l);
		//livros = ldao.pesquisarISBN("7985960");*/
		/*livros = ldao.pesquisarTitulo("A arte da Guerra");
		for(Livro li : livros){
			System.out.println(li);
		}*/
		//Emprestimo e = new Emprestimo();
		//EmprestimoDao ed = new EmprestimoDao();
		//e.setCliente_emprestimo(1);
		
		//e.setFuncionario_emprestimo(1);
		//e.setStatus_emprestimo("I");
		//ed.cadastrar(e);
	
	}
}

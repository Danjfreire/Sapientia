package br.ufrpe.sapientia.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sapientia.negocio.beans.Livro;
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
		ru.cadastrar(u);
		ru.remover("611");
		Usuario d = new Usuario();
		d.setNome("Daniel Freire");
		d.setCpf("10756365673");
		d.setEmail("danjfreire@gmail.com");
		d.setEndereco("r.antonio martiniano de barros");
		d.setContato("76576769");
		d.setLogin("danjfreire");
		d.setSenha("senhasegura");
		d.setTipo("C");
		d.setSexo("M");
		d.setId(7);
		ru.cadastrar(d);
		usuarios = ru.pesquisarTodos();
		for(Usuario user : usuarios){
			System.out.println(user);
		}
		RepositorioLivros rl = new RepositorioLivros();
		Livro l = new Livro();
		List<Livro> livros = new ArrayList<Livro>();
		l.setAno("2000");
		l.setAutor("Sun Tzu");
		l.setCategoria("belico");
		l.setEdicao("8");
		l.setISBN("0");
		l.setResumo("livro conta estrategias militares da china antiga");
		l.setTitulo("A culpa e das estrelas");
		l.setVolume("1");
		l.setId(1);
		rl.atualizar(l);
		rl.remove("7985");
		
		//ldao.atualizar(l);
		//livros = ldao.pesquisarISBN("7985960");*/
		livros = rl.pesquisarTodos();
		for(Livro li : livros){
			System.out.println(li);
		}
		//Emprestimo e = new Emprestimo();
		//EmprestimoDao ed = new EmprestimoDao();
		//e.setCliente_emprestimo(1);
		
		//e.setFuncionario_emprestimo(1);
		//e.setStatus_emprestimo("I");
		//ed.cadastrar(e);
	
	}
}

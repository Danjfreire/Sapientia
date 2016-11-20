package br.ufrpe.sapientia.dados;
import br.ufrpe.sapientia.negocio.beans.*;
import java.util.List;

public interface IRepositorioUsuarios {

	boolean cadastrar(Usuario u);
	boolean remover(String cpf);
	//boolean atualizar(Usuario u);
	List<Usuario>pesquisarTodos();
	//List<Usuario>pesquisarNome(String nome);
	//Usuario pesquisarCPF(String cpf);
	
}

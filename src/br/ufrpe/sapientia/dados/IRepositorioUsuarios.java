package br.ufrpe.sapientia.dados;
import br.ufrpe.sapientia.negocio.beans.*;
import java.util.List;

public interface IRepositorioUsuarios {

	boolean cadastrar(Usuario u);
	boolean remover(String cpf);
	boolean atualizar(String cpf, String nome, String contato, String endereco, 
			String email, String login, String senha, String tipo, String sexo);
	List<Usuario>pesquisarTodos(String tipo);
	List<Usuario>pesquisarNome(String nome, String tipo);
	Usuario pesquisarCPF(String cpf, String tipo);
    Usuario pesquisarLoginSenha(String login, String senha);
}

package br.ufrpe.sapientia.negocio;
import br.ufrpe.sapientia.negocio.beans.*;
import java.util.List;

public interface IControleUsuario {

	boolean atualizarUsuario(String cpf, String nome, String contato, String email, String login, String senha, 
			String tipo, String sexo, String logradouro, int numero, String bairro, String cidade, String estado) throws Exception;
	Usuario buscarUsuarioCPF(String cpf,String tipo) throws Exception;
	List<Usuario> buscarUsuarioNome(String nome, String tipoo) throws Exception;
	boolean removerUsuario(String cpf) throws Exception;
	boolean CadastrarUsuario(Usuario usuario) throws Exception;
	boolean atualizarADM() throws Exception;
	List<Usuario> pesquisarTodos(String tipo) throws Exception;
}

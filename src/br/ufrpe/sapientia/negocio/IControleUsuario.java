package br.ufrpe.sapientia.negocio;
import br.ufrpe.sapientia.negocio.beans.*;
import java.util.List;

public interface IControleUsuario {

	boolean atualizarUsuario(String cpf, String nome, String contato, String endereco, 
			String email, String login, String senha, String tipo, String sexo);
	Usuario buscarUsuarioCPF(String cpf,String tipo);
	List<Usuario> buscarUsuarioNome(String nome, String tipoo);
	boolean removerUsuario(String cpf);
	boolean CadastrarUsuario(Usuario usuario);
	boolean atualizarADM();
}

package br.ufrpe.sapientia.dados;
import br.ufrpe.sapientia.negocio.beans.*;

import java.sql.SQLException;
import java.util.List;

public interface IRepositorioUsuarios {

	boolean cadastrar(Usuario u) throws Exception;
	boolean remover(String cpf) throws Exception;
	boolean atualizar(String cpf, String nome, String contato, String email, String login, String senha, String tipo, String sexo, 
			String logradouro, int numero, String bairro, String cidade, String estado) throws Exception;
	List<Usuario>pesquisarTodos(String tipo) throws Exception;
	List<Usuario>pesquisarNome(String nome, String tipo) throws Exception;
	Usuario pesquisarCPF(String cpf, String tipo) throws Exception;
    Usuario pesquisarLoginSenha(String login, String senha) throws Exception;
}

package br.ufrpe.sapientia.negocio;
import br.ufrpe.sapientia.negocio.beans.*;

public interface IControleUsuario {

	boolean atualizarFuncionario(Usuario funcionario);
	Usuario buscaFuncionario();
	boolean atualizarCliente(Usuario cliente);
	boolean removerUsuario(String cpf);
	Usuario buscaCliente();
	boolean CadastrarUsuario(Usuario usuario);
	boolean atualizarADM();
}

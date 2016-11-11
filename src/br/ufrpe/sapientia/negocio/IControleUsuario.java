package br.ufrpe.sapientia.negocio;
import br.ufrpe.sapientia.negocio.beans.*;

public interface IControleUsuario {

	boolean atualizarFuncionario(Usuario funcionario);
	Usuario removerFuncionario();
	Usuario buscaFuncionario();
	boolean atualizarCliente(Usuario cliente);
	Usuario removerCliente();
	Usuario buscaCliente();
	boolean CadastrarUsuario(Usuario usuario);
	boolean atualizarADM();
}

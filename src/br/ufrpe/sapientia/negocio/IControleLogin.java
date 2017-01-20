package br.ufrpe.sapientia.negocio;
import br.ufrpe.sapientia.negocio.beans.*;

public interface IControleLogin  {

	Usuario efetuarLogin(String login, String senha) throws Exception;
}

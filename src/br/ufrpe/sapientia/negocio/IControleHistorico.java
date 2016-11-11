package br.ufrpe.sapientia.negocio;
import br.ufrpe.sapientia.negocio.beans.*;
import java.util.ArrayList;

public interface IControleHistorico {

	ArrayList<Emprestimo>verificarPendenciasLivro(Livro livro);
	ArrayList<Emprestimo>verificarPendenciasCliente(Usuario cliente);
	ArrayList<Emprestimo>verificarEmprestimoLivro(Livro livro);
	ArrayList<Emprestimo>verificarEmprestimoCliente(Usuario cliente);
}

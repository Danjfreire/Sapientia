package br.ufrpe.sapientia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.ufrpe.sapientia.negocio.beans.Historico;

public class RepositorioHistorico implements IRepositorioHistorico{
	private Connection connection;
	public RepositorioHistorico(){
		this.connection = new Conexao().construirConexao();
	}
	
	public List<Historico> pesquisarHistoricoTitulo(String titulo) throws Exception{
		List<Historico> historicos = new ArrayList<Historico>();
		String consulta = '%' + titulo + '%';
		String sql = "select * from historico where titulo_livro like ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, consulta);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				historicos.add(preencherHistorico(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return historicos;
	}
	
	public List<Historico> pesquisarHistoricoFuncionario(String funcionario_cpf) throws Exception{
		List<Historico> historicos = new ArrayList<Historico>();
		String sql = "select * from historico where funcionario_cpf like ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, funcionario_cpf);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				historicos.add(preencherHistorico(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return historicos;
	}
	
	public List<Historico> pesquisarHistoricoCliente(String cliente_cpf) throws Exception{
		List<Historico> historicos = new ArrayList<Historico>();
		String sql = "select * from historico where cliente_cpf like ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cliente_cpf);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				historicos.add(preencherHistorico(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return historicos;
	}
	
	public List<Historico> pesquisarHistoricoISBN(String isbn_livro) throws Exception{
		List<Historico> historicos = new ArrayList<Historico>();
		String sql = "select * from historico where isbn_livro like ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, isbn_livro);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				historicos.add(preencherHistorico(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return historicos;
	}
	
	public List<Historico> pesquisarHistoricoTodos() throws Exception{
		List<Historico> historicos = new ArrayList<Historico>();
		String sql = "select * from historico";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				historicos.add(preencherHistorico(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return historicos;
	}
	
	private Historico preencherHistorico(ResultSet rs) throws SQLException {
		Historico h = null;
		try {
			int id = rs.getInt("id");
			Calendar dataEmprestimo = Calendar.getInstance();
			dataEmprestimo.setTime( rs.getDate("data_saida_emprestimo"));
			Calendar dataDevolucao = Calendar.getInstance();
			dataDevolucao.setTime( rs.getDate("data_entrega_emprestimo"));
			String funcionario = rs.getString("funcionario_cpf");
			String cliente = rs.getString("cliente_cpf");
			String isbn = rs.getString("isbn_livro");
			String titulo = rs.getString("titulo_livro");
			h = new Historico(dataEmprestimo, dataDevolucao, isbn, cliente, funcionario, titulo);
			h.setId(id);
		} catch (SQLException e) {
			throw e;
		}
		return h;
	}
}

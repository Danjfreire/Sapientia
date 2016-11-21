package br.ufrpe.sapientia.dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.ufrpe.sapientia.negocio.beans.Emprestimo;


public class RepositorioEmprestimos {
	private Connection connection;
	
	public RepositorioEmprestimos(){
		this.connection = new Conexao().construirConexao();
	}
	public boolean cadastrar(Calendar dataEmprestimo, Calendar dataDevolucao, String status, int funcionario, int cliente){
		/*
		 * ao invés de receber numeros para identificar um funcionário e um cliente deve receber dois objetos usuário sendo um cliente e um funcionario.
		 * Deve também receber um objeto Livro assim como no construtor
		 */
		boolean s = false;
		String sql = "insert into emprestimo (funcionario_emprestimo, cliente_emprestimo, status_emprestimo,  data_saida_emprestimo,"
				+ " data_entrega_emprestimo date)"
				+ " value(?,?,?,?,?)";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, funcionario);
			stmt.setInt(2, cliente);
			stmt.setString(3, status);
			stmt.setDate(4, new Date(dataEmprestimo.getTimeInMillis()));
			stmt.setDate(5, new Date(dataDevolucao.getTimeInMillis()));
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("Cadastrado");
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return s;
	}
	
	public boolean remove(int id){
		boolean s = false;
		String sql = "delete from emprestimo where id_emprestimo = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("removido");
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return s;
	}
	
	public boolean atualizar(int id, String status){
		boolean s = false;
		String sql = "update emprestimo"
				+ " set status = ? where isbn_livro = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("atualizado");
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return s;
	}
	
	public List<Emprestimo> pesquisarTodos(){
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "select * from livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return emprestimos;
	}
	
	public List<Emprestimo> pesquisarEmrprestimoCliente(int id){
		/*
		 * Deve receber como parametro um Usuario cliente 
		 */
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "select * from livro where cliente_emprestimo = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return emprestimos;
	}	
	
	/*
	 * seria bom um método que busca os emprestimos realizados por um Funcionário, esquecemos de colocar então só vamo fazer depois
	 * 
	 * É necessário um método que busca um emprestimo baseado no livro assim como o método baseado no cliente
	 */
	
	public List<Emprestimo> pesquisarEmrprestimo(int id){
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "select * from livro where id_emprestimo = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return emprestimos;
	}
	
	private Emprestimo preencherEmprestimo(ResultSet rs){
		Emprestimo em = null;
		try {
			int id = rs.getInt("id_emprestimo");
			Calendar dataEmprestimo = Calendar.getInstance();
			dataEmprestimo.setTime( rs.getDate("data_saida_emprestimo"));
			Calendar dataDevolucao = Calendar.getInstance();
			dataDevolucao.setTime( rs.getDate("data_entrega_emprestimo"));
			String status = rs.getString("status_emprestimo");
			int funcionario = rs.getInt("funcionario_emprestimo");
			int cliente = rs.getInt("cliente_emprestimo");
			em = new Emprestimo(dataEmprestimo, dataDevolucao, status, funcionario, cliente);
			em.setIdEmprestimo(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return em;
	}
}

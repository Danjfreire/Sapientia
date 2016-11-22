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
	private RepositorioUsuarios ru;
	
	public RepositorioEmprestimos(){
		this.connection = new Conexao().construirConexao();
		this.ru = new RepositorioUsuarios();
	}
	public boolean cadastrar(Calendar dataEmprestimo, Calendar dataDevolucao, String status, String cpf_funcionario, String cpf_cliente, String isbn_livro){
		/*
		 *  
		 */
		boolean s = false;
		String sql = "insert into emprestimo (funcionario_emprestimo, cliente_emprestimo, status_emprestimo,  data_saida_emprestimo,"
				+ " data_entrega_emprestimo, isbn_livro)"
				+ " value(?,?,?,?,?,?)";
		try{
			if(ru.pesquisarCPF(cpf_cliente, "C") != null && ru.pesquisarCPF(cpf_funcionario, "F") != null){
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, cpf_funcionario);
				stmt.setString(2, cpf_cliente);
				stmt.setString(3, status);
				stmt.setDate(4, new Date(dataEmprestimo.getTimeInMillis()));
				stmt.setDate(5, new Date(dataDevolucao.getTimeInMillis()));
				stmt.setString(6, isbn_livro);
				stmt.execute();
				stmt.close();
				s = true;
				System.out.println("Cadastrado");
			}
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
	
	public List<Emprestimo> pesquisarEmrprestimoCliente(String cpf_cliente){
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "select * from livro where cliente_emprestimo = ?";
		try{
			if(ru.pesquisarCPF(cpf_cliente, "C") != null){
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, cpf_cliente);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
					emprestimos.add(preencherEmprestimo(rs));
				stmt.close();
				System.out.println("Resultados:\n\n");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return emprestimos;
	}
	
	public List<Emprestimo> pesquisarEmrprestimoFuncionario(String cpf_funcionario){
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "select * from livro where funcionario_emprestimo = ?";
		try{
			if(ru.pesquisarCPF(cpf_funcionario, "F") != null){
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, cpf_funcionario);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
					emprestimos.add(preencherEmprestimo(rs));
				stmt.close();
				System.out.println("Resultados:\n\n");
			}
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
			String funcionario = rs.getString("funcionario_emprestimo");
			String cliente = rs.getString("cliente_emprestimo");
			String isbn = rs.getString("isbn_livro");
			em = new Emprestimo(dataEmprestimo, dataDevolucao, status, isbn, cliente, funcionario);
			em.setIdEmprestimo(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return em;
	}
}

package br.ufrpe.sapientia.dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.ufrpe.sapientia.negocio.beans.Emprestimo;


public class RepositorioEmprestimos implements IRepositorioEmprestimos {
	private Connection connection;
	
	public RepositorioEmprestimos(){
		this.connection = new Conexao().construirConexao();
	}
	//cadastrar(Calendar dataEmprestimo, Calendar dataDevolucao, String status, Usuario funcionario, Usuario cliente)
	public boolean cadastrar(String dataEmprestimo, String dataDevolucao, String status
			, String cpf_funcionario, String cpf_cliente, String isbn_livro) throws Exception{
		/*
		 *  
		 */
		boolean s = false;
		SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
		
		
		String sql = "insert into emprestimo (funcionario_cpf, cliente_cpf, status_emprestimo,  data_saida_emprestimo,"
				+ " data_entrega_emprestimo, isbn_livro, titulo_livro)"
				+ " value(?,?,?,?,?,?,?)";
		try{
			RepositorioLivros rl = new RepositorioLivros();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf_funcionario);
			stmt.setString(2, cpf_cliente);
			stmt.setString(3, status);
			Date dataEmprestimoForma = new Date(forma.parse(dataEmprestimo).getTime());		
			Date dataDevolucaoForma = new Date(forma.parse(dataDevolucao).getTime());
			stmt.setDate(4, dataEmprestimoForma);
			stmt.setDate(5, dataDevolucaoForma);
			stmt.setString(6, isbn_livro);
			stmt.setString(7, rl.pesquisarISBN(isbn_livro).getTitulo());
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("Cadastrado");	
			
		}catch(SQLException e){
			throw e;
		} catch (ParseException e) {
			throw e;
		}catch(NullPointerException e){
			throw e;
		}
		return s;
	}
	
	public boolean remove(int id) throws Exception{
		boolean s = false;
		String sql = "delete from emprestimo where id_emprestimo = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("removido");
		}catch(SQLException e){
			throw e;
		}
		return s;
	}
	
	public boolean atualizar(int id, String status) throws Exception{
		boolean s = false;
		String sql = "update emprestimo"
				+ " set status_emprestimo = ? where id_emprestimo = ?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.setInt(2, id);
			stmt.execute();
			stmt.close();
			s = true;
			System.out.println("atualizado");
		}catch(SQLException e){
			throw e;
		}
		return s;
	}
	
	public List<Emprestimo> pesquisarEmprestimoTitulo(String titulo) throws Exception{
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String consulta = '%' + titulo + '%';
		String sql = "select * from emprestimo where titulo_livro like ? order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, consulta);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return emprestimos;
	}
	
	public List<Emprestimo> pesquisarEmprestimoISBN(String isbn) throws Exception{
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "select * from emprestimo where isbn_livro like ? order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, isbn);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return emprestimos;
	}
	
	public List<Emprestimo> pesquisarTodos() throws Exception{
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "select * from emprestimo order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return emprestimos;
	}
	
	public List<Emprestimo> pesquisarEmprestimoCliente(String cpf_cliente) throws Exception{
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "select * from emprestimo where cliente_cpf = ? order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf_cliente);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();				
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return emprestimos;
	}
	
	public List<Emprestimo> pesquisarEmprestimoFuncionario(String cpf_funcionario) throws Exception{
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql = "select * from emprestimo where funcionario_cpf = ? order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf_funcionario);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return emprestimos;
	}
	
	public List<Emprestimo> selecaoEmprestimoFuncionario(String cpf_funcionario, boolean tipo) throws Exception{
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql;
		if(tipo)
			sql = "select * from emprestimo where funcionario_cpf = ? and status_emprestimo = 'ATRASADO' order by titulo_livro";
		else
			sql = "select * from emprestimo where funcionario_cpf = ? and status_emprestimo = 'ABERTO' order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf_funcionario);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return emprestimos;
	}
	
	public List<Emprestimo> selecaoEmprestimoCliente(String cpf_cliente, boolean tipo) throws Exception{
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql;
		if(tipo)
			sql = "select * from emprestimo where funcionario_cpf = ? and status_emprestimo = 'ATRASADO' order by titulo_livro";
		else
			sql = "select * from emprestimo where funcionario_cpf = ? and status_emprestimo = 'ABERTO' order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf_cliente);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return emprestimos;
	}
	
	public List<Emprestimo> selecaoEmprestimoISBN(String isbn_livro, boolean tipo) throws Exception{
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql;
		if(tipo)
			sql = "select * from emprestimo where funcionario_cpf = ? and status_emprestimo = 'ATRASADO' order by titulo_livro";
		else
			sql = "select * from emprestimo where funcionario_cpf = ? and status_emprestimo = 'ABERTO' order by titulo_livro";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, isbn_livro);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return emprestimos;
	}
	
	public List<Emprestimo> selecaoEmprestimoTitulo(String titulo_livro, boolean tipo) throws Exception{
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		String sql;
		if(tipo)
			sql = "select * from emprestimo where funcionario_cpf = ? and status_emprestimo = 'ATRASADO' order by titulo_livro";
		else
			sql = "select * from emprestimo where funcionario_cpf = ? and status_emprestimo = 'ABERTO' order by titulo_livro";
		String titulo = '%' + titulo_livro + '%';
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, titulo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				emprestimos.add(preencherEmprestimo(rs));
			stmt.close();
			System.out.println("Resultados:\n\n");
		}catch(SQLException e){
			throw e;
		}
		return emprestimos;
	}
	
	private Emprestimo preencherEmprestimo(ResultSet rs) throws Exception{
		Emprestimo em = null;
		try {
			int id = rs.getInt("id_emprestimo");
			Calendar dataEmprestimo = Calendar.getInstance();
			dataEmprestimo.setTime( rs.getDate("data_saida_emprestimo"));
			Calendar dataDevolucao = Calendar.getInstance();
			dataDevolucao.setTime( rs.getDate("data_entrega_emprestimo"));
			String status = rs.getString("status_emprestimo");
			String funcionario = rs.getString("funcionario_cpf");
			String cliente = rs.getString("cliente_cpf");
			String isbn = rs.getString("isbn_livro");
			String titulo = rs.getString("titulo_livro");
			em = new Emprestimo(dataEmprestimo, dataDevolucao, status, isbn, cliente, funcionario, titulo);
			em.setIdEmprestimo(id);
		} catch (SQLException e) {
			throw e;
		}
		return em;
	}
}

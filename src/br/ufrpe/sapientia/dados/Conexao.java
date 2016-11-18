package br.ufrpe.sapientia.dados;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private String user = "root";
	private String password = "";
	private String stringJdbc = "jdbc:mysql://localhost/sapientia";
	public Connection construirConexao(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(stringJdbc, user, password);
			
		}catch(Exception e){
			System.out.println("Nao conectado");
			e.printStackTrace();
		}
		
		return null;
	}
}

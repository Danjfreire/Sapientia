package br.ufrpe.sapientia.GUI;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.ufrpe.sapientia.fachada.Fachada;

public class ErrosGUI {
	private Exception exception;
	private JTextField tfCpf;
	private JTextField tfLogin;
	private JTextField tfEmail;
	private JTextField tfIsbn;
	private JTextField tfEstoque;
	private JTextField tfTotal;
	private JTextArea taResumo;
	private JPasswordField psSenha;
	private JPasswordField psConfirmar;
	
	public ErrosGUI() {
	}

	public ErrosGUI(Exception exception, JTextField tfCpf, JTextField tfLogin, JTextField tfEmail,
			JPasswordField psSenha, JPasswordField psConfirmar) {
		this.exception = (SQLException)exception;
		this.tfCpf = tfCpf;
		this.tfLogin = tfLogin;
		this.tfEmail = tfEmail;
		this.psSenha = psSenha;
		this.psConfirmar = psConfirmar;
	}
	
	public ErrosGUI(Exception exception, JTextField tfEmail, JPasswordField psSenha, JPasswordField psConfirmar) {
		this.exception = (SQLException)exception;
		this.tfEmail = tfEmail;
		this.psSenha = psSenha;
		this.psConfirmar = psConfirmar;
	}
	
	public ErrosGUI(Exception exception, JTextField tfIsbn, JTextField tfEstoque, JTextField tfTotal, JTextArea taResumo) {
		this.exception = exception;
		this.tfIsbn = tfIsbn;
		this.tfEstoque = tfEstoque;
		this.tfTotal = tfTotal;
		this.taResumo = taResumo;
	}

	public ErrosGUI(Exception exception, JTextField tfEstoque, JTextField tfTotal, JTextArea taResumo) {
		this.exception = exception;
		this.tfEstoque = tfEstoque;
		this.tfTotal = tfTotal;
		this.taResumo = taResumo;
	}
	

	public void mensagemUsuario(){
		String mensagem;
		SQLException e = (SQLException)this.exception;
		if(e.getErrorCode() == 1062 && this.tfCpf != null && this.tfLogin != null){
			try{
				if( Fachada.getInstance().buscarUsuarioCPF(this.tfCpf.getText(), "A") == null &&
					Fachada.getInstance().buscarUsuarioCPF(this.tfCpf.getText(), "C") == null &&
					Fachada.getInstance().buscarUsuarioCPF(this.tfCpf.getText(), "F") == null){
					mensagem = "Login já cadastrado!";
					this.tfLogin.setText(""); 
				}else{
					mensagem = "Cpf já cadastrado";
					this.tfCpf.setText("");
				}
			}catch(Exception ex){
				mensagem = ex.getMessage();
			}
		}else if (e.getErrorCode() == 1644){
			mensagem = e.getMessage();
			this.tfEmail.setText("");
		}else if (e.getErrorCode() == 1406){
			mensagem = "Senha muito grande!";
			this.psSenha.setText("");
			this.psConfirmar.setText("");
		}else
			mensagem = e.getMessage();
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public void mensagemLivro(){
		String mensagem;
		SQLException e = (SQLException)this.exception;
		if(e.getErrorCode() == 1062 && this.tfIsbn != null){
			mensagem = "ISBN já cadastrado";
			this.tfIsbn.setText("");
		}else if (e.getErrorCode() == 1644){
			mensagem = e.getMessage();
			this.tfEstoque.setText("");
			this.tfTotal.setText("");
		}else if (e.getErrorCode() == 1406){
			mensagem = "Resumo ultrapassou o limite de caracteres!";
			this.taResumo.setText("");
		}else
			mensagem = this.exception.getMessage();
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public void mensagemEmprestimo(SQLException e, JTextField cliente, JTextField isbn){
		String mensagem;
		if(e.getErrorCode() == 1452){
			try {
				if(Fachada.getInstance().buscaLivroISBN(isbn.getText()) != null){
					mensagem = "Cliente não cadastrado!";
					cliente.setText("");
				}else{
					mensagem = "ISBN não cadastrado";
					isbn.setText("");
				}
			} catch (Exception e1) {
				mensagem = e1.getMessage();
			}
			
		}
		else if(e.getErrorCode() == 1452)
			mensagem = e.getMessage();
		else{
			this.exception = e;
			mensagem = this.exception.getMessage();
		}
		JOptionPane.showMessageDialog(null, mensagem);
	}
}

package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufrpe.sapientia.fachada.Fachada;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.*;
import br.ufrpe.sapientia.negocio.beans.*;

public class TelaLogon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				        if ("Nimbus".equals(info.getName())) {
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
				} catch (Exception e) {
				    // If Nimbus is not available, you can set the GUI to another look and feel.
				}
				try {
					TelaLogon frame = new TelaLogon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogon() {
		setTitle("SAPIENTIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(117, 203, 442, 244);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(365, 202, 75, 23);
		panel.add(btnCancelar);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBounds(148, 202, 71, 23);
		panel.add(btnAcessar);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(237, 123, 118, 20);
		panel.add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setBounds(148, 119, 59, 22);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setForeground(new Color(0, 0, 0));
		
		textField = new JTextField();
		textField.setBounds(237, 86, 203, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login.:");
		lblLogin.setBounds(148, 82, 54, 22);
		panel.add(lblLogin);
		lblLogin.setForeground(new Color(0, 0, 0));
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblBemVindoAo = new JLabel("Identifica\u00E7\u00E3o do Usu\u00E1rio");
		lblBemVindoAo.setBounds(146, 34, 198, 22);
		panel.add(lblBemVindoAo);
		lblBemVindoAo.setForeground(new Color(0, 0, 0));
		lblBemVindoAo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pessoas.png")));
		label_1.setBounds(10, 41, 128, 169);
		panel.add(label_1);
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Usuario u =  Fachada.getInstance().efetuarLogin(textField.getText(), passwordField.getText());
				if(u.getTipo() == "C"){
					TelaInicialCliente tela = new TelaInicialCliente(u);
					dispose();
					tela.setVisible(true);
				}
				else if(u.getTipo() == "F"){
					TelaInicialFunc tela = new TelaInicialFunc();
					dispose();
					tela.setVisible(true);
				}
				else{
					TelaInicialAdm tela = new TelaInicialAdm();
					dispose();
					tela.setVisible(true);
				}
				}catch(Exception exception){
					System.out.println(exception.getMessage());
				}
			}
		});
		
		JLabel lblSapientiaSistema = new JLabel("SAPIENTIA");
		lblSapientiaSistema.setForeground(new Color(255, 255, 255));
		lblSapientiaSistema.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblSapientiaSistema.setBounds(10, 52, 182, 43);
		contentPane.add(lblSapientiaSistema);
		
		JLabel lblSistemaDeGerenciamento = new JLabel("Sistema de Gerenciamento de Livros");
		lblSistemaDeGerenciamento.setForeground(new Color(255, 255, 255));
		lblSistemaDeGerenciamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSistemaDeGerenciamento.setBounds(10, 106, 377, 27);
		contentPane.add(lblSistemaDeGerenciamento);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o: 1.0");
		lblVerso.setForeground(new Color(255, 255, 255));
		lblVerso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVerso.setBounds(10, 144, 176, 27);
		contentPane.add(lblVerso);
		
		JLabel lblWwwsapientiacombr = new JLabel("www.sapientia.com.br");
		lblWwwsapientiacombr.setForeground(new Color(255, 255, 255));
		lblWwwsapientiacombr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWwwsapientiacombr.setBounds(10, 166, 176, 27);
		contentPane.add(lblWwwsapientiacombr);
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador.jpg")));
		lbTelaAzul.setBounds(0, 0, 802, 571);
		contentPane.add(lbTelaAzul);
	}
}

package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				 try 
				    {
				      UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
				    } 
				    catch (Exception e) 
				    {
				      e.printStackTrace();
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
		setBounds(100, 100, 450, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao  Sapientia!");
		lblBemVindoAo.setForeground(Color.WHITE);
		lblBemVindoAo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBemVindoAo.setBounds(22, 34, 363, 32);
		contentPane.add(lblBemVindoAo);
		
		JLabel lblLogin = new JLabel("Login.:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(22, 95, 62, 32);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 104, 264, 23);
		contentPane.add(textField);
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(22, 134, 87, 32);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(94, 143, 139, 23);
		contentPane.add(passwordField);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnAcessar.setBounds(94, 212, 89, 32);
		contentPane.add(btnAcessar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(269, 212, 89, 32);
		contentPane.add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/azul.jpg")));
		label.setBounds(0, 0, 434, 306);
		contentPane.add(label);
	}
}

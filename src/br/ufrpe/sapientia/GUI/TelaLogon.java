package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.ufrpe.sapientia.fachada.Fachada;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.Toolkit;
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
		setResizable(false);
		setTitle("SAPIENTIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 788)/2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 487)/2), 788, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSapientiaSistema = new JLabel("SAPIENTIA");
		lblSapientiaSistema.setForeground(new Color(255, 255, 255));
		lblSapientiaSistema.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblSapientiaSistema.setBounds(10, 11, 182, 43);
		contentPane.add(lblSapientiaSistema);
		
		JLabel lblSistemaDeGerenciamento = new JLabel("Sistema de Gerenciamento de Livros");
		lblSistemaDeGerenciamento.setForeground(new Color(255, 255, 255));
		lblSistemaDeGerenciamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSistemaDeGerenciamento.setBounds(10, 48, 377, 27);
		contentPane.add(lblSistemaDeGerenciamento);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o: 1.0");
		lblVerso.setForeground(new Color(255, 255, 255));
		lblVerso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVerso.setBounds(10, 68, 176, 27);
		contentPane.add(lblVerso);
		
		JLabel lblWwwsapientiacombr = new JLabel("www.sapientia.com.br");
		lblWwwsapientiacombr.setForeground(new Color(255, 255, 255));
		lblWwwsapientiacombr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWwwsapientiacombr.setBounds(10, 86, 176, 27);
		contentPane.add(lblWwwsapientiacombr);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Identifica\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel_1.setBounds(10, 115, 334, 132);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(98, 22, 226, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 56, 226, 22);
		panel_1.add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setBounds(10, 56, 90, 22);
		panel_1.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSenha.setForeground(new Color(95, 158, 160));
		
		JLabel lblLogin = new JLabel("Login.:");
		lblLogin.setBounds(10, 24, 90, 22);
		panel_1.add(lblLogin);
		lblLogin.setForeground(new Color(95, 158, 160));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAcessar.setBackground(Color.BLACK);
		btnAcessar.setBounds(98, 89, 100, 27);
		panel_1.add(btnAcessar);
		
		JButton btnCancelar = new JButton("Sair");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setBounds(224, 89, 100, 27);
		panel_1.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Usuario u =  Fachada.getInstance().efetuarLogin(textField.getText(), passwordField.getText());
				System.out.println(u.getTipo());
				System.out.println(u);
				if(u.getTipo().equals("C")){
					TelaInicialCliente tela = new TelaInicialCliente(u);
					dispose();
					tela.setVisible(true);
				}
				else if(u.getTipo().equals("F")){
					TelaInicialFunc tela = new TelaInicialFunc(u);
					dispose();
					tela.setVisible(true);
				}
				else{
					TelaInicialAdm tela = new TelaInicialAdm(u);
					dispose();
					tela.setVisible(true);
				}
				}catch(Exception exception){
					JOptionPane.showMessageDialog(null,"Login ou Senha Inválida!\n Digite os dados novamente!");
					textField.setText("");
					passwordField.setText("");
					textField.grabFocus();
					System.out.println(exception.getMessage());
				}
			}
		});
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(0, 0, 780, 443);
		contentPane.add(lbTelaAzul);
		
		JLabel label = new JLabel("SAPIENTIA");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		label.setBounds(-119, 106, 182, 43);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Sistema de Gerenciamento de Livros");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(-119, 160, 377, 27);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Vers\u00E3o: 1.0");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(-119, 198, 176, 27);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("www.sapientia.com.br");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(-119, 220, 176, 27);
		contentPane.add(label_3);
	}
	
}

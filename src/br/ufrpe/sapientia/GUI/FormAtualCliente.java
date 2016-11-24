package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import java.awt.event.*;

public class FormAtualCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfNascimento;
	private JTextField tfLogin;
	private JPasswordField passwordField;
	private JTextField tfEmail;
	private JTextField tfContato;
	private JTextField tfEndereco;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private Usuario cliente;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
					FormAtualCliente frame = new FormAtualCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FormAtualCliente(Usuario u) {
		cliente = u;
		setTitle("Atualizando Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 427, 176);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FormAtualCliente.class.getResource("/Imagens/pessoas.png")));
		label.setBounds(10, 23, 128, 151);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nome.:");
		label_1.setBounds(147, 23, 46, 14);
		panel.add(label_1);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(228, 23, 174, 20);
		panel.add(tfNome);
		tfNome.setText(cliente.getNome());
		tfNome.setEditable(false);
		
		
		JLabel label_2 = new JLabel("Cpf.:");
		label_2.setBounds(148, 48, 46, 14);
		panel.add(label_2);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(228, 48, 174, 20);
		panel.add(tfCPF);
		tfCPF.setText(cliente.getCpf());
		tfCPF.setEditable(false);
		
		JLabel label_3 = new JLabel("Nascimento.:");
		label_3.setBounds(148, 73, 86, 14);
		panel.add(label_3);
		
		tfNascimento = new JTextField();
		tfNascimento.setColumns(10);
		tfNascimento.setBounds(228, 70, 86, 20);
		panel.add(tfNascimento);
		// nao tem mais nascimento
		
		
		JLabel label_4 = new JLabel("Login.:");
		label_4.setBounds(147, 98, 46, 14);
		panel.add(label_4);
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(228, 95, 174, 20);
		panel.add(tfLogin);
		tfLogin.setText(cliente.getLogin());
		
		JLabel label_5 = new JLabel("Senha.:");
		label_5.setBounds(148, 123, 46, 14);
		panel.add(label_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 120, 174, 20);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(447, 11, 261, 261);
		contentPane.add(panel_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(FormAtualCliente.class.getResource("/Imagens/email.png")));
		label_6.setBounds(51, 11, 136, 157);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Email.:");
		label_7.setBounds(10, 179, 46, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Telefone.:");
		label_8.setBounds(10, 219, 56, 14);
		panel_1.add(label_8);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(76, 179, 175, 20);
		panel_1.add(tfEmail);
		tfEmail.setText(cliente.getEmail());
		
		tfContato = new JTextField();
		tfContato.setColumns(10);
		tfContato.setBounds(76, 216, 136, 20);
		panel_1.add(tfContato);
		tfContato.setText(cliente.getContato());
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(20, 198, 417, 176);
		contentPane.add(panel_2);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(FormAtualCliente.class.getResource("/Imagens/casa.png")));
		label_9.setBounds(10, 24, 119, 128);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("Logradouro.:");
		label_10.setBounds(139, 24, 75, 14);
		panel_2.add(label_10);
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(224, 18, 183, 20);
		panel_2.add(tfEndereco);
		tfEndereco.setText(cliente.getEndereco());
		
		JLabel label_11 = new JLabel("N\u00FAmero.:");
		label_11.setBounds(139, 49, 63, 14);
		panel_2.add(label_11);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(224, 43, 86, 20);
		panel_2.add(textField_7);
		
		JLabel label_12 = new JLabel("Bairro.:");
		label_12.setBounds(139, 74, 46, 14);
		panel_2.add(label_12);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(224, 68, 149, 20);
		panel_2.add(textField_8);
		
		JLabel label_13 = new JLabel("Cidade.:");
		label_13.setBounds(139, 99, 46, 14);
		panel_2.add(label_13);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(224, 93, 149, 20);
		panel_2.add(textField_9);
		
		JLabel label_14 = new JLabel("Estado.:");
		label_14.setBounds(139, 124, 46, 14);
		panel_2.add(label_14);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(224, 124, 46, 20);
		panel_2.add(comboBox);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(447, 319, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
				boolean a = Fachada.getInstance().atualizarUsuario(cliente.getCpf(), cliente.getNome(), tfContato.getText(), tfEndereco.getText(),
						tfEmail.getText(), tfLogin.getText(), passwordField.getText(), "C", "H");	
				if(a){
					//sucesso
					dispose();
				}
				
				}catch(Exception exception){
					
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(619, 319, 89, 23);
		contentPane.add(btnSair);
	}

}

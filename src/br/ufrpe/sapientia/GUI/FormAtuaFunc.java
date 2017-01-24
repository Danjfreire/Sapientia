package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.*;
import java.text.ParseException;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import javax.swing.DefaultComboBoxModel;

public class FormAtuaFunc extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JComboBox tfSexo;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfEmail;
	private JTextField tfContato;
	private Usuario funcionario;
	private JPasswordField pfConfirmar;

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
					FormAtuaFunc frame = new FormAtuaFunc();
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
	public FormAtuaFunc(Usuario u) {
		funcionario = u;
		setTitle("Atualizando Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 461, 176);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FormAtuaFunc.class.getResource("/Imagens/manager.png")));
		label.setBounds(10, 23, 128, 151);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nome.:");
		label_1.setBounds(147, 23, 46, 14);
		panel.add(label_1);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(277, 20, 174, 20);
		panel.add(tfNome);
		tfNome.setText(funcionario.getNome());
		tfNome.setEditable(false);
		
		JLabel label_2 = new JLabel("Cpf.:");
		label_2.setBounds(148, 48, 46, 14);
		panel.add(label_2);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(277, 45, 174, 20);
		panel.add(tfCPF);
		tfCPF.setText(funcionario.getCpf());
		tfCPF.setEditable(false);
		
		JLabel Sexo = new JLabel("Sexo.:");
		Sexo.setBounds(148, 73, 86, 14);
		panel.add(Sexo);
		
		tfSexo = new JComboBox();
		tfSexo.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
		tfSexo.setBounds(277, 70, 174, 20);
		panel.add(tfSexo);
		
		JLabel label_4 = new JLabel("Login.:");
		label_4.setBounds(147, 98, 46, 14);
		panel.add(label_4);
		
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(277, 95, 174, 20);
		panel.add(tfLogin);
		
		JLabel label_5 = new JLabel("Senha.:");
		label_5.setBounds(148, 123, 46, 14);
		panel.add(label_5);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(277, 120, 174, 20);
		panel.add(pfSenha);
		
		pfConfirmar = new JPasswordField();
		pfConfirmar.setBounds(277, 145, 174, 20);
		panel.add(pfConfirmar);
		pfConfirmar.setColumns(10);
		
		JLabel lblConfimarSenha = new JLabel("Confimar Senha.:");
		lblConfimarSenha.setBounds(148, 148, 86, 14);
		panel.add(lblConfimarSenha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 198, 451, 176);
		contentPane.add(panel_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(FormAtuaFunc.class.getResource("/Imagens/casa.png")));
		label_6.setBounds(10, 24, 119, 128);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Logradouro.:");
		label_7.setBounds(139, 24, 75, 14);
		panel_1.add(label_7);
		
		tfLogradouro = new JTextField();
		tfLogradouro.setColumns(10);
		tfLogradouro.setBounds(224, 18, 217, 20);
		panel_1.add(tfLogradouro);
		
		JLabel label_8 = new JLabel("N\u00FAmero.:");
		label_8.setBounds(139, 49, 63, 14);
		panel_1.add(label_8);
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		tfNumero.setBounds(224, 43, 217, 20);
		panel_1.add(tfNumero);
		
		JLabel label_9 = new JLabel("Bairro.:");
		label_9.setBounds(139, 74, 46, 14);
		panel_1.add(label_9);
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(224, 68, 217, 20);
		panel_1.add(tfBairro);
		
		JLabel label_10 = new JLabel("Cidade.:");
		label_10.setBounds(139, 99, 46, 14);
		panel_1.add(label_10);
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(224, 93, 217, 20);
		panel_1.add(tfCidade);
		
		JLabel label_11 = new JLabel("Estado.:");
		label_11.setBounds(139, 124, 46, 14);
		panel_1.add(label_11);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PE", "AM", "BA", "SC", "RJ", "SP"}));
		comboBox.setBounds(224, 124, 46, 20);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(481, 11, 261, 261);
		contentPane.add(panel_2);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(FormAtuaFunc.class.getResource("/Imagens/email.png")));
		label_12.setBounds(51, 11, 136, 157);
		panel_2.add(label_12);
		
		JLabel label_13 = new JLabel("Email.:");
		label_13.setBounds(10, 179, 46, 14);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Telefone.:");
		label_14.setBounds(10, 219, 56, 14);
		panel_2.add(label_14);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(76, 179, 175, 20);
		panel_2.add(tfEmail);
		
		try {
			tfContato = new JFormattedTextField(new MaskFormatter("(##) - ##### - ####"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfContato.setColumns(10);
		tfContato.setBounds(76, 216, 175, 20);
		panel_2.add(tfContato);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(520, 319, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(pfSenha.getText().equals(pfConfirmar.getText())){
					try{
						String sexo = (String)tfSexo.getSelectedItem();
						boolean a = Fachada.getInstance().atualizarUsuario(funcionario.getCpf(), funcionario.getNome(), tfContato.getText(), tfLogradouro.getText(),
								tfEmail.getText(), tfLogin.getText(), pfSenha.getText(), "F", "" + sexo.charAt(0));	
						if(a){
							JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
							dispose();
						}else{
							JOptionPane.showMessageDialog(null,"Dados inválidos!");
							tfContato.setText("");
							tfEmail.setText("");
							tfLogin.setText("");
							pfSenha.setText("");
							tfLogradouro.setText("");
							tfBairro.setText("");
							tfCidade.setText("");
						}
						
					}catch(Exception exception){
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "As senhas não são iguais");
					pfSenha.setText("");
					pfConfirmar.setText("");
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(619, 319, 89, 23);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					
					dispose();
				}catch(Exception exception){
					
				}
			}
		});
	}
}

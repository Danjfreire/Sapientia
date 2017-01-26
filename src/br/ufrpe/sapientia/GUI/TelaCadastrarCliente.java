package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;
import java.awt.ItemSelectable;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.*;
import java.text.ParseException;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;

public class TelaCadastrarCliente extends JInternalFrame {
	private JTextField tfNome;
	private JFormattedTextField tfCpf;
	private JTextField tfLogin;
	private JPasswordField psSenha;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfEmail;
	private JFormattedTextField tfTelefone;
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
					TelaCadastrarCliente frame = new TelaCadastrarCliente();
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
	public TelaCadastrarCliente() {
		
		
		setTitle("Cadastrar Clientes");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 427, 215);
		panel.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastrarCliente.class.getResource("/Imagens/pessoas.png")));
		label.setBounds(10, 42, 128, 151);
		panel.add(label);
		
		JLabel lblNome = new JLabel("Nome.:");
		lblNome.setBounds(148, 30, 46, 14);
		panel.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(239, 27, 164, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf.:");
		lblCpf.setBounds(148, 55, 46, 14);
		panel.add(lblCpf);
		
		try {
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfCpf.setBounds(239, 52, 164, 20);
		panel.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login.:");
		lblLogin.setBounds(148, 105, 46, 14);
		panel.add(lblLogin);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(239, 102, 164, 20);
		panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setBounds(148, 130, 46, 14);
		panel.add(lblSenha);
		
		psSenha = new JPasswordField();
		psSenha.setBounds(239, 127, 164, 20);
		panel.add(psSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha.:");
		lblConfirmarSenha.setBounds(148, 155, 128, 14);
		panel.add(lblConfirmarSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(239, 152, 163, 20);
		panel.add(passwordField);
		
		JLabel lblSexo = new JLabel("Sexo.:");
		lblSexo.setBounds(148, 80, 46, 14);
		panel.add(lblSexo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
		comboBox.setBounds(239, 77, 164, 20);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 237, 417, 165);
		panel_1.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaCadastrarCliente.class.getResource("/Imagens/casa.png")));
		label_1.setBounds(10, 22, 119, 128);
		panel_1.add(label_1);
		
		JLabel lblLogradouro = new JLabel("Logradouro.:");
		lblLogradouro.setBounds(139, 22, 75, 14);
		panel_1.add(lblLogradouro);
		
		tfLogradouro = new JTextField();
		tfLogradouro.setBounds(224, 19, 183, 20);
		panel_1.add(tfLogradouro);
		tfLogradouro.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero.:");
		lblNmero.setBounds(139, 47, 63, 14);
		panel_1.add(lblNmero);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(224, 44, 183, 20);
		panel_1.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro.:");
		lblBairro.setBounds(139, 72, 46, 14);
		panel_1.add(lblBairro);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(224, 69, 183, 20);
		panel_1.add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade.:");
		lblCidade.setBounds(139, 97, 46, 14);
		panel_1.add(lblCidade);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(224, 94, 183, 20);
		panel_1.add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado.:");
		lblEstado.setBounds(139, 122, 46, 14);
		panel_1.add(lblEstado);
		
		JComboBox cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"PE", "AM", "BA", "SC", "RJ", "SP"}));
		cbEstado.setBounds(224, 119, 183, 20);
		panel_1.add(cbEstado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(463, 11, 261, 261);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaCadastrarCliente.class.getResource("/Imagens/email.png")));
		label_2.setBounds(51, 11, 136, 157);
		panel_2.add(label_2);
		
		JLabel lblEmail = new JLabel("Email.:");
		lblEmail.setBounds(10, 179, 46, 14);
		panel_2.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone.:");
		lblTelefone.setBounds(10, 219, 56, 14);
		panel_2.add(lblTelefone);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(76, 179, 175, 20);
		panel_2.add(tfEmail);
		tfEmail.setColumns(10);
		
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("(##) - ##### - ####"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfTelefone.setBounds(76, 216, 175, 20);
		panel_2.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(477, 317, 98, 23);
		getContentPane().add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String sexo = (String)comboBox.getSelectedItem();
					if(psSenha.getText().equals(passwordField.getText())){
						Usuario u = new Usuario(tfNome.getText(), tfCpf.getText(), tfTelefone.getText(), tfEmail.getText(), tfLogin.getText(), psSenha.getText(), "" + sexo.charAt(0), 
							"C", tfLogradouro.getText(), Integer.parseInt(tfNumero.getText()), tfBairro.getText(), tfCidade.getText(), (String)cbEstado.getSelectedItem());
						if(Fachada.getInstance().CadastrarUsuario(u)){
							JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso!");
							dispose();
						}else{
						JOptionPane.showMessageDialog(null,"Dados inválidos!");
						tfNome.setText("");
						tfCpf.setText("");
						tfTelefone.setText("");
						tfEmail.setText("");
						tfLogin.setText("");
						psSenha.setText("");
						tfLogradouro.setText("");
						tfBairro.setText("");
						tfCidade.setText("");
					 }
					}
					else{
						JOptionPane.showMessageDialog(null, "As senhas não são iguais");
						psSenha.setText("");
						passwordField.setText("");
					}
				}catch(Exception exception){
					
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(595, 317, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
	}
}

package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.*;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.JButton;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import javax.swing.JFormattedTextField;

public class TelaCadastrarFuncionario extends JInternalFrame {
	private JTextField tfNome;
	private JFormattedTextField tfCpf;
	private JFormattedTextField tfNascimento;
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
					TelaCadastrarFuncionario frame = new TelaCadastrarFuncionario();
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
	public TelaCadastrarFuncionario() {
		setTitle("Cadastrar Funcionários");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 750, 488);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 43, 427, 190);
		panel.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastrarFuncionario.class.getResource("/Imagens/manager.png")));
		label.setBounds(10, 23, 128, 151);
		panel.add(label);
		
		JLabel lblNome = new JLabel("Nome.:");
		lblNome.setBounds(147, 23, 46, 14);
		panel.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setToolTipText("Digite seu nome");
		tfNome.setBounds(238, 23, 164, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf.:");
		lblCpf.setBounds(148, 48, 46, 14);
		panel.add(lblCpf);
		
		try {
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			tfCpf.setToolTipText("Digite seu cpf");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfCpf.setBounds(238, 48, 86, 20);
		panel.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNascimento = new JLabel("Nascimento.:");
		lblNascimento.setBounds(148, 79, 86, 14);
		panel.add(lblNascimento);
		
		try {
			tfNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
			tfNascimento.setToolTipText("Data de nascimento");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfNascimento.setBounds(238, 76, 67, 20);
		panel.add(tfNascimento);
		tfNascimento.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login.:");
		lblLogin.setBounds(147, 104, 46, 14);
		panel.add(lblLogin);
		
		tfLogin = new JTextField();
		tfLogin.setToolTipText("Digite seu Login");
		tfLogin.setBounds(238, 101, 164, 20);
		panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setBounds(148, 129, 46, 14);
		panel.add(lblSenha);
		
		psSenha = new JPasswordField();
		psSenha.setToolTipText("8 Caracteres");
		psSenha.setBounds(238, 126, 76, 20);
		panel.add(psSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha.:");
		lblConfirmarSenha.setBounds(147, 157, 133, 14);
		panel.add(lblConfirmarSenha);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("8 caracteres");
		passwordField.setBounds(238, 154, 76, 20);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 268, 417, 176);
		panel_1.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaCadastrarFuncionario.class.getResource("/Imagens/casa.png")));
		label_1.setBounds(10, 24, 119, 128);
		panel_1.add(label_1);
		
		JLabel lblLogradouro = new JLabel("Logradouro.:");
		lblLogradouro.setBounds(139, 24, 75, 14);
		panel_1.add(lblLogradouro);
		
		tfLogradouro = new JTextField();
		tfLogradouro.addFocusListener(new FocusAdapter() {
		});
		tfLogradouro.setToolTipText("Rua");
		tfLogradouro.setBounds(224, 18, 183, 20);
		panel_1.add(tfLogradouro);
		tfLogradouro.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero.:");
		lblNmero.setBounds(139, 49, 63, 14);
		panel_1.add(lblNmero);
		
		tfNumero = new JTextField();
		tfNumero.setToolTipText("N\u00FAmero da Resid\u00EAncia");
		tfNumero.setBounds(224, 43, 86, 20);
		panel_1.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro.:");
		lblBairro.setBounds(139, 74, 46, 14);
		panel_1.add(lblBairro);
		
		tfBairro = new JTextField();
		tfBairro.setToolTipText("Seu Bairro");
		tfBairro.setBounds(224, 68, 149, 20);
		panel_1.add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade.:");
		lblCidade.setBounds(139, 99, 46, 14);
		panel_1.add(lblCidade);
		
		tfCidade = new JTextField();
		tfCidade.setToolTipText("Sua cidade");
		tfCidade.setBounds(224, 93, 149, 20);
		panel_1.add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado.:");
		lblEstado.setBounds(139, 124, 46, 14);
		panel_1.add(lblEstado);
		
		JComboBox cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE","PE", "AM", "BA", "SC", "RJ", "SP"}));
		cbEstado.setBounds(224, 124, 86, 20);
		panel_1.add(cbEstado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(473, 81, 261, 261);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaCadastrarFuncionario.class.getResource("/Imagens/email.png")));
		label_2.setBounds(51, 11, 136, 157);
		panel_2.add(label_2);
		
		JLabel lblEmail = new JLabel("Email.:");
		lblEmail.setBounds(10, 179, 46, 14);
		panel_2.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone.:");
		lblTelefone.setBounds(10, 219, 56, 14);
		panel_2.add(lblTelefone);
		
		tfEmail = new JTextField();
		tfEmail.setToolTipText("Seu email");
		tfEmail.setBounds(76, 179, 175, 20);
		panel_2.add(tfEmail);
		tfEmail.setColumns(10);
		
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("(##) - ##### - ####"));
			tfTelefone.setToolTipText("Telefone");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfTelefone.setBounds(76, 216, 109, 20);
		panel_2.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(473, 410, 98, 23);
		getContentPane().add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				
				try{
					Usuario u =  new Usuario("F", tfNome.getText(), tfCpf.getText(), tfTelefone.getText(), tfEmail.getText(), tfLogin.getText(), psSenha.getText(), "M",
							tfLogradouro.getText()+" "+ tfBairro.getText()+" "+ tfCidade.getText());
					boolean a = Fachada.getInstance().CadastrarUsuario(u);
					if(a){
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
				}catch(Exception exception){
					
					
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(635, 410, 89, 23);
		getContentPane().add(btnCancelar);
		
		
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					dispose();	
				}catch (Exception exception){
					
				}
			}
		});

	}
}

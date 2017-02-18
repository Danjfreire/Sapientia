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
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.JButton;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class TelaCadastrarFuncionario extends JInternalFrame {
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
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 427, 190);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastrarFuncionario.class.getResource("/Imagens/manager.png")));
		label.setBounds(10, 23, 128, 151);
		panel.add(label);
		
		JLabel lblNome = new JLabel("Nome.:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(new Color(95, 158, 160));
		lblNome.setBounds(131, 23, 46, 14);
		panel.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfNome.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		tfNome.setToolTipText("Digite seu nome");
		tfNome.setBounds(238, 20, 164, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf.:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setForeground(new Color(95, 158, 160));
		lblCpf.setBounds(131, 48, 46, 14);
		panel.add(lblCpf);
		
		try {
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			tfCpf.setToolTipText("Digite seu cpf");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfCpf.setBounds(238, 45, 164, 20);
		panel.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo.:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setForeground(new Color(95, 158, 160));
		lblSexo.setBounds(131, 73, 86, 14);
		panel.add(lblSexo);
		
		
		JLabel lblLogin = new JLabel("Login.:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setForeground(new Color(95, 158, 160));
		lblLogin.setBounds(131, 98, 46, 14);
		panel.add(lblLogin);
		
		tfLogin = new JFormattedTextField();
		tfLogin.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfLogin.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		tfLogin.setToolTipText("Digite seu Login");
		tfLogin.setBounds(238, 95, 164, 20);
		panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setForeground(new Color(95, 158, 160));
		lblSenha.setBounds(131, 123, 46, 14);
		panel.add(lblSenha);
		
		psSenha = new JPasswordField();
		psSenha.setToolTipText("8 Caracteres");
		psSenha.setBounds(238, 120, 164, 20);
		panel.add(psSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha.:");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConfirmarSenha.setForeground(new Color(95, 158, 160));
		lblConfirmarSenha.setBounds(131, 148, 133, 14);
		panel.add(lblConfirmarSenha);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("8 caracteres");
		passwordField.setBounds(238, 145, 164, 20);
		panel.add(passwordField);
		
		JComboBox cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
		cbSexo.setBounds(238, 70, 164, 20);
		panel.add(cbSexo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 212, 427, 176);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaCadastrarFuncionario.class.getResource("/Imagens/casa.png")));
		label_1.setBounds(10, 24, 119, 128);
		panel_1.add(label_1);
		
		JLabel lblLogradouro = new JLabel("Logradouro.:");
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogradouro.setForeground(new Color(95, 158, 160));
		lblLogradouro.setBounds(139, 24, 75, 14);
		panel_1.add(lblLogradouro);
		
		
		tfLogradouro = new JTextField();
		tfLogradouro.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfLogradouro.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		tfLogradouro.addFocusListener(new FocusAdapter() {
		});
		tfLogradouro.setToolTipText("Rua");
		tfLogradouro.setBounds(224, 18, 183, 20);
		panel_1.add(tfLogradouro);
		tfLogradouro.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero.:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNmero.setForeground(new Color(95, 158, 160));
		lblNmero.setBounds(139, 49, 63, 14);
		panel_1.add(lblNmero);
		
		tfNumero = new JFormattedTextField();
		tfNumero.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(!(Character.isDigit(e.getKeyChar())) || tfNumero.getText().length() == 9 ){
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_DELETE)
						getToolkit().beep();
					e.consume();
				}
			}
		});
		tfNumero.setToolTipText("N\u00FAmero da Resid\u00EAncia");
		tfNumero.setBounds(224, 43, 183, 20);
		panel_1.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro.:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setForeground(new Color(95, 158, 160));
		lblBairro.setBounds(139, 74, 46, 14);
		panel_1.add(lblBairro);
		
		
		tfBairro = new JTextField();
		tfBairro.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfBairro.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		tfBairro.setToolTipText("Seu Bairro");
		tfBairro.setBounds(224, 68, 183, 20);
		panel_1.add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade.:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setForeground(new Color(95, 158, 160));
		lblCidade.setBounds(139, 99, 46, 14);
		panel_1.add(lblCidade);
		
		tfCidade = new JTextField();
		tfCidade.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfCidade.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		tfCidade.setToolTipText("Sua cidade");
		tfCidade.setBounds(224, 93, 183, 20);
		panel_1.add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado.:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setForeground(new Color(95, 158, 160));
		lblEstado.setBounds(139, 124, 46, 14);
		panel_1.add(lblEstado);
		
		JComboBox cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"PE", "AM", "BA", "SC", "RJ", "SP"}));
		cbEstado.setBounds(224, 124, 86, 20);
		panel_1.add(cbEstado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel_2.setBounds(473, 11, 261, 261);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaCadastrarFuncionario.class.getResource("/Imagens/email.png")));
		label_2.setBounds(51, 11, 136, 157);
		panel_2.add(label_2);
		
		JLabel lblEmail = new JLabel("Email.:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setForeground(new Color(95, 158, 160));
		lblEmail.setBounds(10, 179, 46, 14);
		panel_2.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone.:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setForeground(new Color(95, 158, 160));
		lblTelefone.setBounds(10, 219, 66, 14);
		panel_2.add(lblTelefone);
		
		try {
			tfEmail = new JFormattedTextField(new MaskFormatter("**************************************************"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfEmail.setToolTipText("Seu email");
		tfEmail.setBounds(76, 179, 175, 20);
		panel_2.add(tfEmail);
		tfEmail.setColumns(10);
		
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			tfTelefone.setToolTipText("Telefone");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfTelefone.setBounds(76, 216, 175, 20);
		panel_2.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.BLACK);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.setBounds(491, 315, 107, 27);
		getContentPane().add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				try{
					String sexo = (String)cbSexo.getSelectedItem();
					if(!(psSenha.getText().equals(passwordField.getText()))){
						JOptionPane.showMessageDialog(null, "As senhas não são iguais");
						psSenha.setText("");
						passwordField.setText("");
						psSenha.grabFocus();;
					}else if(tfCpf.getText().equals("000.000.000-00")){
						JOptionPane.showMessageDialog(null, "Cpf inválido");
						tfNome.grabFocus();
					}
					else if(tfNome.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo nome vazio");
						tfNome.grabFocus();
					}
					else if(tfCpf.getText().equals("   .   .   -  ")){
						JOptionPane.showMessageDialog(null, "Campo cpf vazio");
						tfCpf.grabFocus();
					}
					else if(tfLogin.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo login vazio");
						tfLogin.grabFocus();
					}
					else if(psSenha.getText().length() < 8){
						JOptionPane.showMessageDialog(null, "Senha muito pequena");
						psSenha.grabFocus();
					}
					else if(tfLogradouro.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo logradouro vazio");
						tfLogradouro.grabFocus();
					}
					else if(tfBairro.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo bairro vazio");
						tfBairro.grabFocus();
					}
					else if(tfCidade.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo cidade vazio");
						tfCidade.grabFocus();
					}
					else if(tfTelefone.getText().equals("(  )      -    ")){
						JOptionPane.showMessageDialog(null, "Campo contato vazio");
						tfTelefone.grabFocus();
					}
					else{
						Usuario u = new Usuario(tfNome.getText(), tfCpf.getText(), tfTelefone.getText(), tfEmail.getText(), tfLogin.getText(), psSenha.getText(), "" + sexo.charAt(0), 
								"F", tfLogradouro.getText(), Integer.parseInt(tfNumero.getText()), tfBairro.getText(), tfCidade.getText(), (String)cbEstado.getSelectedItem());
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
				}catch(SQLException exception){
					ErrosGUI eg = new ErrosGUI(exception, tfCpf, tfLogin, tfEmail, psSenha, passwordField);
					eg.mensagemUsuario();
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Campo número em branco!");
					tfNumero.grabFocus();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setBounds(616, 315, 107, 27);
		getContentPane().add(btnCancelar);
		
		
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					dispose();	
				}catch (Exception exception){
					
				}
			}
		});
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);

	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}

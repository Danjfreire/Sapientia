package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;
import java.awt.HeadlessException;
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
import java.sql.SQLException;
import java.text.ParseException;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import java.awt.Font;

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
	private JPasswordField psConfirmar;

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
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 443, 215);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastrarCliente.class.getResource("/Imagens/pessoas.png")));
		label.setBounds(10, 42, 128, 151);
		panel.add(label);
		
		JLabel lblNome = new JLabel("Nome.:");
		lblNome.setForeground(new Color(95, 158, 160));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(148, 30, 46, 14);
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
		tfNome.setBounds(270, 27, 164, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf.:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setForeground(new Color(95, 158, 160));
		lblCpf.setBounds(148, 55, 46, 14);
		panel.add(lblCpf);
		
		try {
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfCpf.setBounds(270, 52, 164, 20);
		panel.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login.:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setForeground(new Color(95, 158, 160));
		lblLogin.setBounds(148, 105, 46, 14);
		panel.add(lblLogin);
		

		tfLogin = new JTextField();
		tfLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfLogin.getText().length() == 50){
					getToolkit().beep();
					e.consume();
				}
			}
		});
		tfLogin.setBounds(270, 102, 164, 20);
		panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setForeground(new Color(95, 158, 160));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(148, 130, 46, 14);
		panel.add(lblSenha);
		
		psSenha = new JPasswordField();
		psSenha.setBounds(270, 127, 164, 20);
		panel.add(psSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha.:");
		lblConfirmarSenha.setForeground(new Color(95, 158, 160));
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConfirmarSenha.setBounds(148, 155, 128, 14);
		panel.add(lblConfirmarSenha);
		
		psConfirmar = new JPasswordField();
		psConfirmar.setBounds(270, 152, 163, 20);
		panel.add(psConfirmar);
		
		JLabel lblSexo = new JLabel("Sexo.:");
		lblSexo.setForeground(new Color(95, 158, 160));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setBounds(148, 80, 46, 14);
		panel.add(lblSexo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
		comboBox.setBounds(270, 77, 164, 20);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 237, 443, 165);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaCadastrarCliente.class.getResource("/Imagens/casa.png")));
		label_1.setBounds(10, 22, 119, 128);
		panel_1.add(label_1);
		
		JLabel lblLogradouro = new JLabel("Logradouro.:");
		lblLogradouro.setForeground(new Color(95, 158, 160));
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogradouro.setBounds(139, 22, 75, 14);
		panel_1.add(lblLogradouro);
		
		
		tfLogradouro = new JTextField();
		tfLogradouro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfLogradouro.getText().length() == 50){
					getToolkit().beep();
					e.consume();
				}
			}
		});
		tfLogradouro.setBounds(250, 19, 183, 20);
		panel_1.add(tfLogradouro);
		tfLogradouro.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero.:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNmero.setForeground(new Color(95, 158, 160));
		lblNmero.setBounds(139, 47, 63, 14);
		panel_1.add(lblNmero);
		
		tfNumero = new JTextField();
		tfNumero.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(!(Character.isDigit(e.getKeyChar())) || tfNumero.getText().length() == 9 ){
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_DELETE)
						getToolkit().beep();
					e.consume();
				}
			}
		});
		tfNumero.setBounds(250, 44, 183, 20);
		panel_1.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro.:");
		lblBairro.setForeground(new Color(95, 158, 160));
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setBounds(139, 72, 46, 14);
		panel_1.add(lblBairro);
		
		
		tfBairro = new JTextField();
		tfBairro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfBairro.getText().length() == 50){
					getToolkit().beep();
					e.consume();
				}
			}
		});
		tfBairro.setBounds(250, 69, 183, 20);
		panel_1.add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade.:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setForeground(new Color(95, 158, 160));
		lblCidade.setBounds(139, 97, 46, 14);
		panel_1.add(lblCidade);
		
		
		tfCidade = new JTextField();
		tfCidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfCidade.getText().length() == 50){
					getToolkit().beep();
					e.consume();
				}
			}
		});
		tfCidade.setBounds(250, 94, 183, 20);
		panel_1.add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado.:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setForeground(new Color(95, 158, 160));
		lblEstado.setBounds(139, 122, 46, 14);
		panel_1.add(lblEstado);
		
		JComboBox cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"PE", "AM", "BA", "SC", "RJ", "SP"}));
		cbEstado.setBounds(250, 119, 183, 20);
		panel_1.add(cbEstado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel_2.setBounds(463, 11, 261, 261);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaCadastrarCliente.class.getResource("/Imagens/email.png")));
		label_2.setBounds(51, 11, 136, 157);
		panel_2.add(label_2);
		
		JLabel lblEmail = new JLabel("Email.:");
		lblEmail.setForeground(new Color(95, 158, 160));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 179, 46, 14);
		panel_2.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone.:");
		lblTelefone.setForeground(new Color(95, 158, 160));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(10, 219, 56, 14);
		panel_2.add(lblTelefone);
		
		tfEmail = new JTextField();
		tfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfEmail.getText().length() == 50){
					getToolkit().beep();
					e.consume();
				}
			}
		});
		tfEmail.setBounds(76, 179, 175, 20);
		panel_2.add(tfEmail);
		tfEmail.setColumns(10);
		
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
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
		btnCadastrar.setBounds(477, 317, 107, 27);
		getContentPane().add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String sexo = (String)comboBox.getSelectedItem();
					if(!(psSenha.getText().equals(psConfirmar.getText()))){
						JOptionPane.showMessageDialog(null, "As senhas não são iguais");
						psSenha.setText("");
						psConfirmar.setText("");
						psSenha.grabFocus();;
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
				}catch(SQLException exception){
					ErrosGUI eg = new ErrosGUI(exception, tfCpf, tfLogin, tfEmail, psSenha, psConfirmar);
					eg.mensagemUsuario();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Campo número em branco!");
					tfNumero.grabFocus();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(603, 317, 107, 27);
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

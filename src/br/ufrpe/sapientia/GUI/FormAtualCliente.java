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
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class FormAtualCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JComboBox cbSexo;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	private JTextField tfEmail;
	private JFormattedTextField tfContato;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private Usuario cliente;
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
		setBounds(100, 100, 791, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 467, 176);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FormAtualCliente.class.getResource("/Imagens/pessoas.png")));
		label.setBounds(10, 23, 128, 151);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nome.:");
		label_1.setBounds(148, 23, 46, 14);
		panel.add(label_1);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(270, 20, 187, 20);
		panel.add(tfNome);
		tfNome.setText(cliente.getNome());
		tfNome.setEditable(false);
		
		
		JLabel label_2 = new JLabel("Cpf.:");
		label_2.setBounds(148, 48, 46, 14);
		panel.add(label_2);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(270, 45, 187, 20);
		panel.add(tfCPF);
		tfCPF.setText(cliente.getCpf());
		tfCPF.setEditable(false);
		
		JLabel lblSexo = new JLabel("Sexo.:");
		lblSexo.setBounds(148, 73, 86, 14);
		panel.add(lblSexo);
		
		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
		cbSexo.setBounds(270, 70, 187, 20);
		panel.add(cbSexo);		
		
		JLabel label_4 = new JLabel("Login.:");
		label_4.setBounds(148, 98, 46, 14);
		panel.add(label_4);
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(270, 95, 187, 20);
		panel.add(tfLogin);
		tfLogin.setText(cliente.getLogin());
		
		JLabel label_5 = new JLabel("Senha.:");
		label_5.setBounds(148, 123, 46, 14);
		panel.add(label_5);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(270, 120, 187, 20);
		panel.add(pfSenha);
		pfSenha.setText(cliente.getSenha());
		
		JLabel lblConfirmar = new JLabel("Confirmar Senha:.");
		lblConfirmar.setBounds(148, 148, 97, 14);
		panel.add(lblConfirmar);
		
		pfConfirmar = new JPasswordField();
		pfConfirmar.setBounds(270, 145, 187, 20);
		panel.add(pfConfirmar);
		pfConfirmar.setColumns(10);
		pfConfirmar.setText(cliente.getSenha());
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(499, 11, 261, 261);
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
		
		try {
			tfContato = new JFormattedTextField(new MaskFormatter("(##) - ##### - ####"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfContato.setColumns(10);
		tfContato.setBounds(76, 216, 175, 20);
		panel_1.add(tfContato);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(20, 198, 457, 176);
		contentPane.add(panel_2);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(FormAtualCliente.class.getResource("/Imagens/casa.png")));
		label_9.setBounds(10, 24, 119, 128);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("Logradouro.:");
		label_10.setBounds(139, 24, 75, 14);
		panel_2.add(label_10);
		
		tfLogradouro = new JTextField();
		tfLogradouro.setColumns(10);
		tfLogradouro.setBounds(264, 21, 183, 20);
		panel_2.add(tfLogradouro);
		tfLogradouro.setText(cliente.getLogradouro());
		
		JLabel label_11 = new JLabel("N\u00FAmero.:");
		label_11.setBounds(139, 49, 63, 14);
		panel_2.add(label_11);
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		tfNumero.setBounds(264, 46, 183, 20);
		panel_2.add(tfNumero);
		tfNumero.setText(Integer.toString(cliente.getNumero()));
		
		JLabel label_12 = new JLabel("Bairro.:");
		label_12.setBounds(139, 74, 46, 14);
		panel_2.add(label_12);
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(264, 71, 183, 20);
		panel_2.add(tfBairro);
		tfBairro.setText(cliente.getBairro());
		
		JLabel label_13 = new JLabel("Cidade.:");
		label_13.setBounds(139, 99, 46, 14);
		panel_2.add(label_13);
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(264, 96, 183, 20);
		panel_2.add(tfCidade);
		tfCidade.setText(cliente.getCidade());
		
		JLabel label_14 = new JLabel("Estado.:");
		label_14.setBounds(139, 124, 46, 14);
		panel_2.add(label_14);
		
		JComboBox cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"PE", "AM", "BA", "SC", "RJ", "SP"}));
		cbEstado.setBounds(264, 121, 183, 20);
		panel_2.add(cbEstado);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(532, 319, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(pfSenha.getText().equals(pfConfirmar.getText())){
					try{
						String sexo = (String)cbSexo.getSelectedItem();
						boolean a = Fachada.getInstance().atualizarUsuario(cliente.getCpf(), cliente.getNome(), tfContato.getText(), 
								 tfEmail.getText(), tfLogin.getText(), pfSenha.getText(), "C", "" + sexo.charAt(0), tfLogradouro.getText(),
								 Integer.parseInt(tfNumero.getText()), tfBairro.getText(), tfCidade.getText(), (String)cbEstado.getSelectedItem());	
						if(a){
							JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(null,"Dados inv�lidos!");
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
				}
				else{
					JOptionPane.showMessageDialog(null, "As senhas n�o s�o iguais");
					pfSenha.setText("");
					pfConfirmar.setText("");
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(653, 319, 89, 23);
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

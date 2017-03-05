package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.Usuario;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class TelaAtualAdm extends JInternalFrame {
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JPasswordField passwordField_1;
	private Usuario u;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
					TelaAtualAdm frame = new TelaAtualAdm();
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
	public TelaAtualAdm(Usuario u) {
		getContentPane().setForeground(new Color(135, 206, 250));
		setClosable(true);
		setTitle("Atualizar Administrador");
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("SAPIENTIA");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		label_1.setBounds(10, 46, 182, 43);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Sistema de Gerenciamento de Livros");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(10, 100, 377, 27);
		getContentPane().add(label_2);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Atualizar Senha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel.setBounds(10, 138, 377, 162);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(textField_3.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		textField_3.setBounds(155, 23, 203, 24);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(u.getLogin());
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(passwordField.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		passwordField.setBounds(155, 58, 203, 22);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(passwordField_1.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		passwordField_1.setBounds(155, 91, 203, 22);
		panel.add(passwordField_1);
		
		JLabel label_8 = new JLabel("Confirmar Senha.:");
		label_8.setBounds(10, 89, 142, 22);
		panel.add(label_8);
		label_8.setForeground(new Color(95, 158, 160));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel label_6 = new JLabel("Senha.:");
		label_6.setBounds(10, 58, 142, 22);
		panel.add(label_6);
		label_6.setForeground(new Color(95, 158, 160));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel label_7 = new JLabel("Login.:");
		label_7.setBounds(10, 25, 142, 22);
		panel.add(label_7);
		label_7.setForeground(new Color(95, 158, 160));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_3.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Campo login em branco!");
					textField_3.grabFocus();
				}
				else if(passwordField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Campo senha em branco!");
					passwordField.grabFocus();
				}
				else if(!(passwordField.getText().equals(passwordField_1.getText()))){
					JOptionPane.showMessageDialog(null, "Senhas diferentes");
					passwordField.setText("");
					passwordField_1.setText("");
					passwordField.grabFocus();
				}
				else{
					try{
						if(Fachada.getInstance().atualizarUsuario(u.getCpf(), u.getNome(), u.getContato(), u.getEmail(), textField_3.getText(),
								passwordField.getText(), "A", u.getSexo(), u.getLogradouro(), u.getNumero(), u.getBairro(), u.getCidade(), u.getEstado())){
							JOptionPane.showMessageDialog(null, "Atualização efetuada!");
							dispose();
						}
					}catch(SQLException e){
						JOptionPane.showMessageDialog(null, "Login já cadastrado");
						textField_3.setText("");
						textField_3.grabFocus();
					}
					catch(Exception e1){
						e1.getMessage();
					}
				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalvar.setBounds(155, 124, 90, 27);
		panel.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setBounds(265, 124, 90, 27);
		panel.add(btnSair);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/pensador3.png")));
		label.setBounds(-7, -26, 780, 443);
		getContentPane().add(label);

	}
}

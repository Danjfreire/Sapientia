package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualAdm extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

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
					TelaAtualAdm frame = new TelaAtualAdm();
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
	public TelaAtualAdm() {
		setClosable(true);
		setTitle("Atualizar ADM");
		setIconifiable(true);
		setBounds(100, 100, 450, 276);
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login.:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(31, 56, 73, 27);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(31, 127, 73, 27);
		getContentPane().add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 128, 316, 26);
		getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(108, 56, 316, 26);
		getContentPane().add(textField);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizar.setBounds(108, 199, 89, 27);
		getContentPane().add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnCancelar.setBounds(335, 198, 89, 27);
		getContentPane().add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaAtualAdm.class.getResource("/Imagens/livros.jpg")));
		label.setBounds(0, 0, 434, 247);
		getContentPane().add(label);

	}
}

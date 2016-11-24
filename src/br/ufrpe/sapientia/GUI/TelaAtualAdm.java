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
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPasswordField;

public class TelaAtualAdm extends JInternalFrame {
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JPasswordField passwordField_1;

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
		setBounds(100, 100, 731, 568);
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
		
		JLabel lblAtualizaoDeAdm = new JLabel("Atualiza\u00E7\u00E3o de ADM");
		lblAtualizaoDeAdm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtualizaoDeAdm.setBounds(235, 160, 226, 27);
		getContentPane().add(lblAtualizaoDeAdm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(196, 198, 295, 282);
		getContentPane().add(panel_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(TelaAtualAdm.class.getResource("/Imagens/delete.png")));
		button.setBounds(197, 208, 90, 63);
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(TelaAtualAdm.class.getResource("/Imagens/entrar.png")));
		button_1.setBounds(10, 208, 90, 63);
		panel_1.add(button_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(84, 85, 203, 22);
		panel_1.add(passwordField);
		
		JLabel label_6 = new JLabel("Senha.:");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_6.setBounds(10, 82, 257, 22);
		panel_1.add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(84, 33, 203, 24);
		panel_1.add(textField_3);
		
		JLabel label_7 = new JLabel("Login.:");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_7.setBounds(10, 31, 257, 22);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Confirmar Senha.:");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_8.setBounds(10, 126, 257, 22);
		panel_1.add(label_8);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(10, 159, 203, 22);
		panel_1.add(passwordField_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaAtualAdm.class.getResource("/Imagens/pensador1.png")));
		label.setBounds(-16, 0, 815, 528);
		getContentPane().add(label);

	}
}

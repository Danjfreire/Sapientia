package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import java.awt.Button;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarCliente extends JInternalFrame {
	private JTextField textField;

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
					TelaAtualizarCliente frame = new TelaAtualizarCliente();
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
	public TelaAtualizarCliente() {
		setTitle("Atualizar Funcion\u00E1rio");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 530, 136);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(78, 29, 327, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome.:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome.setBounds(10, 29, 78, 14);
		getContentPane().add(lblNome);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FormAtualCliente form = new FormAtualCliente();
				form.show();
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBuscar.setBounds(415, 28, 89, 23);
		getContentPane().add(btnBuscar);

	}
}

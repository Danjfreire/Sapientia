package br.ufrpe.sapientia.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarLivro extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarLivro frame = new TelaAtualizarLivro();
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
	public TelaAtualizarLivro() {
		setTitle("Atualizar Livro");
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
				
				FormAtuaLivro form = new FormAtuaLivro();
				
				form.show();
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBuscar.setBounds(415, 28, 89, 23);
		getContentPane().add(btnBuscar);

	}
}

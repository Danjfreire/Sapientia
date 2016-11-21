package br.ufrpe.sapientia.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class TelaCadastroFuncionario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisarFuncionario frame = new TelaPesquisarFuncionario();
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
	public TelaCadastroFuncionario() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Pesquisar Funcion\u00E1rio");
		setBounds(100, 100, 515, 375);

	}

}

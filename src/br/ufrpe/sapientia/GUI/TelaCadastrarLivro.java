package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;

public class TelaCadastrarLivro extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarLivro frame = new TelaCadastrarLivro();
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
	public TelaCadastrarLivro() {
		setTitle("Cadastrar Livros");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 564, 318);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastrarLivro.class.getResource("/Imagens/livro.png")));
		label.setBounds(10, 27, 135, 128);
		panel.add(label);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo.:");
		lblTtulo.setBounds(155, 21, 56, 14);
		panel.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor.:");
		lblAutor.setBounds(155, 51, 46, 14);
		panel.add(lblAutor);
		
		JLabel lblEdio = new JLabel("Edi\u00E7\u00E3o.:");
		lblEdio.setBounds(155, 81, 46, 14);
		panel.add(lblEdio);
		
		JLabel lblAno = new JLabel("Ano.:");
		lblAno.setBounds(155, 111, 46, 14);
		panel.add(lblAno);
		
		JLabel lblIsbn = new JLabel("ISBN.:");
		lblIsbn.setBounds(155, 141, 46, 14);
		panel.add(lblIsbn);
		
		JLabel lblVolume = new JLabel("Volume.:");
		lblVolume.setBounds(369, 16, 46, 14);
		panel.add(lblVolume);
		
		textField = new JTextField();
		textField.setBounds(235, 11, 115, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(235, 73, 115, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(235, 42, 115, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(235, 104, 115, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(235, 135, 115, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(439, 14, 115, 20);
		panel.add(textField_5);
		
		JLabel lblCategoria = new JLabel("Categoria.:");
		lblCategoria.setBounds(369, 46, 72, 14);
		panel.add(lblCategoria);
		
		JLabel lblResumo = new JLabel("Resumo.:");
		lblResumo.setBounds(369, 81, 46, 14);
		panel.add(lblResumo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(439, 45, 115, 20);
		panel.add(textField_6);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(56, 214, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(235, 214, 89, 23);
		panel.add(btnCancelar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(369, 106, 185, 196);
		panel.add(textArea);
		
		JList list = new JList();
		list.setBounds(440, 141, 72, 96);
		panel.add(list);

	}
}

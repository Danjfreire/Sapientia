package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ImageIcon;

public class FormAtuaLivro extends JFrame {

	private JPanel contentPane;
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
				 try 
				    {
				      UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
				    } 
				    catch (Exception e) 
				    {
				      e.printStackTrace();
				    }
				try {
					FormAtuaLivro frame = new FormAtuaLivro();
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
	public FormAtuaLivro() {
		setTitle("Atualizando Livro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 564, 318);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FormAtuaLivro.class.getResource("/Imagens/livro.png")));
		label.setBounds(10, 27, 135, 128);
		panel.add(label);
		
		JLabel label_1 = new JLabel("T\u00EDtulo.:");
		label_1.setBounds(155, 21, 56, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Autor.:");
		label_2.setBounds(155, 51, 46, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Edi\u00E7\u00E3o.:");
		label_3.setBounds(155, 81, 46, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Ano.:");
		label_4.setBounds(155, 111, 46, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("ISBN.:");
		label_5.setBounds(155, 141, 46, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Volume.:");
		label_6.setBounds(369, 16, 46, 14);
		panel.add(label_6);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(235, 11, 115, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(235, 73, 115, 20);
		panel.add(textField_1);
		
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
		
		JLabel label_7 = new JLabel("Categoria.:");
		label_7.setBounds(369, 46, 72, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Resumo.:");
		label_8.setBounds(369, 81, 46, 14);
		panel.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(439, 45, 115, 20);
		panel.add(textField_6);
		
		JButton button = new JButton("Salvar");
		button.setBounds(56, 214, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(235, 214, 89, 23);
		panel.add(button_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(369, 106, 185, 196);
		panel.add(textArea);
		
		JList list = new JList();
		list.setBounds(440, 141, 72, 96);
		panel.add(list);
	}

}

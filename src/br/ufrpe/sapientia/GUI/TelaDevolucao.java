package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaDevolucao extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDevolucao frame = new TelaDevolucao();
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
	public TelaDevolucao() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Devolver Livros");
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 744, 57);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u00CDTULO", "ISBN", "CLIENTE", "FUNCION\u00C1RIO"}));
		comboBox.setBounds(10, 21, 78, 20);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(98, 21, 508, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(645, 20, 89, 23);
		panel.add(btnPesquisar);
		
		JButton btnPesquisarTodos = new JButton("Pesquisar Todos");
		btnPesquisarTodos.setBounds(294, 79, 121, 23);
		getContentPane().add(btnPesquisarTodos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 744, 249);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Endereço");
		modelo.addColumn("Contato");
		modelo.addColumn("Email");
		modelo.addColumn("Sexo");
		modelo.addColumn("Login");
		scrollPane.setViewportView(table);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setBounds(257, 373, 89, 23);
		getContentPane().add(btnDevolver);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(394, 373, 89, 23);
		getContentPane().add(btnSair);
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);

	}
}

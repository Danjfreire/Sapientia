package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

public class TelaPendenciaLivros extends JInternalFrame {
	private JTextField textField;
	private JTable table;

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
					TelaPendenciaLivros frame = new TelaPendenciaLivros();
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
	public TelaPendenciaLivros() {
		setTitle("Livros Pendentes");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 577, 368);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 535, 70);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u00EDtulo", "ISBN"}));
		comboBox.setBounds(29, 22, 72, 20);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(111, 22, 316, 20);
		panel.add(textField);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(436, 21, 89, 23);
		panel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 535, 194);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"T\u00EDtulo", "Cliente", "Data", "Funcion\u00E1rio"
			}
		));
		scrollPane.setViewportView(table);

	}
}

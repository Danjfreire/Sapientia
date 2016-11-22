package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

public class TelaHistóricoLivros extends JInternalFrame {
	private JTextField textField;
	private JTable table;

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
					TelaHistóricoLivros frame = new TelaHistóricoLivros();
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
	public TelaHistóricoLivros() {
		setTitle("Hist\u00F3rico de Empr\u00E9stimo de Livro");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 561, 376);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 22, 531, 61);
		getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 28, 334, 20);
		panel.add(textField);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(429, 27, 92, 23);
		panel.add(btnBuscar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ISBN", "T\u00EDtulo"}));
		comboBox.setBounds(10, 28, 65, 20);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 525, 191);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Data", "Cliente", "Devolu\u00E7\u00E3o", "Funcion\u00E1rio", "Situa\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);

	}

}

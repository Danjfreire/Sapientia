package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class TelaHistoricoCliente extends JInternalFrame {
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
					TelaHistoricoCliente frame = new TelaHistoricoCliente();
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
	public TelaHistoricoCliente() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Hist\u00F3rico");
		setBounds(100, 100, 642, 574);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 117, 554, 312);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "T\u00EDtulo", "Autor", "Funcion\u00E1rio", "Empr\u00E9stimo", "Devolu\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Empr\u00E9stimos realizados!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(246, 67, 205, 22);
		getContentPane().add(lblNewLabel);

	}

}

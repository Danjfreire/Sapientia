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
import java.awt.Font;
import java.awt.Color;

public class TelaPendenciaCliente extends JInternalFrame {
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
					TelaPendenciaCliente frame = new TelaPendenciaCliente();
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
	public TelaPendenciaCliente() {
		setTitle("Pend\u00EAncias");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 596, 499);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 118, 524, 275);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "T\u00EDtulo", "Autor", "In\u00EDcio", "Devolu\u00E7\u00E3o", "Atraso"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Livros em atraso!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(285, 70, 201, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContatarCliente = new JLabel("Devolva Imediatamente!");
		lblContatarCliente.setForeground(Color.RED);
		lblContatarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContatarCliente.setBounds(285, 445, 201, 14);
		getContentPane().add(lblContatarCliente);

	}
}

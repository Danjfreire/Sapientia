package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Color;
import javax.swing.JButton;

public class TelaEmpréstimo extends JInternalFrame {
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
					TelaEmpréstimo frame = new TelaEmpréstimo();
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
	public TelaEmpréstimo() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\t\t\t\t\t\t\tSapientia - Empr\u00E9stimo de Livros");
		setBounds(100, 100, 595, 523);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 489, 74);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome.:");
		lblNome.setBounds(10, 23, 48, 14);
		panel.add(lblNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(48, 20, 220, 20);
		panel.add(textField);
		
		JLabel lblCpf = new JLabel("Cpf.:");
		lblCpf.setBounds(278, 23, 32, 14);
		panel.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(320, 20, 148, 20);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados do Livro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 96, 489, 106);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo.:");
		lblTtulo.setBounds(194, 27, 46, 14);
		panel_1.add(lblTtulo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(244, 24, 235, 20);
		panel_1.add(textField_2);
		
		JLabel lblIsbn = new JLabel("ISBN.:");
		lblIsbn.setBounds(10, 27, 46, 14);
		panel_1.add(lblIsbn);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(53, 24, 131, 20);
		panel_1.add(textField_3);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(390, 72, 89, 23);
		panel_1.add(btnNovo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Empr\u00E9stimo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 223, 489, 106);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio.:");
		lblFuncionrio.setBounds(10, 24, 70, 14);
		panel_2.add(lblFuncionrio);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(82, 21, 235, 20);
		panel_2.add(textField_4);
		
		JLabel lblDadtaIncio = new JLabel("Data In\u00EDcio.:");
		lblDadtaIncio.setBounds(10, 61, 70, 14);
		panel_2.add(lblDadtaIncio);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(82, 58, 121, 20);
		panel_2.add(textField_5);
		
		JLabel lblDataDevoluo = new JLabel("Data Devolu\u00E7\u00E3o.:");
		lblDataDevoluo.setBounds(232, 61, 84, 14);
		panel_2.add(lblDataDevoluo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(326, 58, 121, 20);
		panel_2.add(textField_6);

	}
}

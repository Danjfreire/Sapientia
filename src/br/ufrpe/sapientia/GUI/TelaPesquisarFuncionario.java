package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaPesquisarFuncionario extends JInternalFrame {
	private JTextField tfPesquisa;
	private JTable table_1;

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
	public TelaPesquisarFuncionario() {
		setTitle("Pesquisar Funcion\u00E1rios");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 802, 618);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(39, 11, 706, 109);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(105, 34, 403, 37);
		panel_1.add(tfPesquisa);
		tfPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(518, 33, 136, 39);
		panel_1.add(btnPesquisar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome", "Cpf"}));
		comboBox.setBounds(10, 34, 88, 37);
		panel_1.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 176, 706, 204);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Cpf"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				FormPesqFunc form = new FormPesqFunc();
				form.show();
			}
		});
		btnOk.setBounds(494, 430, 89, 61);
		getContentPane().add(btnOk);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setBounds(656, 430, 89, 61);
		getContentPane().add(btnSair);
		
		JLabel lblDigiteONome = new JLabel("Escolha o Funcion\u00E1rio e pressione OK!");
		lblDigiteONome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDigiteONome.setBounds(69, 431, 415, 54);
		getContentPane().add(lblDigiteONome);

	}
}
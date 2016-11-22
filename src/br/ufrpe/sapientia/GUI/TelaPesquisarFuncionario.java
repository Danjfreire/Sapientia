package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
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

public class TelaPesquisarFuncionario extends JInternalFrame {
	private JTextField tfPesquisa;
	private JTable table_1;

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
		setTitle("Pesquisar Funcioários");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 567, 400);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 531, 61);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(85, 28, 334, 20);
		panel_1.add(tfPesquisa);
		tfPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(429, 27, 92, 23);
		panel_1.add(btnPesquisar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome", "Cpf"}));
		comboBox.setBounds(10, 28, 65, 20);
		panel_1.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 119, 521, 103);
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
		btnOk.setBounds(81, 305, 89, 23);
		getContentPane().add(btnOk);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(394, 305, 89, 23);
		getContentPane().add(btnSair);

	}
}
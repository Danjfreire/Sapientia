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

public class TelaPesquisarLivro extends JInternalFrame {
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
					TelaPesquisarLivro frame = new TelaPesquisarLivro();
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
	public TelaPesquisarLivro() {
		setTitle("Pesquisar Livros");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 750, 527);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(37, 34, 687, 130);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(182, 28, 393, 49);
		panel_1.add(tfPesquisa);
		tfPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(585, 27, 92, 50);
		panel_1.add(btnPesquisar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u00EDtulo", "Autor", "ISBN"}));
		comboBox.setBounds(10, 28, 92, 49);
		panel_1.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 243, 687, 151);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ISBN", "T\u00EDtulo", "Autor"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JButton btnOk = new JButton("Excluir");
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				FormPesqLivro form = new FormPesqLivro();
				form.show();
			}
		});
		btnOk.setBounds(536, 447, 89, 40);
		getContentPane().add(btnOk);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSair.setBounds(635, 447, 89, 40);
		getContentPane().add(btnSair);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(437, 447, 89, 40);
		getContentPane().add(btnAtualizar);
		
		JButton btnMostrarTodos = new JButton("Mostrar Todos");
		btnMostrarTodos.setBounds(601, 192, 123, 40);
		getContentPane().add(btnMostrarTodos);

	}
}
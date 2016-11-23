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

import br.ufrpe.sapientia.fachada.Fachada;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.List;
import br.ufrpe.sapientia.negocio.beans.*;

public class TelaPesquisarCliente extends JInternalFrame {
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
					TelaPesquisarCliente frame = new TelaPesquisarCliente();
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
	public TelaPesquisarCliente() {
		setTitle("Pesquisar Clientes");
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
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome", "Cpf"}));
		comboBox.setBounds(10, 34, 88, 37);
		panel_1.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 192, 706, 204);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		/*table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Cpf"
			}
		));*/
		DefaultTableModel modelo = new DefaultTableModel();
		table_1.setModel(modelo);
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		scrollPane.setViewportView(table_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(518, 33, 136, 39);
		panel_1.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
				
					
					if(comboBox.getSelectedItem().equals("Nome")){
						List<Usuario> usuarios = Fachada.getInstance().buscarUsuarioNome(tfPesquisa.getText(), "C");
						for(Usuario u : usuarios){
							String nome = u.getNome();
							String cpf = u.getCpf();
							modelo.addRow(new Object[]{nome,cpf});
						}
					}
				}catch(Exception exception){
					
				}
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
					
					
				}
		});
		btnAtualizar.setBounds(333, 453, 89, 61);
		getContentPane().add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(495, 453, 89, 61);
		getContentPane().add(btnExcluir);
		
		JButton btnExibirTodos = new JButton("Exibir todos");
		btnExibirTodos.setBounds(607, 131, 138, 50);
		getContentPane().add(btnExibirTodos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(656, 453, 89, 61);
		getContentPane().add(btnSair);

	}
}
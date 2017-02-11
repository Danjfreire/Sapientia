package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import jdk.nashorn.internal.scripts.JO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaHistóricoLivros extends JInternalFrame {
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
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel.setBounds(10, 22, 744, 79);
		getContentPane().add(panel);
		
		try {
			textField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textField.setColumns(10);
		textField.setBounds(107, 28, 493, 22);
		panel.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				panel.remove(textField);
				if(comboBox.getSelectedItem().equals("Funcionario") || comboBox.getSelectedItem().equals("Cliente")){
					try {
						textField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else
					try {
						textField = new JFormattedTextField(new MaskFormatter("###-#-##-######-#"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				textField.setBounds(107, 28, 493, 22);
				panel.add(textField);
				textField.setColumns(10);
				comboBox.transferFocus();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Funcionario", "Cliente", "ISBN"}));
		comboBox.setBounds(10, 28, 87, 22);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 744, 201);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("id");
		modelo.addColumn("título");
		modelo.addColumn("Cliente");
		modelo.addColumn("Funcionário");
		modelo.addColumn("Livro");
		modelo.addColumn("Empréstimo");
		modelo.addColumn("Devolução");
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBuscar.setBounds(622, 25, 100, 29);
		panel.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					table = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					modelo.addColumn("id");
					modelo.addColumn("título");
					modelo.addColumn("Cliente");
					modelo.addColumn("Funcionário");
					modelo.addColumn("Livro");
					modelo.addColumn("Empréstimo");
					modelo.addColumn("Devolução");
					scrollPane.setViewportView(table);
					
					List<Historico> historicos;
					if(comboBox.getSelectedItem().equals("ISBN") && textField.getText().equals("   - -  -      - ")){
						JOptionPane.showMessageDialog(null, "Campo ISBN vazio!");
						textField.grabFocus();
					}
					else if((comboBox.getSelectedItem().equals("Funcionario") || comboBox.getSelectedItem().equals("Cliente")) && textField.getText().equals("   .   .   -  ")){
						JOptionPane.showMessageDialog(null, "Campo cpf vazio");
						textField.grabFocus();
					}
					else{
						if(comboBox.getSelectedItem().equals("ISBN")){
							historicos = Fachada.getInstance().pesquisarHistoricoISBN(textField.getText());
						}else if(comboBox.getSelectedItem().equals("Funcionario")){
							historicos = Fachada.getInstance().pesquisarHistoricoFuncionario(textField.getText());
						}else{
							historicos = Fachada.getInstance().pesquisarHistoricoCliente(textField.getText());
						}
						if(historicos.isEmpty()){
							JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!");
						}
						for(Historico h : historicos){
							int id = h.getId();
							String titulo = h.getTituloLivro();
							String cliente = Fachada.getInstance().buscarUsuarioCPF(h.getCpfCliente(), "C").getNome();
							String funcionario = Fachada.getInstance().buscarUsuarioCPF(h.getCpfFuncionario(), "F").getNome();
							String isbn = h.getIsbnLivro();
							Calendar inicio = h.getDataEmprestimo();
							String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
							Calendar fim = h.getDataDevolucao();
							String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
							
							modelo.addRow(new Object[]{id, titulo, cliente, funcionario, isbn, dataInicio, dataFim});
						}
					}
				}catch(Exception ex){
					
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(328, 365, 100, 29);
		getContentPane().add(btnSair);
		
		JButton btnMostrarTodos = new JButton("Mostrar Todos");
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table = new JTable();
				DefaultTableModel modelo = new DefaultTableModel();
				table.setModel(modelo);
				modelo.addColumn("id");
				modelo.addColumn("título");
				modelo.addColumn("Cliente");
				modelo.addColumn("Funcionário");
				modelo.addColumn("Livro");
				modelo.addColumn("Empréstimo");
				modelo.addColumn("Devolução");
				scrollPane.setViewportView(table);
				
				try {
					List<Historico> historicos = Fachada.getInstance().pesquisarHistoricoTodos();
					for(Historico h : historicos){
						int id = h.getId();
						String titulo = h.getTituloLivro();
						String cliente = Fachada.getInstance().buscarUsuarioCPF(h.getCpfCliente(), "C").getNome();
						String funcionario = Fachada.getInstance().buscarUsuarioCPF(h.getCpfFuncionario(), "F").getNome();
						String isbn = h.getIsbnLivro();
						Calendar inicio = h.getDataEmprestimo();
						String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
						Calendar fim = h.getDataDevolucao();
						String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
						
						modelo.addRow(new Object[]{id, titulo, cliente, funcionario, isbn, dataInicio, dataFim});
					}
					if(historicos.isEmpty())
						JOptionPane.showMessageDialog(null, "Registro vazio");
				
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnMostrarTodos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMostrarTodos.setBounds(315, 113, 139, 29);
		getContentPane().add(btnMostrarTodos);
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
		
	}
}

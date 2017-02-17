package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import br.ufrpe.sapientia.negocio.beans.*;
import br.ufrpe.sapientia.fachada.Fachada;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel.setBounds(10, 11, 744, 70);
		getContentPane().add(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				panel.remove(textField);
				if(comboBox.getSelectedItem().equals("T\u00EDtulo")){
					textField = new JTextField();
					textField.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent arg0) {
							if(textField.getText().length() == 50){
								getToolkit().beep();
								arg0.consume();
							}
						}
					});
				}
				else{
					try {
						textField = new JFormattedTextField(new MaskFormatter("###-#-##-######-#"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				textField.setColumns(10);
				textField.setBounds(92, 22, 490, 20);
				panel.add(textField);
				comboBox.transferFocus();
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u00EDtulo", "ISBN"}));
		comboBox.setBounds(10, 22, 72, 20);
		panel.add(comboBox);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(textField.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(92, 22, 490, 20);
		panel.add(textField);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 744, 215);
		getContentPane().add(scrollPane);

		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("C\u00F3digo");
		modelo.addColumn("T\u00EDtulo");
		modelo.addColumn("Cliente");
		modelo.addColumn("funcionario");
		modelo.addColumn("Emprestimo");
		modelo.addColumn("Devolucao");
		modelo.addColumn("status");
		scrollPane.setViewportView(table);


		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBuscar.setBounds(628, 16, 100, 29);
		panel.add(btnBuscar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(337, 373, 100, 29);
		getContentPane().add(btnSair);
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					table = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					modelo.addColumn("C\u00F3digo");
					modelo.addColumn("T\u00EDtulo");
					modelo.addColumn("Cliente");
					modelo.addColumn("funcionario");
					modelo.addColumn("Emprestimo");
					modelo.addColumn("Devolucao");
					modelo.addColumn("status");
					scrollPane.setViewportView(table);
					
					List<Emprestimo> emprestimos;
					if(comboBox.getSelectedItem().equals("T\u00EDtulo") && textField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo título em branco!");
						textField.grabFocus();
					}
					else if(comboBox.getSelectedItem().equals("ISBN") && textField.getText().equals("   - -  -      - ")){
						JOptionPane.showMessageDialog(null, "Campo isbn em branco!");
						textField.grabFocus();
					}
					else{
						if(comboBox.getSelectedItem().equals("T\u00EDtulo"))
							emprestimos = Fachada.getInstance().verificarEmprestimoLivro(textField.getText());
						else 
							emprestimos = Fachada.getInstance().verificarEmprestimoISBN(textField.getText());
						if(emprestimos.isEmpty())
							JOptionPane.showMessageDialog(null, "Nenuhm registro encontrado!");
						for(Emprestimo emp : emprestimos){
							
							int codigo = emp.getIdEmprestimo();
							String titulo = Fachada.getInstance().buscaLivroISBN(emp.getIsbnLivro()).getTitulo();
							String  cliente = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfCliente(), "C").getNome();
							String funcionario = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfFuncionario(), "F").getNome();
							Calendar inicio = emp.getDataEmprestimo();
							String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
							Calendar fim = emp.getDataDevolucao();
							String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
							String status = emp.getStatus();
							
							modelo.addRow(new Object[]{codigo, titulo, cliente, funcionario, dataInicio, dataFim, status});
						}
					}
				}catch(Exception ex){

				}
			}
		});
		
		JButton btnTodos = new JButton("Mostrar Todos");
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table = new JTable();
				DefaultTableModel modelo = new DefaultTableModel();
				table.setModel(modelo);
				modelo.addColumn("C\u00F3digo");
				modelo.addColumn("T\u00EDtulo");
				modelo.addColumn("Cliente");
				modelo.addColumn("funcionario");
				modelo.addColumn("Emprestimo");
				modelo.addColumn("Devolucao");
				modelo.addColumn("status");
				scrollPane.setViewportView(table);
				
				List<Emprestimo> emprestimos;
				
				try {
					emprestimos = Fachada.getInstance().verificarTodosEmprestimos();				
					if(emprestimos.isEmpty())
						JOptionPane.showMessageDialog(null, "Nenuhm registro encontrado!");
					for(Emprestimo emp : emprestimos){
						
						int codigo = emp.getIdEmprestimo();
						String titulo = Fachada.getInstance().buscaLivroISBN(emp.getIsbnLivro()).getTitulo();
						String  cliente = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfCliente(), "C").getNome();
						String funcionario = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfFuncionario(), "F").getNome();
						Calendar inicio = emp.getDataEmprestimo();
						String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
						Calendar fim = emp.getDataDevolucao();
						String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
						String status = emp.getStatus();
						
						modelo.addRow(new Object[]{codigo, titulo, cliente, funcionario, dataInicio, dataFim, status});
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnTodos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTodos.setBounds(315, 107, 139, 29);
		getContentPane().add(btnTodos);
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
		
	}
}

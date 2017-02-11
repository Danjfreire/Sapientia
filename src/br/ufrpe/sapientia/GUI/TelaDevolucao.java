package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaDevolucao extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private List<Emprestimo>emprestimos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDevolucao frame = new TelaDevolucao();
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
	public TelaDevolucao() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Devolver Livros");
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel.setBounds(10, 11, 744, 76);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				panel.remove(textField);
				if(comboBox.getSelectedItem().equals("ISBN")){
					try {
						textField = new JFormattedTextField(new MaskFormatter("###-#-##-######-#"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				else if(comboBox.getSelectedItem().equals("TÍTULO")){
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
						textField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				textField.setBounds(98, 21, 480, 20);
				panel.add(textField);
				textField.setColumns(10);
				comboBox.transferFocus();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CLIENTE", "FUNCION\u00C1RIO", "TÍTULO", "ISBN"}));
		comboBox.setBounds(10, 21, 78, 20);
		panel.add(comboBox);
		
		try {
			textField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textField.setBounds(98, 21, 480, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 744, 224);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Contato");
		modelo.addColumn("Emprestimo");
		modelo.addColumn("Devolucao");
		modelo.addColumn("Situação");
		
		scrollPane.setViewportView(table);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPesquisar.setBounds(616, 15, 118, 29);
		panel.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						table = new JTable();
						DefaultTableModel modelo = new DefaultTableModel();
						table.setModel(modelo);
						modelo.addColumn("ID");
						modelo.addColumn("Nome");
						modelo.addColumn("CPF");
						modelo.addColumn("Contato");
						modelo.addColumn("Emprestimo");
						modelo.addColumn("Devolucao");
						modelo.addColumn("Situação");
						
						scrollPane.setViewportView(table);
				
						if(comboBox.getSelectedItem().equals("ISBN") && textField.getText().equals("   - -  -      - ")){
							JOptionPane.showMessageDialog(null, "ISBN vazio!");
							textField.grabFocus();
						}
						else if(!(comboBox.getSelectedItem().equals("ISBN")) && !(comboBox.getSelectedItem().equals("TÍTULO")) && textField.getText().equals("   .   .   -  ")){
							JOptionPane.showMessageDialog(null, "Cpf vazio!");
							textField.grabFocus();
						}
						else if(comboBox.getSelectedItem().equals("TÍTULO") && textField.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Titulo vazio!");
							textField.grabFocus();
						}
						else{
							if(comboBox.getSelectedItem().equals("TÍTULO")){
								emprestimos = Fachada.getInstance().verificarEmprestimoLivro(textField.getText());
							}else if(comboBox.getSelectedItem().equals("CLIENTE")){
								emprestimos = Fachada.getInstance().verificarPendenciasCliente(textField.getText());
							}else if(comboBox.getSelectedItem().equals("ISBN")){
								emprestimos = Fachada.getInstance().verificarEmprestimoISBN(textField.getText());
							}else if(comboBox.getSelectedItem().equals("FUNCION\u00C1RIO")){
								emprestimos = Fachada.getInstance().verificarEmprestimoFunc(textField.getText());
							}
							if(emprestimos.isEmpty())
								JOptionPane.showMessageDialog(null, "Emprestimo não encontrado!");
							for(Emprestimo emp : emprestimos){
								Usuario cliente = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfCliente(), "C");
								Calendar inicio = emp.getDataEmprestimo();
								String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
								Calendar fim = emp.getDataDevolucao();
								String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
								Livro l = Fachada.getInstance().buscaLivroISBN(emp.getIsbnLivro());
								modelo.addRow(new Object[]{emp.getIdEmprestimo(), cliente.getNome(),emp.getCpfCliente(),cliente.getContato(),dataInicio,dataFim,emp.getStatus()});
							}
							
						}
					}catch(Exception ex){
						
					}
				}});
		
		JButton btnPesquisarTodos = new JButton("Pesquisar Todos");
		btnPesquisarTodos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPesquisarTodos.setBounds(304, 98, 155, 29);
		getContentPane().add(btnPesquisarTodos);
		btnPesquisarTodos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					table = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					modelo.addColumn("ID");
					modelo.addColumn("Nome");
					modelo.addColumn("CPF");
					modelo.addColumn("Contato");
					modelo.addColumn("Emprestimo");
					modelo.addColumn("Devolucao");
					modelo.addColumn("Situação");
					
					scrollPane.setViewportView(table);
					
					emprestimos = Fachada.getInstance().verificarTodosEmprestimos();
					if(emprestimos.isEmpty())
						JOptionPane.showMessageDialog(null, "Registro vazio!");
					for(Emprestimo emp : emprestimos){
						Usuario cliente = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfCliente(), "C");
						Calendar inicio = emp.getDataEmprestimo();
						String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
						Calendar fim = emp.getDataDevolucao();
						String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
						Livro l = Fachada.getInstance().buscaLivroISBN(emp.getIsbnLivro());
						modelo.addRow(new Object[]{emp.getIdEmprestimo(), cliente.getNome(),emp.getCpfCliente(),cliente.getContato(),dataInicio,dataFim,emp.getStatus()});
					}
				}catch(Exception ex){
					
				}
			}
		});
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDevolver.setBounds(257, 373, 100, 29);
		getContentPane().add(btnDevolver);
		btnDevolver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(JOptionPane.showConfirmDialog(null, "Confirmar a devolução do livro?" ,"Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					try{
						Emprestimo ep = emprestimos.get(table.getSelectedRow());
						Fachada.getInstance().removerEmprestimo(ep.getIdEmprestimo());
						emprestimos.remove(table.getSelectedRow());
						table = new JTable();
						DefaultTableModel modelo = new DefaultTableModel();
						table.setModel(modelo);
						modelo.addColumn("ID");
						modelo.addColumn("Nome");
						modelo.addColumn("CPF");
						modelo.addColumn("Contato");
						modelo.addColumn("Emprestimo");
						modelo.addColumn("Devolucao");
						modelo.addColumn("Situação");
						
						scrollPane.setViewportView(table);
						
						for(Emprestimo emp : emprestimos){
							Usuario cliente = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfCliente(), "C");
							Calendar inicio = emp.getDataEmprestimo();
							String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
							Calendar fim = emp.getDataDevolucao();
							String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
							Livro l = Fachada.getInstance().buscaLivroISBN(emp.getIsbnLivro());
							modelo.addRow(new Object[]{emp.getIdEmprestimo(), cliente.getNome(),emp.getCpfCliente(),cliente.getContato(),dataInicio,dataFim,emp.getStatus()});
						}
					}catch(ArrayIndexOutOfBoundsException e1){
						JOptionPane.showMessageDialog(null, "Nenhum emprestimo selecionado!");
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else
					table.getSelectionModel().clearSelection();
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setBounds(402, 373, 100, 29);
		getContentPane().add(btnSair);
		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			dispose();
				
			}
		});
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);

	}
}

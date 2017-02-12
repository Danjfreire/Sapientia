package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class TelaEmpréstimo extends JInternalFrame {
	private JTextField tfCpf;
	private JTextField tfTitulo;
	private JTextField tfIsbn;
	private JTextField tfFuncionario;
	private JTextField tfDataInicio;
	private JTextField tfDataFinal;
	private Usuario funcionario;
	private JTable table;
	private List<Livro> livros;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//				        if ("Nimbus".equals(info.getName())) {
//				            UIManager.setLookAndFeel(info.getClassName());
//				            break;
//				        }
//				    }
//				} catch (Exception e) {
//				    // If Nimbus is not available, you can set the GUI to another look and feel.
//				}
//				try {
//					TelaEmpréstimo frame = new TelaEmpréstimo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	
	/*Opcoes
	 * 1 - Essa tela deveria ter campos para realizar uma pesquisa de livro por isbn ou nome e abrir outra tela para que o cliente entre com o cpf 
	 * 	   e complete o emprestimo.
	 * 
	 * 2 - Criar um botão empréstimo na tela de busca de livro que redireciona para esta página onde seria inserido o cpf do cliente e as datas de empréstimo,
	 * 	   o botão que redireciona para essa tela não seria mais na tela principal e sim na tela de pesquisa de livro, enquanto o botão da tela principal iria redirecionar 
	 * 	   para a tela de livros.
	 * 
	 * 3 - Manter do modo que está, apenas removendo os campos de nome e cpf de cliente.Seria uma tela que mudaria quando um livro fosse buscado.
	 *     Ex: Busca o livro e após selecionado na lista os campos de cpf do cliente se tornam habilitados, e assim que o campo de cpf estiver preenchido 
	 *     	   o botão de efetuar emprestimo se torna habilitado
	 */
	
	
	public TelaEmpréstimo(Usuario func) {
		this.funcionario = func;
		Calendar inicio = Calendar.getInstance();
		
		setIconifiable(true);
		setClosable(true);
		setTitle("\t\t\t\t\t\t\tSapientia - Empr\u00E9stimo de Livros");
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Empr\u00E9stimo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel_2.setBounds(263, 12, 491, 297);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel.setBounds(10, 211, 471, 75);
		panel_2.add(panel);
		panel.setLayout(null);
		
		JLabel lblDadtaIncio = new JLabel("In\u00EDcio.:");
		lblDadtaIncio.setForeground(new Color(95, 158, 160));
		lblDadtaIncio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDadtaIncio.setBounds(10, 33, 59, 20);
		panel.add(lblDadtaIncio);
		
		tfDataInicio = new JTextField();
		tfDataInicio.setBounds(71, 35, 140, 20);
		panel.add(tfDataInicio);
		tfDataInicio.setColumns(10);
		tfDataInicio.setText(inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR));
		tfDataInicio.setEditable(false);
		
		JLabel lblDataDevoluo = new JLabel("Devolu\u00E7\u00E3o.:");
		lblDataDevoluo.setForeground(new Color(95, 158, 160));
		lblDataDevoluo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDataDevoluo.setBounds(224, 33, 94, 20);
		panel.add(lblDataDevoluo);
		
		try {
			tfDataFinal = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		tfDataFinal.setBounds(321, 35, 140, 20);
		panel.add(tfDataFinal);
		tfDataFinal.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Cpf", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel_1.setBounds(10, 125, 471, 75);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		try {
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfCpf.setBounds(86, 29, 121, 20);
		panel_1.add(tfCpf);
		tfCpf.setColumns(10);
		
		
		JLabel lblCpf = new JLabel("Cliente:.");
		lblCpf.setForeground(new Color(95, 158, 160));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCpf.setBounds(10, 27, 66, 20);
		panel_1.add(lblCpf);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio.:");
		lblFuncionrio.setForeground(new Color(95, 158, 160));
		lblFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFuncionrio.setBounds(217, 27, 103, 20);
		panel_1.add(lblFuncionrio);
		
		tfFuncionario = new JTextField();
		tfFuncionario.setBounds(319, 29, 142, 20);
		panel_1.add(tfFuncionario);
		tfFuncionario.setColumns(10);
		tfFuncionario.setText(funcionario.getCpf());
		tfFuncionario.setEditable(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Livro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel_3.setBounds(10, 39, 471, 75);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblIsbn = new JLabel("ISBN.:");
		lblIsbn.setForeground(new Color(95, 158, 160));
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIsbn.setBounds(10, 26, 63, 20);
		panel_3.add(lblIsbn);
		
		tfIsbn = new JTextField();
		tfIsbn.setBounds(79, 28, 131, 20);
		panel_3.add(tfIsbn);
		tfIsbn.setColumns(10);
		tfIsbn.setEditable(false);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo.:");
		lblTtulo.setForeground(new Color(95, 158, 160));
		lblTtulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTtulo.setBounds(224, 26, 58, 20);
		panel_3.add(lblTtulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(282, 28, 179, 20);
		panel_3.add(tfTitulo);		
		tfTitulo.setColumns(10);
		tfTitulo.setEditable(false);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNovo.setBounds(263, 358, 100, 29);
		getContentPane().add(btnNovo);

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(375, 358, 100, 29);
		getContentPane().add(btnSair);
		
		btnNovo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
//					SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
//					Date fim = df.parse(tfDataFinal.getText());
//					Calendar termino = Calendar.getInstance();
//					termino.setTime(fim);
					if(tfDataFinal.getText().equals("  /  /    ")){
						JOptionPane.showMessageDialog(null, "Campo devolução vazio!");
						tfDataFinal.grabFocus();
					}
					else if(tfCpf.getText().equals("   .   .   -  ")){
						JOptionPane.showMessageDialog(null, "Campo cliente vazio!");
						tfCpf.grabFocus();
					}
					else if(tfTitulo.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Selecione um livro!");
					}
					else{
						Fachada.getInstance().efetuarEmprestimo(tfDataInicio.getText(), tfDataFinal.getText(), "ABERTO",func.getCpf(),tfCpf.getText(),tfIsbn.getText());
						if(JOptionPane.showConfirmDialog(null, "Emprestimo efetuado com sucesso.\nDeseja realizar mais empréstimos?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
							DefaultTableModel modelo = new DefaultTableModel();
							modelo.addColumn("Título");
							modelo.addColumn("ISBN");
							table = new JTable();
							table.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent arg0) {
									tfIsbn.setEditable(true);
									tfTitulo.setEditable(true);
									Livro l = livros.get(table.getSelectedRow());
									tfIsbn.setText(l.getIsbn());
									tfTitulo.setText(l.getTitulo());
									tfIsbn.setEditable(false);
									tfTitulo.setEditable(false);
								}
							});
							table.setModel(modelo);
							table.getColumnModel().getColumn(0).setPreferredWidth(130);
							scrollPane.setViewportView(table);
							
							livros = Fachada.getInstance().pesquisarLivrosEstoque();
							if(livros.isEmpty())
								JOptionPane.showMessageDialog(null, "Estoque de livros vazio!");
							else{
								for(Livro l : livros){
									String titulo = l.getTitulo();
									String isbn = l.getIsbn();
									modelo.addRow(new Object[]{titulo, isbn});
								}
							}
							tfCpf.setText("");
							tfDataFinal.setText("");
							tfTitulo.setEditable(true);
							tfIsbn.setEditable(true);
							tfDataInicio.setEditable(true);
							tfTitulo.setText("");
							tfIsbn.setText("");
							tfDataInicio.setText(inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR));
							tfTitulo.setEditable(false);
							tfIsbn.setEditable(false);
							tfDataInicio.setEditable(false);
						}else
							dispose();
					}
				}
				catch(SQLException exception){
					ErrosGUI eg = new ErrosGUI();
					eg.mensagemEmprestimo(exception, tfCpf, tfIsbn);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "ISBN não cadastrado");
					tfIsbn.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}finally{
					tfTitulo.setEditable(false);
				}
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(null, "Selecionar Livro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel_4.setBounds(10, 12, 243, 297);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 223, 251);
		panel_4.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Título");
		modelo.addColumn("ISBN");
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				tfIsbn.setEditable(true);
				tfTitulo.setEditable(true);
				Livro l = livros.get(table.getSelectedRow());
				tfIsbn.setText(l.getIsbn());
				tfTitulo.setText(l.getTitulo());
				tfIsbn.setEditable(false);
				tfTitulo.setEditable(false);
			}
		});
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		scrollPane.setViewportView(table);
		
		try {
			livros = Fachada.getInstance().pesquisarLivrosEstoque();
			if(livros.isEmpty())
				JOptionPane.showMessageDialog(null, "Estoque de livros vazio!");
			else{
				for(Livro l : livros){
					String titulo = l.getTitulo();
					String isbn = l.getIsbn();
					modelo.addRow(new Object[]{titulo, isbn});
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
	}
}

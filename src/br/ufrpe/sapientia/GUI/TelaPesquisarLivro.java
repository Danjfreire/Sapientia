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
import javax.swing.text.MaskFormatter;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.Usuario;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import java.util.List;
import br.ufrpe.sapientia.negocio.beans.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaPesquisarLivro extends JInternalFrame {
	private JTextField tfPesquisa;
	private JTable table_1;
    private List<Livro>livros;
	
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
		setClosable(true);
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel_1.setBounds(10, 11, 744, 73);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tfPesquisa = new JTextField();
		tfPesquisa.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfPesquisa.getText().length() == 50){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		tfPesquisa.setBounds(136, 28, 393, 26);
		panel_1.add(tfPesquisa);
		tfPesquisa.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					panel_1.remove(tfPesquisa);
					if(comboBox.getSelectedItem().equals("Autor") || comboBox.getSelectedItem().equals("Título")){
						tfPesquisa = new JTextField();
						tfPesquisa.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent arg0) {
								if(tfPesquisa.getText().length() == 50){
									getToolkit().beep();
									arg0.consume();
								}
							}
						});
					}
					else
						tfPesquisa = new JFormattedTextField(new MaskFormatter("###-#-##-######-#"));
					tfPesquisa.setBounds(136, 28, 393, 26);
					panel_1.add(tfPesquisa);
					tfPesquisa.setColumns(10);
					comboBox.transferFocus();
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Título", "Autor", "ISBN"}));
		comboBox.setBounds(10, 28, 92, 26);
		panel_1.add(comboBox);
		
		table_1 = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		table_1.setModel(modelo);
		modelo.addColumn("Titulo");
		modelo.addColumn("Autor");
		modelo.addColumn("ISBN");
		modelo.addColumn("Edição");
		modelo.addColumn("Ano");
		modelo.addColumn("Volume");
		modelo.addColumn("Categoria");
		modelo.addColumn("Resumo");
		modelo.addColumn("Estoque");
		modelo.addColumn("Total");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 744, 196);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(Color.BLACK);
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPesquisar.setBounds(624, 28, 107, 27);
		panel_1.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					
					table_1 = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table_1.setModel(modelo);
					modelo.addColumn("Titulo");
					modelo.addColumn("Autor");
					modelo.addColumn("ISBN");
					modelo.addColumn("Edição");
					modelo.addColumn("Ano");
					modelo.addColumn("Volume");
					modelo.addColumn("Categoria");
					modelo.addColumn("Resumo");
					modelo.addColumn("Estoque");
					modelo.addColumn("Total");
					scrollPane.setViewportView(table_1);
					
					if(comboBox.getSelectedItem().equals("Título")){
						if(tfPesquisa.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Campo de título em branco!");
							tfPesquisa.grabFocus();
						}
						else{
							livros = Fachada.getInstance().buscaLivroTitulo(tfPesquisa.getText());
							for(Livro l1 : livros){
								String titulo = l1.getTitulo();
								String autor = l1.getAutor();
								String isbn = l1.getIsbn();
								String edicao = l1.getEdicao();
								int ano = l1.getAno();
								String volume = l1.getVolume();
								String categoria = l1.getResumo();
								String resumo = l1.getResumo(); 
								int estoque = l1.getEstoque();
								int total = l1.getTotal();
								modelo.addRow(new Object[]{titulo, autor, isbn, edicao, ano, volume, categoria, resumo, estoque, total});
							}
							if(livros.isEmpty())
								JOptionPane.showMessageDialog(null, "Nenhum registro enconntrado");
						}
					}else if(comboBox.getSelectedItem().equals("ISBN")){
						if(tfPesquisa.getText().equals("   - -  -      - ")){
							JOptionPane.showMessageDialog(null, "Campo isbn vazio!");
							tfPesquisa.grabFocus();
						}
						else{
							Livro l2 = Fachada.getInstance().buscaLivroISBN(tfPesquisa.getText());
							if(l2 == null)
								JOptionPane.showMessageDialog(null, "Nenhum livro encontrado");
							String titulo = l2.getTitulo();
							String autor = l2.getAutor();
							String isbn = l2.getIsbn();
							String edicao = l2.getEdicao();
							int ano = l2.getAno();
							String volume = l2.getVolume();
							String categoria = l2.getResumo();
							String resumo = l2.getResumo(); 
							int estoque = l2.getEstoque();
							int total = l2.getTotal();
							modelo.addRow(new Object[]{titulo, autor, isbn, edicao, ano, volume, categoria, resumo, estoque, total});
						}
					}else if(comboBox.getSelectedItem().equals("Autor")){
						if(tfPesquisa.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Campo autor vazio");
							tfPesquisa.grabFocus();
						}
						else{
							livros = Fachada.getInstance().buscaLivroAutor(tfPesquisa.getText());
							for(Livro l3 : livros){
								String titulo = l3.getTitulo();
								String autor = l3.getAutor();
								String isbn = l3.getIsbn();
								String edicao = l3.getEdicao();
								int ano = l3.getAno();
								String volume = l3.getVolume();
								String categoria = l3.getResumo();
								String resumo = l3.getResumo(); 
								int estoque = l3.getEstoque();
								int total = l3.getTotal();
								modelo.addRow(new Object[]{titulo, autor, isbn, edicao, ano, volume, categoria, resumo, estoque, total});
							}
							if(livros.isEmpty())
								JOptionPane.showMessageDialog(null, "Nenhum livro encontrado!");
						}
					}
				}catch(Exception exception){
					
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.BLACK);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExcluir.setBounds(344, 354, 100, 27);
		getContentPane().add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Livro u = livros.get(table_1.getSelectedRow());
					if(JOptionPane.showConfirmDialog(null, "Tem certeza que excluir este livro?" ,"Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					boolean a = Fachada.getInstance().removerLivro(u.getIsbn());					
						if(a){
							livros.remove(table_1.getSelectedRow());
							table_1 = new JTable();
							DefaultTableModel modelo = new DefaultTableModel();
							table_1.setModel(modelo);
							modelo.addColumn("Titulo");
							modelo.addColumn("Autor");
							modelo.addColumn("ISBN");
							modelo.addColumn("Edição");
							modelo.addColumn("Ano");
							modelo.addColumn("Volume");
							modelo.addColumn("Categoria");
							modelo.addColumn("Resumo");
							modelo.addColumn("Estoque");
							modelo.addColumn("Total");
							scrollPane.setViewportView(table_1);
							/*
							if(comboBox.getSelectedItem().equals("Nome")){
								if(tfPesquisa.getText()!= "")
									livros = Fachada.getInstance().buscaLivroTitulo(tfPesquisa.getText());
								else
									livros = Fachada.getInstance().exibirLivros(); 
							   }
							else if(comboBox.getSelectedItem().equals("Autor")){
								if(tfPesquisa.getText()!="")
									livros = Fachada.getInstance().buscaLivroAutor(tfPesquisa.getText());
								else
									livros = Fachada.getInstance().exibirLivros();
							}
							else 
								if(tfPesquisa.getText().equals(""))
									livros = Fachada.getInstance().exibirLivros();
							*/
							for(Livro l : livros){
								String titulo = l.getTitulo();
								String autor = l.getAutor();
								String isbn = l.getIsbn();
								String edicao = l.getEdicao();
								int ano = l.getAno();
								String volume = l.getVolume();
								String categoria = l.getResumo();
								String resumo = l.getResumo(); 
								int estoque = l.getEstoque();
								int total = l.getTotal();
								modelo.addRow(new Object[]{titulo, autor, isbn, edicao, ano, volume, categoria, resumo, estoque, total});
							}
						}
					}
				}catch(SQLException exception){
					ErrosGUI eg = new ErrosGUI();
					eg.mensagemExcluirLivro(exception, table_1);
				}catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "Nenhum livro foi selecionado!");
				}catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Nenhum cliente foi selecionado!");
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(Color.BLACK);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setBounds(458, 354, 100, 27);
		getContentPane().add(btnSair);
		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					dispose();
					
				}catch(Exception exception){
					
				}
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(Color.BLACK);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtualizar.setBounds(223, 354, 100, 27);
		getContentPane().add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					Livro u = livros.get(table_1.getSelectedRow());
					System.out.println(u);
					FormAtuaLivro tela = new FormAtuaLivro(u);
					tela.setVisible(true);
				}catch(ArrayIndexOutOfBoundsException e2){
						JOptionPane.showMessageDialog(null, "Nenhum livro selecionado!");
				}catch(NullPointerException e1){
						JOptionPane.showMessageDialog(null, "Nenhum livro selecionado!");
				}catch(Exception exception){}		
			}
		});
		
		JButton btnMostrarTodos = new JButton("Mostrar Todos");
		btnMostrarTodos.setBackground(Color.BLACK);
		btnMostrarTodos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMostrarTodos.setBounds(304, 95, 139, 27);
		getContentPane().add(btnMostrarTodos);
		btnMostrarTodos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					table_1 = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table_1.setModel(modelo);
					modelo.addColumn("Titulo");
					modelo.addColumn("Autor");
					modelo.addColumn("ISBN");
					modelo.addColumn("Edição");
					modelo.addColumn("Ano");
					modelo.addColumn("Volume");
					modelo.addColumn("Categoria");
					modelo.addColumn("Resumo");
					modelo.addColumn("Estoque");
					modelo.addColumn("Total");
					scrollPane.setViewportView(table_1);
					
					livros = Fachada.getInstance().exibirLivros();
					for(Livro l : livros){
						String titulo = l.getTitulo();
						String autor = l.getAutor();
						String isbn = l.getIsbn();
						String edicao = l.getEdicao();
						int ano = l.getAno();
						String volume = l.getVolume();
						String categoria = l.getResumo();
						String resumo = l.getResumo(); 
						int estoque = l.getEstoque();
						int total = l.getTotal();
						modelo.addRow(new Object[]{titulo, autor, isbn, edicao, ano, volume, categoria, resumo, estoque, total});
					}
					if(livros.isEmpty())
						JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
				}catch(Exception exception){
					
				}
			}
		});
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
	}
}
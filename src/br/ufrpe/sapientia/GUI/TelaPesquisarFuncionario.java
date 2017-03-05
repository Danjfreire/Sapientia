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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.util.List;
import java.awt.Color;

public class TelaPesquisarFuncionario extends JInternalFrame {
	private JTextField tfPesquisa;
	private JTable table_1;
	private List<Usuario>funcionarios;

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
		setClosable(true);
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel_1.setBounds(10, 11, 744, 88);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tfPesquisa = new JTextField();
		tfPesquisa.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(tfPesquisa.getText().length() == 50){
					getToolkit().beep();
					e.consume();
				}
			}
		});
		tfPesquisa.setBounds(105, 34, 403, 28);
		panel_1.add(tfPesquisa);
		tfPesquisa.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 744, 206);
		getContentPane().add(scrollPane);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					panel_1.remove(tfPesquisa);
					if(comboBox.getSelectedItem().equals("Nome")){
						tfPesquisa = new JTextField();
						tfPesquisa.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent e) {
								if(tfPesquisa.getText().length() == 50){
									getToolkit().beep();
									e.consume();
								}
							}
						});
					}
					else
						tfPesquisa = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
					tfPesquisa.setBounds(105, 34, 403, 28);
					panel_1.add(tfPesquisa);
					tfPesquisa.setColumns(10);
					comboBox.transferFocus();
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome", "Cpf"}));
		comboBox.setBounds(10, 34, 88, 28);
		panel_1.add(comboBox);
		
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
		modelo.addColumn("Endereço");
		modelo.addColumn("Contato");
		modelo.addColumn("Email");
		modelo.addColumn("Sexo");
		modelo.addColumn("Login");
		scrollPane.setViewportView(table_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(Color.BLACK);
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPesquisar.setBounds(591, 34, 107, 27);
		panel_1.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					table_1 = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table_1.setModel(modelo);
					modelo.addColumn("Nome");
					modelo.addColumn("CPF");
					modelo.addColumn("Endereço");
					modelo.addColumn("Contato");
					modelo.addColumn("Email");
					modelo.addColumn("Sexo");
					modelo.addColumn("Login");
					scrollPane.setViewportView(table_1);
					
					if(comboBox.getSelectedItem().equals("Nome")){
						if(tfPesquisa.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Campo nome vazio");
							tfPesquisa.grabFocus();
						}
						else{
							funcionarios = Fachada.getInstance().buscarUsuarioNome(tfPesquisa.getText(), "F");
							for(Usuario u : funcionarios){
								String nome = u.getNome();
								String cpf = u.getCpf();
								String endereco = u.getLogradouro() + ", " + u.getNumero() + " -" + u.getBairro() + "- " + u.getCidade() + "/" + u.getEstado();
								String contato = u.getContato();
								String email = u.getEmail();
								String sexo = u.getSexo();
								String login = u.getLogin();
								modelo.addRow(new Object[]{nome, cpf, endereco, contato, email, sexo, login});
							}
							if(funcionarios.isEmpty())
								JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!");
						}
					}
					else if(comboBox.getSelectedItem().equals("Cpf")){
						if(tfPesquisa.getText().equals("   .   .   -  ")){
							JOptionPane.showMessageDialog(null, "Campo cpf vazio");
							tfPesquisa.grabFocus();
						}
						else{
							Usuario u = Fachada.getInstance().buscarUsuarioCPF(tfPesquisa.getText(), "F");
							if(u == null)
								JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
							String nome = u.getNome();
							String cpf = u.getCpf();
							String endereco = u.getLogradouro() + ", " + u.getNumero() + " -" + u.getBairro() + "- " + u.getCidade() + "/" + u.getEstado();
							String contato = u.getContato();
							String email = u.getEmail();
							String sexo = u.getSexo();
							String login = u.getLogin();
							modelo.addRow(new Object[]{nome, cpf, endereco, contato, email, sexo, login});
			
						}
					}
						
				}catch(Exception exception){
					
				}
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtualizar.setBackground(Color.BLACK);
		btnAtualizar.setBounds(200, 368, 100, 27);
		getContentPane().add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					Usuario u = funcionarios.get(table_1.getSelectedRow());
					table_1.getSelectionModel().clearSelection();
					FormAtuaFunc tela = new FormAtuaFunc(u);
					tela.setVisible(true);	
				}
				catch(ArrayIndexOutOfBoundsException e2){
					JOptionPane.showMessageDialog(null, "Nenhum funcionário selecionado!");
				}
				catch(NullPointerException e1){
					JOptionPane.showMessageDialog(null, "Nenhum funcionário selecionado!");
				}
				catch(Exception exception){					
					exception.printStackTrace();
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExcluir.setBackground(Color.BLACK);
		btnExcluir.setBounds(332, 368, 100, 27);
		getContentPane().add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Usuario u = funcionarios.get(table_1.getSelectedRow());
					System.out.println(table_1.getSelectedRow());
					if(JOptionPane.showConfirmDialog(null, "Tem certeza que excluir este funcionário?" ,"Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
						boolean a = Fachada.getInstance().removerUsuario(u.getCpf());
						if(a){
							//sucesso
							funcionarios.remove(table_1.getSelectedRow());
							table_1 = new JTable();
							DefaultTableModel modelo = new DefaultTableModel();
							table_1.setModel(modelo);
							modelo.addColumn("Nome");
							modelo.addColumn("CPF");
							modelo.addColumn("Endereço");
							modelo.addColumn("Contato");
							modelo.addColumn("Email");
							modelo.addColumn("Sexo");
							modelo.addColumn("Login");
							scrollPane.setViewportView(table_1);
							/*if(comboBox.getSelectedItem().equals("Nome")){
								if(tfPesquisa.getText()!="")
									clientes = Fachada.getInstance().buscarUsuarioNome(tfPesquisa.getText(), "C");
								else
									clientes = Fachada.getInstance().exibirUsuarios("C");
						      }else{
						    	  if(tfPesquisa.getText().equals("")){
						    		  clientes = Fachada.getInstance().exibirUsuarios("C");
						    	  }
						      }
							*/
							
							for(Usuario user : funcionarios){
								String nome = user.getNome();
								String cpf = user.getCpf();
								String endereco = user.getLogradouro() + ", " + user.getNumero() + " -" + user.getBairro() + "- " + user.getCidade() + "/" + user.getEstado();
								String contato = user.getContato();
								String email = user.getEmail();
								String sexo = user.getSexo();
								String login = user.getLogin();
								modelo.addRow(new Object[]{nome, cpf, endereco, contato, email, sexo, login});
							}
				        }
					}
				} catch(SQLException exception){
					ErrosGUI eg = new ErrosGUI();
					eg.mensagemExcluirCliente(exception, table_1);
				} 
				catch(ArrayIndexOutOfBoundsException e3){
					JOptionPane.showMessageDialog(null, "Nenhum funcionário foi selecionado!");
				}
				catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Nenhum funcionário foi selecionado!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		JButton btnExibirTodos = new JButton("Exibir todos");
		btnExibirTodos.setBackground(Color.BLACK);
		btnExibirTodos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExibirTodos.setBounds(317, 110, 130, 27);
		getContentPane().add(btnExibirTodos);
		btnExibirTodos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					table_1 = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table_1.setModel(modelo);
					modelo.addColumn("Nome");
					modelo.addColumn("CPF");
					modelo.addColumn("Endereço");
					modelo.addColumn("Contato");
					modelo.addColumn("Email");
					modelo.addColumn("Sexo");
					modelo.addColumn("Login");
					scrollPane.setViewportView(table_1);
					
					funcionarios = Fachada.getInstance().exibirUsuarios("F");
					if(funcionarios.isEmpty()){
						JOptionPane.showMessageDialog(null, "Registro vazio!");
					}
					for(Usuario u : funcionarios){
						String nome = u.getNome();
						String cpf = u.getCpf();
						String endereco = u.getLogradouro() + ", " + u.getNumero() + " -" + u.getBairro() + "- " + u.getCidade() + "/" + u.getEstado();
						String contato = u.getContato();
						String email = u.getEmail();
						String sexo = u.getSexo();
						String login = u.getLogin();
						modelo.addRow(new Object[]{nome, cpf, endereco, contato, email, sexo, login});
					 }
					
				}catch(Exception exception){
					
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(460, 368, 100, 27);
		getContentPane().add(btnSair);
		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					dispose();
					
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
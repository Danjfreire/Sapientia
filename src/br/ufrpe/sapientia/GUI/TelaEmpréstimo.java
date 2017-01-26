package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;

public class TelaEmpréstimo extends JInternalFrame {
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfTitulo;
	private JTextField tfIsbn;
	private JTextField tfFuncionario;
	private JTextField tfDataInicio;
	private JTextField tfDataFinal;
	private Usuario funcionario;
	
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 744, 74);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome.:");
		lblNome.setBounds(10, 23, 48, 14);
		panel.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(48, 20, 435, 20);
		panel.add(tfNome);
		
		JLabel lblCpf = new JLabel("Cpf.:");
		lblCpf.setBounds(544, 23, 32, 14);
		panel.add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(586, 20, 148, 20);
		panel.add(tfCpf);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados do Livro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 96, 744, 106);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo.:");
		lblTtulo.setBounds(248, 27, 46, 14);
		panel_1.add(lblTtulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(304, 24, 430, 20);
		panel_1.add(tfTitulo);
		
		JLabel lblIsbn = new JLabel("ISBN.:");
		lblIsbn.setBounds(10, 27, 46, 14);
		panel_1.add(lblIsbn);
		
		tfIsbn = new JTextField();
		tfIsbn.setColumns(10);
		tfIsbn.setBounds(53, 24, 131, 20);
		panel_1.add(tfIsbn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Empr\u00E9stimo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 223, 459, 106);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio.:");
		lblFuncionrio.setBounds(10, 24, 70, 14);
		panel_2.add(lblFuncionrio);
		
		tfFuncionario = new JTextField();
		tfFuncionario.setColumns(10);
		tfFuncionario.setBounds(82, 21, 365, 20);
		panel_2.add(tfFuncionario);
		tfFuncionario.setText(funcionario.getNome());
		tfFuncionario.setEditable(false);
		
		JLabel lblDadtaIncio = new JLabel("Data In\u00EDcio.:");
		lblDadtaIncio.setBounds(10, 61, 70, 14);
		panel_2.add(lblDadtaIncio);
		
		tfDataInicio = new JTextField();
		tfDataInicio.setColumns(10);
		tfDataInicio.setBounds(82, 58, 121, 20);
		panel_2.add(tfDataInicio);
		tfDataInicio.setText(inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR));
		
		JLabel lblDataDevoluo = new JLabel("Data Devolu\u00E7\u00E3o.:");
		lblDataDevoluo.setBounds(232, 61, 84, 14);
		panel_2.add(lblDataDevoluo);
		
		tfDataFinal = new JTextField();
		tfDataFinal.setColumns(10);
		tfDataFinal.setBounds(326, 58, 121, 20);
		panel_2.add(tfDataFinal);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(278, 358, 89, 23);
		getContentPane().add(btnNovo);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(394, 358, 89, 23);
		getContentPane().add(btnSair);
		
		btnNovo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
//					SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
//					Date fim = df.parse(tfDataFinal.getText());
//					Calendar termino = Calendar.getInstance();
//					termino.setTime(fim);
					if(Fachada.getInstance().efetuarEmprestimo(tfDataInicio.getText(), tfDataFinal.getText(), "PENDENTE",func.getCpf(),tfCpf.getText(),tfIsbn.getText())){
						System.out.println("emprestimo realizado com sucesso");
					}
				}
				catch(Exception exception){
					//msg de erro
				}
			}
		});
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);

	}
}

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

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;

public class TelaEmpréstimo extends JInternalFrame {
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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CPF do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 117, 261, 63);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblCpf = new JLabel("Cpf.:");
		lblCpf.setBounds(10, 23, 32, 14);
		panel.add(lblCpf);
		
		try {
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			tfCpf.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(!(tfIsbn.getText().equals(""))){
						try {
							tfTitulo.setEditable(true);
							tfTitulo.setText(Fachada.getInstance().buscaLivroISBN(tfIsbn.getText()).getTitulo());
							tfTitulo.setEditable(false);
						} catch (NullPointerException e3) {
							JOptionPane.showMessageDialog(null, "ISBN não cadastrado");
							tfIsbn.setText("");
							tfTitulo.setText("");
							tfTitulo.setEditable(false);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			tfCpf.setToolTipText("Digite seu cpf");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfCpf.setColumns(10);
		tfCpf.setBounds(52, 20, 148, 20);
		panel.add(tfCpf);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados do Livro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 744, 74);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo.:");
		lblTtulo.setBounds(248, 27, 46, 14);
		panel_1.add(lblTtulo);
		
		try {
			tfTitulo = new JFormattedTextField(new MaskFormatter("**************************************************"));
			tfTitulo.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(!(tfIsbn.getText().equals(""))){
						try {
							tfTitulo.setEditable(true);
							tfTitulo.setText(Fachada.getInstance().buscaLivroISBN(tfIsbn.getText()).getTitulo());
							tfTitulo.setEditable(false);
						} catch (NullPointerException e3) {
							JOptionPane.showMessageDialog(null, "ISBN não cadastrado");
							tfIsbn.setText("");
							tfTitulo.setText("");
							tfTitulo.setEditable(false);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			tfIsbn = new JFormattedTextField(new MaskFormatter("###-#-##-######-#"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfIsbn.setColumns(10);
		tfIsbn.setBounds(53, 24, 131, 20);
		panel_1.add(tfIsbn);
		
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(304, 24, 430, 20);
		panel_1.add(tfTitulo);
		tfTitulo.setEditable(false);
		
		JLabel lblIsbn = new JLabel("ISBN.:");
		lblIsbn.setBounds(10, 27, 46, 14);
		panel_1.add(lblIsbn);
		
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
		tfDataInicio.setEditable(false);
		
		JLabel lblDataDevoluo = new JLabel("Data Devolu\u00E7\u00E3o.:");
		lblDataDevoluo.setBounds(232, 61, 84, 14);
		panel_2.add(lblDataDevoluo);
		
		try {
			tfDataFinal = new JFormattedTextField(new MaskFormatter("##/##/####"));
			tfDataFinal.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(!(tfIsbn.getText().equals(""))){
						try {
							tfTitulo.setEditable(true);
							tfTitulo.setText(Fachada.getInstance().buscaLivroISBN(tfIsbn.getText()).getTitulo());
							tfTitulo.setEditable(false);
						} catch (NullPointerException e3) {
							JOptionPane.showMessageDialog(null, "ISBN não cadastrado");
							tfIsbn.setText("");
							tfTitulo.setText("");
							tfTitulo.setEditable(false);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
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
					tfTitulo.setEditable(true);
					tfTitulo.setText(Fachada.getInstance().buscaLivroISBN(tfIsbn.getText()).getTitulo());
					tfTitulo.setEditable(false);
					if(Fachada.getInstance().efetuarEmprestimo(tfDataInicio.getText(), tfDataFinal.getText(), "PENDENTE",func.getCpf(),tfCpf.getText(),tfIsbn.getText())){
						JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso");
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
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);

	}
}

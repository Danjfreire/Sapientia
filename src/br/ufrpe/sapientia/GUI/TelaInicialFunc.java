package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import br.ufrpe.sapientia.negocio.beans.*;

public class TelaInicialFunc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario funcionario;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
			    {
			      UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
			    } 
			    catch (Exception e) 
			    {
			      e.printStackTrace();
			    }
				try {
					TelaInicialFunc frame = new TelaInicialFunc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TelaInicialFunc(Usuario u) {
		
		this.funcionario = u;
		setTitle("Sapientia");
		//setExtendedState( MAXIMIZED_BOTH );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_1356382438063");
		desktopPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/pensador1.png")));
		label.setBounds(0, -115, 1024, 734);
		desktopPane.add(label);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		JMenu mnGerenciamento = new JMenu("Gerenciamento");
		menuBar.add(mnGerenciamento);
		
		JMenu mnFuncionrios = new JMenu("Funcion\u00E1rios");
		mnGerenciamento.add(mnFuncionrios);
		
		
		
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastrarFuncionario tela = new TelaCadastrarFuncionario();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnFuncionrios.add(mntmCadastrar);
		
		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mntmPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaPesquisarFuncionario tela = new TelaPesquisarFuncionario();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnFuncionrios.add(mntmPesquisar);
		
		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaAtualizarFuncionario tela = new TelaAtualizarFuncionario();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
			}
		});
		mnFuncionrios.add(mntmAtualizar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExcluirFuncionario tela = new TelaExcluirFuncionario();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
			}
		});
		mnFuncionrios.add(mntmExcluir);
		
		JMenu mnLivros = new JMenu("Livros");
		mnGerenciamento.add(mnLivros);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastrarLivro tela = new TelaCadastrarLivro();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnLivros.add(mntmCadastrar_1);
		
		JMenuItem mntmPesquisar_1 = new JMenuItem("Pesquisar");
		mntmPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPesquisarLivro tela = new TelaPesquisarLivro();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnLivros.add(mntmPesquisar_1);
		
		JMenuItem mntmAtualizar_1 = new JMenuItem("Atualizar");
		mntmAtualizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaAtualizarLivro tela = new TelaAtualizarLivro();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnLivros.add(mntmAtualizar_1);
		
		JMenuItem mntmExcluir_1 = new JMenuItem("Excluir");
		mntmExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExcluirLivro tela = new TelaExcluirLivro();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnLivros.add(mntmExcluir_1);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnGerenciamento.add(mnClientes);
		
		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastrarCliente tela = new TelaCadastrarCliente();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnClientes.add(mntmCadastrar_2);
		
		JMenuItem mntmPesquisar_2 = new JMenuItem("Pesquisar");
		mntmPesquisar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPesquisarCliente tela = new TelaPesquisarCliente();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnClientes.add(mntmPesquisar_2);
		
		JMenuItem mntmAtualizar_2 = new JMenuItem("Atualizar");
		mntmAtualizar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaAtualizarCliente tela = new TelaAtualizarCliente();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnClientes.add(mntmAtualizar_2);
		
		JMenuItem mntmExcluir_2 = new JMenuItem("Excluir");
		mntmExcluir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExcluirCliente tela = new TelaExcluirCliente();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnClientes.add(mntmExcluir_2);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		mnGerenciamento.add(mntmSair);
		
		JMenu mnBuscas = new JMenu("Buscas");
		menuBar.add(mnBuscas);
		
		JMenuItem mntmHistricoDeEmprstimo = new JMenuItem("Hist\u00F3rico de Empr\u00E9stimo");
		mntmHistricoDeEmprstimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaHistóricoLivros tela = new TelaHistóricoLivros();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnBuscas.add(mntmHistricoDeEmprstimo);
		
		JMenuItem mntmLivrosPendentes = new JMenuItem("Livros Pendentes");
		mntmLivrosPendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPendenciaLivros tela = new TelaPendenciaLivros();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnBuscas.add(mntmLivrosPendentes);
		
		JMenu mnEmprstimo = new JMenu("Empr\u00E9stimo");
		menuBar.add(mnEmprstimo);
		
		JMenuItem mntmEmprestarLivro = new JMenuItem("Emprestar Livro");
		mntmEmprestarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaEmpréstimo tela = new TelaEmpréstimo();
				desktopPane.add(tela);
				try {
					tela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela.show();
				
			}
		});
		mnEmprstimo.add(mntmEmprestarLivro);
		
		
		

	}
}

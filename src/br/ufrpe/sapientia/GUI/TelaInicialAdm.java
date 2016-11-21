package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class TelaInicialAdm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialAdm frame = new TelaInicialAdm();
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
	public TelaInicialAdm() {
		
		setTitle("Sapientia-ADM");
		setExtendedState( MAXIMIZED_BOTH );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 647);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_1356382438063");
		desktopPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicialAdm.class.getResource("/Imagens/azul.jpg")));
		label.setBounds(0, 0, 1024, 688);
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
				tela.show();
				
			}
		});
		mnFuncionrios.add(mntmCadastrar);
		
		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mntmPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaPesquisarFuncionario tela = new TelaPesquisarFuncionario();
				desktopPane.add(tela);
				tela.show();
				
			}
		});
		mnFuncionrios.add(mntmPesquisar);
		
		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaAtualizarFuncionario tela = new TelaAtualizarFuncionario();
				desktopPane.add(tela);
				tela.show();
			}
		});
		mnFuncionrios.add(mntmAtualizar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExcluirFuncionario tela = new TelaExcluirFuncionario();
				desktopPane.add(tela);
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
				tela.show();
				
			}
		});
		mnLivros.add(mntmCadastrar_1);
		
		JMenuItem mntmPesquisar_1 = new JMenuItem("Pesquisar");
		mntmPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPesquisarLivro tela = new TelaPesquisarLivro();
				desktopPane.add(tela);
				tela.show();
				
			}
		});
		mnLivros.add(mntmPesquisar_1);
		
		JMenuItem mntmAtualizar_1 = new JMenuItem("Atualizar");
		mntmAtualizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaAtualizarLivro tela = new TelaAtualizarLivro();
				desktopPane.add(tela);
				tela.show();
				
			}
		});
		mnLivros.add(mntmAtualizar_1);
		
		JMenuItem mntmExcluir_1 = new JMenuItem("Excluir");
		mntmExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExcluirLivro tela = new TelaExcluirLivro();
				desktopPane.add(tela);
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
				tela.show();
				
			}
		});
		mnClientes.add(mntmCadastrar_2);
		
		JMenuItem mntmPesquisar_2 = new JMenuItem("Pesquisar");
		mntmPesquisar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPesquisarCliente tela = new TelaPesquisarCliente();
				desktopPane.add(tela);
				tela.show();
				
			}
		});
		mnClientes.add(mntmPesquisar_2);
		
		JMenuItem mntmAtualizar_2 = new JMenuItem("Atualizar");
		mntmAtualizar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaAtualizarCliente tela = new TelaAtualizarCliente();
				desktopPane.add(tela);
				tela.show();
				
			}
		});
		mnClientes.add(mntmAtualizar_2);
		
		JMenuItem mntmExcluir_2 = new JMenuItem("Excluir");
		mntmExcluir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExcluirCliente tela = new TelaExcluirCliente();
				desktopPane.add(tela);
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
				tela.show();
				
			}
		});
		mnBuscas.add(mntmHistricoDeEmprstimo);
		
		JMenuItem mntmLivrosPendentes = new JMenuItem("Livros Pendentes");
		mntmLivrosPendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPendenciaLivros tela = new TelaPendenciaLivros();
				desktopPane.add(tela);
				tela.show();
				
			}
		});
		mnBuscas.add(mntmLivrosPendentes);
		
		JMenu mnAtualizaes = new JMenu("Atualiza\u00E7\u00F5es");
		menuBar.add(mnAtualizaes);
		
		JMenuItem mntmAtualizarAdm = new JMenuItem("Atualizar Adm");
		mntmAtualizarAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaAtualAdm tela = new TelaAtualAdm();
				desktopPane.add(tela);
				tela.show();
				
			}
		});
		mnAtualizaes.add(mntmAtualizarAdm);
		
		
		

	}
}

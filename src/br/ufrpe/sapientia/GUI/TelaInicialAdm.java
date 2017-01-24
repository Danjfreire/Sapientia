package br.ufrpe.sapientia.GUI;

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
import java.awt.Color;
import java.awt.Font;

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
				try 
			    {
			      UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
			    } 
			    catch (Exception e) 
			    {
			      e.printStackTrace();
			    }
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
		setResizable(false);
		
		setTitle("Sapientia-ADM");
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
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao Sapientia!");
		lblBemVindoAo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBemVindoAo.setForeground(Color.WHITE);
		lblBemVindoAo.setBounds(10, 11, 256, 56);
		desktopPane.add(lblBemVindoAo);
		
		JLabel lblSeuSistemaDe = new JLabel("Seu sistema de gerenciamento de Livros.");
		lblSeuSistemaDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSeuSistemaDe.setForeground(Color.WHITE);
		lblSeuSistemaDe.setBounds(10, 78, 432, 31);
		desktopPane.add(lblSeuSistemaDe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicialAdm.class.getResource("/Imagens/pensador1.png")));
		label.setBounds(0, -61, 1024, 688);
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
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
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
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
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
		
		JMenu mnLivros = new JMenu("Livros");
		mnGerenciamento.add(mnLivros);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
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
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
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
		
		JMenu mnClientes = new JMenu("Clientes");
		mnGerenciamento.add(mnClientes);
		
		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
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
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
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
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
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
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
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
		
		JMenu mnAtualizaes = new JMenu("Atualiza\u00E7\u00F5es");
		menuBar.add(mnAtualizaes);
		
		JMenuItem mntmAtualizarAdm = new JMenuItem("Atualizar Adm");
		mntmAtualizarAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
				TelaAtualAdm tela = new TelaAtualAdm();
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
		mnAtualizaes.add(mntmAtualizarAdm);
		
		
		

	}
}

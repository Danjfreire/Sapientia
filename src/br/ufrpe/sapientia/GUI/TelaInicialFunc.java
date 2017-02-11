package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.impl.oa.toa.TransientObjectManager;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import br.ufrpe.sapientia.dados.RepositorioEmprestimos;
import br.ufrpe.sapientia.negocio.beans.*;
import javax.swing.JToggleButton;
import javax.swing.Timer;

import java.awt.Color;

public class TelaInicialFunc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario funcionario;
	private int count;

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
		RepositorioEmprestimos re = new RepositorioEmprestimos();
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		Calendar data = Calendar.getInstance();
		try{
			emprestimos = re.pesquisarTodos();
			for(Emprestimo e : emprestimos){
				if(data.get(Calendar.YEAR) > e.getDataDevolucao().get(Calendar.YEAR))
					re.atualizar(e.getIdEmprestimo(), "ATRASADO");
				else if(data.get(Calendar.YEAR) == e.getDataDevolucao().get(Calendar.YEAR)){
					if(data.get(Calendar.MONTH) > e.getDataDevolucao().get(Calendar.MONTH))
						re.atualizar(e.getIdEmprestimo(), "ATRASADO");
					else if(data.get(Calendar.MONTH) == e.getDataDevolucao().get(Calendar.MONTH)){
						if(data.get(Calendar.DAY_OF_MONTH) > e.getDataDevolucao().get(Calendar.DAY_OF_MONTH))
							re.atualizar(e.getIdEmprestimo(), "ATRASADO");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
		setResizable(false);
		
		setForeground(new Color(135, 206, 235));
		setBackground(new Color(135, 206, 235));
		
		this.funcionario = u;
		setTitle("Sapientia");
		//setExtendedState( MAXIMIZED_BOTH );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 788)/2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 509)/2), 788, 509);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setForeground(new Color(135, 206, 235));
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
		lblSeuSistemaDe.setBounds(10, 78, 373, 31);
		desktopPane.add(lblSeuSistemaDe);
		
		JLabel slide = new JLabel();
		slide.setBounds(10, 120, 363, 172);
		desktopPane.add(slide);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/pensador3.png")));
		label.setBounds(0, 0, 780, 443);
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
		
		JMenu mnEmprstimo = new JMenu("Empr\u00E9stimo");
		menuBar.add(mnEmprstimo);
		
		JMenuItem mntmEmprestarLivro = new JMenuItem("Emprestar Livro");
		mntmEmprestarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
				TelaEmpréstimo tela = new TelaEmpréstimo(funcionario);
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
		
		JMenuItem mntmDevolverLivro = new JMenuItem("Devolver Livro");
		mntmDevolverLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
				TelaDevolucao tela = new TelaDevolucao();
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
		mnEmprstimo.add(mntmDevolverLivro);
		
		List<ImageIcon> fotos= new ArrayList<ImageIcon>();
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro1.png")));
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro2.png")));
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro3.png")));
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro4.png")));
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro5.png")));
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro6.png")));
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro7.png")));
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro8.png")));
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro9.png")));
		fotos.add(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/livro10.png")));
		count = 0;
		
		Timer tempo = new Timer(5000, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(count == 10)
					count = 0;
				slide.setIcon(fotos.get(count));
				count++;
			}
		});
		tempo.start();
	}
}

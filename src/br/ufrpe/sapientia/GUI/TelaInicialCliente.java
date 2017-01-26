package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import br.ufrpe.sapientia.negocio.beans.*;

public class TelaInicialCliente extends JFrame {

	private JPanel contentPane;
	private Usuario usuario;

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
					TelaInicialCliente frame = new TelaInicialCliente();
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
	public TelaInicialCliente(Usuario u) {
		setResizable(false);
		
		this.usuario = u;
		setResizable(false);
		setTitle("Sapientia");
		//setExtendedState( MAXIMIZED_BOTH );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(289, 110, 788, 509);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_4560701681448");
		
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
		label.setIcon(new ImageIcon(TelaInicialFunc.class.getResource("/Imagens/pensador3.png")));
		label.setBounds(0, 0, 780, 443);
		desktopPane.add(label);
		
		JMenu mnHistorico = new JMenu("Hist\u00F3rico");
		menuBar.add(mnHistorico);
		
		JMenuItem mntmHistricoEmprstimos = new JMenuItem("Hist\u00F3rico Empr\u00E9stimos");
		mntmHistricoEmprstimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
				TelaHistoricoCliente tela = new TelaHistoricoCliente(u);
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
		mnHistorico.add(mntmHistricoEmprstimos);
		
		JMenu mnPendncias = new JMenu("Pend\u00EAncias");
		mnPendncias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		menuBar.add(mnPendncias);
		
		JMenuItem mntmPendnciasDeLivros = new JMenuItem("Pend\u00EAncias de Livros");
		mntmPendnciasDeLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(desktopPane.getAllFrames().length != 0)
					desktopPane.remove(0);
				TelaPendenciaCliente tela = new TelaPendenciaCliente(u);
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
		mnPendncias.add(mntmPendnciasDeLivros);
		
	}
}

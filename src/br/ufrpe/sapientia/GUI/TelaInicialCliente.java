package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class TelaInicialCliente extends JFrame {

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
					TelaInicialCliente frame = new TelaInicialCliente();
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
	public TelaInicialCliente() {
		setTitle("Sapientia");
		setExtendedState( MAXIMIZED_BOTH );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 744);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_4560701681448");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicialCliente.class.getResource("/Imagens/azul.jpg")));
		label.setBounds(0, 0, 1024, 733);
		desktopPane.add(label);
		
		JMenu mnHistorico = new JMenu("Hist\u00F3rico");
		menuBar.add(mnHistorico);
		
		JMenuItem mntmHistricoEmprstimos = new JMenuItem("Hist\u00F3rico Empr\u00E9stimos");
		mntmHistricoEmprstimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaHistoricoCliente tela = new TelaHistoricoCliente();
				desktopPane.add(tela);
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
				
				TelaPendenciaCliente tela = new TelaPendenciaCliente();
				desktopPane.add(tela);
				tela.show();
				
			}
		});
		mnPendncias.add(mntmPendnciasDeLivros);
		
	}
}

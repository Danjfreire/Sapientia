package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import java.awt.CardLayout;
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
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	//			        if ("Nimbus".equals(info.getName())) {
	//			            UIManager.setLookAndFeel(info.getClassName());
	//			            break;
	//			        }
	//			    }
	//			} catch (Exception e) {
	//			    // If Nimbus is not available, you can set the GUI to another look and feel.
	//			}
	//			try {
	//				TelaInicialCliente frame = new TelaInicialCliente();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public TelaInicialCliente(Usuario u) {
		
		this.usuario = u;
		setResizable(false);
		setTitle("Sapientia");
		//setExtendedState( MAXIMIZED_BOTH );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 641);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_4560701681448");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicialCliente.class.getResource("/Imagens/pensador1.png")));
		label.setBounds(0, -72, 703, 733);
		desktopPane.add(label);
		
		JMenu mnHistorico = new JMenu("Hist\u00F3rico");
		menuBar.add(mnHistorico);
		
		JMenuItem mntmHistricoEmprstimos = new JMenuItem("Hist\u00F3rico Empr\u00E9stimos");
		mntmHistricoEmprstimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaHistoricoCliente tela = new TelaHistoricoCliente();
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
				
				TelaPendenciaCliente tela = new TelaPendenciaCliente();
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

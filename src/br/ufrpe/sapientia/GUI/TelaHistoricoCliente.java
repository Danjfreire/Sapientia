package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import br.ufrpe.sapientia.fachada.Fachada;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import br.ufrpe.sapientia.negocio.beans.*;

import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaHistoricoCliente extends JInternalFrame {
	private JTable table;
	private Usuario usuario;

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
//					TelaHistoricoCliente frame = new TelaHistoricoCliente();
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
	public TelaHistoricoCliente(Usuario u) {
		this.usuario = u;
		setClosable(true);
		setTitle("Hist\u00F3rico");
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 744, 295);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("C\u00F3digo");
		modelo.addColumn("T\u00EDtulo");
		modelo.addColumn("In\u00EDcio");
		modelo.addColumn("Devolu\u00E7\u00E3o");
		scrollPane.setViewportView(table);
		
		try {
			List<Historico> historicos = Fachada.getInstance().pesquisarHistoricoCliente(usuario.getCpf());
			if(historicos.size()>0){
				for(Historico h : historicos){
					int id = h.getId();
					Calendar inicio = h.getDataEmprestimo();
					String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);					
					Calendar fim = h.getDataDevolucao();
					String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
					Livro l = Fachada.getInstance().buscaLivroISBN(h.getIsbnLivro());
					modelo.addRow(new Object[]{id,l.getTitulo(),dataInicio,dataFim});
				}
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Historico vazio");
			dispose();
		}
		 catch(Exception ex){
			 ex.printStackTrace();
		 }
		
		JLabel lblNewLabel = new JLabel("Hist\u00F3rico de emprestimos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 33, 252, 22);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(320, 372, 100, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
		
		
	}

}

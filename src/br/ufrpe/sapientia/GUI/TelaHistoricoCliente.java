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
		setIconifiable(true);
		setTitle("Hist\u00F3rico");
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 744, 312);
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
			List<Emprestimo>emprestimos = Fachada.getInstance().verificarPendenciasCliente(usuario.getCpf(), "ENTREGUE");
			for(Emprestimo emp : emprestimos){
				Calendar inicio = emp.getDataEmprestimo();
				String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
				Calendar fim = emp.getDataDevolucao();
				String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
				Livro l = Fachada.getInstance().buscaLivroISBN(emp.getIsbnLivro());
				modelo.addRow(new Object[]{"",l.getTitulo(),dataInicio,dataFim});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Meu historico");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(320, 16, 110, 22);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(320, 372, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
		
		
	}

}

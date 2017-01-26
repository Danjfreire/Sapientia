package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;

import java.util.Calendar;
import java.util.List;
import br.ufrpe.sapientia.negocio.beans.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPendenciaCliente extends JInternalFrame {
	private JTable table;
	private Usuario cliente;

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
//					TelaPendenciaCliente frame = new TelaPendenciaCliente();
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
	public TelaPendenciaCliente(Usuario cliente) {
		this.cliente = cliente;
		setTitle("Pend\u00EAncias");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 744, 275);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("C\u00F3digo");
		modelo.addColumn("T\u00EDtulo");
		modelo.addColumn("In\u00EDcio");
		modelo.addColumn("Devolu\u00E7\u00E3o");
		modelo.addColumn("Atraso");
		
		scrollPane.setViewportView(table);
		
		try{
			List<Emprestimo> emprestimos = Fachada.getInstance().verificarPendenciasCliente(cliente.getCpf(),"PENDENTE");
			List<Emprestimo> emprestimos1 = Fachada.getInstance().verificarPendenciasCliente(cliente.getCpf(), "ATRASADO");
			for(Emprestimo e : emprestimos){
				Calendar inicio = e.getDataEmprestimo();
				String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
				Calendar fim = e.getDataDevolucao();
				String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
				Livro l = Fachada.getInstance().buscaLivroISBN(e.getIsbnLivro());
				modelo.addRow(new Object[]{" ",l.getTitulo(),dataInicio,dataFim,e.getStatus()});
			}
			for(Emprestimo e : emprestimos1){
				Calendar inicio = e.getDataEmprestimo();
				String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
				Calendar fim = e.getDataDevolucao();
				String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
				Livro l = Fachada.getInstance().buscaLivroISBN(e.getIsbnLivro());
				modelo.addRow(new Object[]{" ",l.getTitulo(),dataInicio,dataFim,e.getStatus()});
			}
		}catch(Exception e){
			
		}
		
		
		JLabel lblNewLabel = new JLabel("Livros em atraso!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(274, 11, 144, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContatarCliente = new JLabel("Devolva Imediatamente!");
		lblContatarCliente.setForeground(Color.RED);
		lblContatarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContatarCliente.setBounds(274, 329, 209, 30);
		getContentPane().add(lblContatarCliente);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(329, 370, 89, 23);
		getContentPane().add(btnSair);
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
		
		
	}
}

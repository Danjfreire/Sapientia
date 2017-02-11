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
import javax.swing.JOptionPane;

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
		List<Emprestimo> emprestimos;
		this.cliente = cliente;
		setTitle("Pend\u00EAncias");
		setClosable(true);
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 744, 275);
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
		
		JLabel lblNewLabel = new JLabel("Lista de livros pendentes:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 36, 239, 27);
		getContentPane().add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(318, 360, 100, 27);
		getContentPane().add(btnSair);
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
		
		try{
			emprestimos = Fachada.getInstance().verificarPendenciasCliente(cliente.getCpf());
			if(emprestimos.isEmpty()){
				JOptionPane.showMessageDialog(null, "Cliente não possui emprestimos!");
				dispose();
			}
			for(Emprestimo e : emprestimos){
				int id = e.getIdEmprestimo();
				Calendar inicio = e.getDataEmprestimo();
				String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
				Calendar fim = e.getDataDevolucao();
				String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
				Livro l = Fachada.getInstance().buscaLivroISBN(e.getIsbnLivro());
				modelo.addRow(new Object[]{id,l.getTitulo(),dataInicio,dataFim,e.getStatus()});
			}
//			for(Emprestimo e : emprestimos1){
//				Calendar inicio = e.getDataEmprestimo();
//				String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
//				Calendar fim = e.getDataDevolucao();
//				String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
//				Livro l = Fachada.getInstance().buscaLivroISBN(e.getIsbnLivro());
//				modelo.addRow(new Object[]{" ",l.getTitulo(),dataInicio,dataFim,e.getStatus()});
//			}
		}catch(Exception e){
			
		}
	}
}

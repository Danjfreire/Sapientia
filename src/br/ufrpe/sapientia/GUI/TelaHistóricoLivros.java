package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;

public class TelaHistóricoLivros extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				        if ("Nimbus".equals(info.getName())) {
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
				} catch (Exception e) {
				    // If Nimbus is not available, you can set the GUI to another look and feel.
				}
				try {
					TelaHistóricoLivros frame = new TelaHistóricoLivros();
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
	public TelaHistóricoLivros() {
		setTitle("Hist\u00F3rico de Empr\u00E9stimo de Livro");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 780, 499);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 22, 730, 79);
		getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 28, 515, 22);
		panel.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ISBN","Funcionario","Cliente"}));
		comboBox.setBounds(10, 20, 65, 36);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 730, 305);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("Cliente");
		modelo.addColumn("Funcion\u00E1rio");
		modelo.addColumn("Data");
		modelo.addColumn("Devolu\u00E7\u00E3o");
		modelo.addColumn("Situa\u00E7\u00E3o");
		
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					table = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					modelo.addColumn("Cliente");
					modelo.addColumn("Funcion\u00E1rio");
					modelo.addColumn("Data");
					modelo.addColumn("Devolu\u00E7\u00E3o");
					modelo.addColumn("Situa\u00E7\u00E3o");
					
					List<Emprestimo>emprestimos = new ArrayList<Emprestimo>();
					if(comboBox.getSelectedItem().equals("ISBN")){
						emprestimos = Fachada.getInstance().verificarEmprestimoISBN(textField.getText());
					}else if(comboBox.getSelectedItem().equals("Funcionario")){
						emprestimos = Fachada.getInstance().verificarEmprestimoFunc(textField.getText());
					}else{
						emprestimos = Fachada.getInstance().verificarEmprestimoCliente(textField.getText());
					}
					
					for(Emprestimo emp : emprestimos){
						Calendar inicio = emp.getDataEmprestimo();
						String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
						Calendar fim = emp.getDataDevolucao();
						String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
						Usuario cliente = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfCliente(), "C");
						Usuario func = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfFuncionario(), "F");
						
						modelo.addRow(new Object[]{cliente.getNome(),func.getNome(),dataInicio,dataFim,emp.getStatus()});
					}
					
					
					
				}catch(Exception ex){
					
				}
			}
		});
		btnBuscar.setBounds(628, 21, 92, 36);
		panel.add(btnBuscar);
		
		
		
	}

}

package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import br.ufrpe.sapientia.negocio.beans.*;
import br.ufrpe.sapientia.fachada.Fachada;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

public class TelaPendenciaLivros extends JInternalFrame {
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
					TelaPendenciaLivros frame = new TelaPendenciaLivros();
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
	public TelaPendenciaLivros() {
		setTitle("Livros Pendentes");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 744, 70);
		getContentPane().add(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u00EDtulo", "ISBN"}));
		comboBox.setBounds(10, 22, 72, 20);
		panel.add(comboBox);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(92, 22, 526, 20);
		panel.add(textField);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 744, 217);
		getContentPane().add(scrollPane);

		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		modelo.addColumn("C\u00F3digo");
		modelo.addColumn("T\u00EDtulo");
		modelo.addColumn("Cliente");
		modelo.addColumn("CPf cliente");
		modelo.addColumn("funcionario");
		modelo.addColumn("Data emprestimo");
		modelo.addColumn("Data devolucao");

		scrollPane.setViewportView(table);


		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(647, 21, 89, 23);
		panel.add(btnBuscar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(338, 345, 89, 23);
		getContentPane().add(btnSair);
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					table = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					modelo.addColumn("C\u00F3digo");
					//modelo.addColumn("ISBN");
					modelo.addColumn("T\u00EDtulo");
					modelo.addColumn("Cliente");
					modelo.addColumn("CPf cliente");
					modelo.addColumn("funcionario");
					modelo.addColumn("Data emprestimo");
					modelo.addColumn("Data devolucao");
					scrollPane.setViewportView(table);
					
					int livro = 0;
					List<Emprestimo> emprestimos;
					List<Livro> l = new ArrayList<Livro>();
					Livro l1 = null;
					boolean aux = true;
					
					if(comboBox.getSelectedItem().equals("T\u00EDtulo")){
						emprestimos = Fachada.getInstance().verificarEmprestimoLivro(textField.getText());
						l = Fachada.getInstance().buscaLivroTitulo(textField.getText());
						aux = false;
					}else {
						emprestimos = Fachada.getInstance().verificarEmprestimoISBN(textField.getText());
						l1 = Fachada.getInstance().buscaLivroISBN(textField.getText());
					}
					for(Emprestimo emp : emprestimos){
						
						Usuario cliente = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfCliente(), "C");
						Usuario func = Fachada.getInstance().buscarUsuarioCPF(emp.getCpfFuncionario(), "F");
						Calendar inicio = emp.getDataEmprestimo();
						String dataInicio = inicio.get(Calendar.DAY_OF_MONTH)+"/"+(inicio.get(Calendar.MONTH)+1)+"/"+inicio.get(Calendar.YEAR);
						Calendar fim = emp.getDataDevolucao();
						String dataFim = fim.get(Calendar.DAY_OF_MONTH)+"/"+(fim.get(Calendar.MONTH)+1)+"/"+fim.get(Calendar.YEAR);
						
						if(!aux){
							modelo.addRow(new Object[]{"",l.get(livro).getTitulo(),cliente.getNome(),cliente.getCpf(),func.getNome(),dataInicio,dataFim});
							livro++;
						}else
							modelo.addRow(new Object[]{"",l1.getTitulo(),cliente.getNome(),cliente.getCpf(),func.getNome(),dataInicio,dataFim});	
							
						
					}
				}catch(Exception ex){

				}
			}
		});
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);


	}
}

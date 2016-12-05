package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;

public class TelaCadastrarLivro extends JInternalFrame {
	private JTextField tfTitulo; //titulo
	private JTextField tfEdicao; // ano
	private JTextField tfAutor; // autor
	private JTextField tfAno;// edicao
	private JTextField tfISBN;// isbn
	private JTextField tfVolume;// volume
	private JTextField tfCategoria; // categoria
	//resumo = edicao

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
					// If Nimbus is not available, you can set the GUI to
					// another look and feel.
				}
				try {
					TelaCadastrarLivro frame = new TelaCadastrarLivro();
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
	public TelaCadastrarLivro() {
		setTitle("Cadastrar Livros");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 879, 474);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 38, 749, 434);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastrarLivro.class.getResource("/Imagens/livro.png")));
		label.setBounds(54, 71, 135, 128);
		panel.add(label);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo.:");
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTtulo.setBounds(262, 68, 72, 14);
		panel.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor.:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutor.setBounds(262, 118, 62, 14);
		panel.add(lblAutor);
		
		JLabel lblEdio = new JLabel("Edi\u00E7\u00E3o.:");
		lblEdio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdio.setBounds(262, 164, 62, 14);
		panel.add(lblEdio);
		
		JLabel lblAno = new JLabel("Ano.:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAno.setBounds(262, 213, 62, 14);
		panel.add(lblAno);
		
		JLabel lblIsbn = new JLabel("ISBN.:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsbn.setBounds(262, 254, 62, 14);
		panel.add(lblIsbn);
		
		JLabel lblVolume = new JLabel("Volume.:");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVolume.setBounds(262, 302, 62, 14);
		panel.add(lblVolume);
		
		tfTitulo= new JTextField();
		tfTitulo.setBounds(344, 65, 143, 20);
		panel.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		tfEdicao = new JTextField();
		tfEdicao.setBounds(344, 161, 115, 20);
		panel.add(tfEdicao);
		tfEdicao.setColumns(10);
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(344, 115, 115, 20);
		panel.add(tfAutor);
		
		tfAno = new JTextField();
		tfAno.setColumns(10);
		tfAno.setBounds(344, 207, 72, 20);
		panel.add(tfAno);
		
		tfISBN = new JTextField();
		tfISBN.setColumns(10);
		tfISBN.setBounds(344, 251, 72, 20);
		panel.add(tfISBN);
		
		tfVolume = new JTextField();
		tfVolume.setColumns(10);
		tfVolume.setBounds(344, 299, 115, 20);
		panel.add(tfVolume);
		
		JLabel lblCategoria = new JLabel("Categoria.:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria.setBounds(262, 343, 88, 14);
		panel.add(lblCategoria);
		
		JLabel lblResumo = new JLabel("Resumo.:");
		lblResumo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResumo.setBounds(528, 72, 72, 14);
		panel.add(lblResumo);
		
		tfCategoria = new JTextField();
		tfCategoria.setColumns(10);
		tfCategoria.setBounds(344, 340, 143, 20);
		panel.add(tfCategoria);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(528, 97, 188, 269);
		panel.add(textArea);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalvar.setBounds(10, 292, 89, 68);
		panel.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					
				if(	Fachada.getInstance().cadastraLivro(tfTitulo.getText(), tfAutor.getText(), tfEdicao.getText(), tfAno.getText(), tfISBN.getText(), 
						tfVolume.getText(), tfCategoria.getText(), textArea.getText(), 10, 10)){
					JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso!");
					//Livro l = new Livro(tfTitulo.getText(), tfAutor.getText(), tfEdicao.getText(), tfAno.getText(), tfISBN.getText(), 
					//		tfVolume.getText(), tfCategoria.getText(), textArea.getText(), 10, 10);
					//System.out.println(l);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null,"Dados inválidos!");
					tfTitulo.setText("");
					tfEdicao.setText("");
					tfAutor.setText("");
					tfAno.setText("");
					tfISBN.setText("");
					textArea.setText("");
					tfVolume.setText("");
				}
			}catch(Exception exception){
				
				
			}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();			}
		});
		btnCancelar.setBounds(132, 292, 89, 68);
		panel.add(btnCancelar);
		
		

	}
}

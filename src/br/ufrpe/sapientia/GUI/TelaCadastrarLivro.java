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
	private JTextField tfEstoque;
	private JTextField tfTotal;
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
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(263, 11, 506, 279);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo.:");
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTtulo.setBounds(10, 27, 72, 14);
		panel.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor.:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutor.setBounds(10, 52, 62, 14);
		panel.add(lblAutor);
		
		JLabel lblEdio = new JLabel("Edi\u00E7\u00E3o.:");
		lblEdio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdio.setBounds(10, 77, 62, 14);
		panel.add(lblEdio);
		
		JLabel lblAno = new JLabel("Ano.:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAno.setBounds(10, 102, 62, 14);
		panel.add(lblAno);
		
		JLabel lblIsbn = new JLabel("ISBN.:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsbn.setBounds(10, 127, 62, 14);
		panel.add(lblIsbn);
		
		JLabel lblVolume = new JLabel("Volume.:");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVolume.setBounds(10, 152, 62, 14);
		panel.add(lblVolume);
		
		tfTitulo= new JTextField();
		tfTitulo.setBounds(91, 26, 143, 20);
		panel.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		tfEdicao = new JTextField();
		tfEdicao.setBounds(91, 76, 143, 20);
		panel.add(tfEdicao);
		tfEdicao.setColumns(10);
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(91, 51, 143, 20);
		panel.add(tfAutor);
		
		tfAno = new JTextField();
		tfAno.setColumns(10);
		tfAno.setBounds(91, 101, 142, 20);
		panel.add(tfAno);
		
		tfISBN = new JTextField();
		tfISBN.setColumns(10);
		tfISBN.setBounds(92, 126, 142, 20);
		panel.add(tfISBN);
		
		tfVolume = new JTextField();
		tfVolume.setColumns(10);
		tfVolume.setBounds(92, 151, 142, 20);
		panel.add(tfVolume);
		
		JLabel lblCategoria = new JLabel("Categoria.:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria.setBounds(10, 177, 88, 14);
		panel.add(lblCategoria);
		
		JLabel lblResumo = new JLabel("Resumo.:");
		lblResumo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResumo.setBounds(294, 27, 72, 14);
		panel.add(lblResumo);
		
		tfCategoria = new JTextField();
		tfCategoria.setColumns(10);
		tfCategoria.setBounds(92, 176, 143, 20);
		panel.add(tfCategoria);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(294, 49, 188, 197);
		panel.add(textArea);
		
		JLabel lblEstoque = new JLabel("Estoque.:");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstoque.setBounds(10, 202, 79, 14);
		panel.add(lblEstoque);
		
		JLabel lblTotal = new JLabel("Total.:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(10, 227, 62, 14);
		panel.add(lblTotal);
		
		tfEstoque = new JTextField();
		tfEstoque.setBounds(91, 201, 143, 20);
		panel.add(tfEstoque);
		tfEstoque.setColumns(10);
		
		tfTotal = new JTextField();
		tfTotal.setText("");
		tfTotal.setBounds(92, 226, 143, 20);
		panel.add(tfTotal);
		tfTotal.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 11, 180, 169);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaCadastrarLivro.class.getResource("/Imagens/livro.png")));
		label_1.setBounds(22, 11, 135, 128);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 191, 216, 99);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 11, 89, 68);
		panel_2.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 11, 89, 68);
		panel_2.add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
				if(	Fachada.getInstance().cadastraLivro(tfTitulo.getText(), tfAutor.getText(), tfEdicao.getText(), tfAno.getText(), tfISBN.getText(), 
						tfVolume.getText(), tfCategoria.getText(), textArea.getText(), Integer.parseInt(tfEstoque.getText()), Integer.parseInt(tfTotal.getText()))){
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
					tfEstoque.setText("");
					tfTotal.setText("");
				}
			}catch(Exception exception){
				
				
			}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();			}
		});
		
		

	}
}

package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ImageIcon;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;

public class FormAtuaLivro extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTextField tfEdicao;
	private JTextField tfAutor;
	private JTextField tfAno;
	private JTextField tfISBN;
	private JTextField tfVolume;
	private JTextField tfCategoria;
	Livro livro;
	private JTextField tfEstoque;
	private JTextField tfTotal;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
					FormAtuaLivro frame = new FormAtuaLivro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FormAtuaLivro(Livro livro) {
		this.livro = livro;
		setTitle("Atualizando Livro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(223, 11, 450, 318);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("T\u00EDtulo.:");
		label_1.setBounds(10, 39, 56, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Autor.:");
		label_2.setBounds(10, 64, 46, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Edi\u00E7\u00E3o.:");
		label_3.setBounds(10, 89, 46, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Ano.:");
		label_4.setBounds(10, 114, 46, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("ISBN.:");
		label_5.setBounds(10, 14, 46, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Volume.:");
		label_6.setBounds(10, 139, 46, 14);
		panel.add(label_6);
		
		tfTitulo = new JTextField();
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(83, 36, 115, 20);
		panel.add(tfTitulo);
		tfTitulo.setText(livro.getTitulo());
		
		tfEdicao = new JTextField();
		tfEdicao.setColumns(10);
		tfEdicao.setBounds(83, 86, 115, 20);
		panel.add(tfEdicao);
		tfEdicao.setText(livro.getEdicao());
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(83, 61, 115, 20);
		panel.add(tfAutor);
		tfAutor.setText(livro.getAutor());
		
		tfAno = new JTextField();
		tfAno.setColumns(10);
		tfAno.setBounds(83, 111, 115, 20);
		panel.add(tfAno);
		tfAno.setText(livro.getAno());
		
		tfISBN = new JTextField();
		tfISBN.setEditable(false);
		tfISBN.setColumns(10);
		tfISBN.setBounds(83, 11, 115, 20);
		panel.add(tfISBN);
		tfISBN.setText(livro.getIsbn());
		
		tfVolume = new JTextField();
		tfVolume.setColumns(10);
		tfVolume.setBounds(83, 136, 115, 20);
		panel.add(tfVolume);
		tfVolume.setText(livro.getVolume());
		
		JLabel label_7 = new JLabel("Categoria.:");
		label_7.setBounds(10, 164, 72, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Resumo.:");
		label_8.setBounds(247, 27, 46, 14);
		panel.add(label_8);
		
		tfCategoria = new JTextField();
		tfCategoria.setColumns(10);
		tfCategoria.setBounds(83, 161, 115, 20);
		panel.add(tfCategoria);
		tfCategoria.setText(livro.getCategoria());
		
		JTextArea resumo = new JTextArea();
		resumo.setBounds(245, 47, 185, 196);
		panel.add(resumo);
		resumo.setText(livro.getResumo());
		
		JLabel lblEstoque = new JLabel("Estoque.:");
		lblEstoque.setBounds(10, 189, 72, 14);
		panel.add(lblEstoque);
		
		JLabel lblTotal = new JLabel("Total.:");
		lblTotal.setBounds(10, 214, 46, 14);
		panel.add(lblTotal);
		
		tfEstoque = new JTextField();
		tfEstoque.setBounds(83, 186, 115, 20);
		panel.add(tfEstoque);
		tfEstoque.setColumns(10);
		tfEstoque.setText(Integer.toString(livro.getEstoque()));
		
		tfTotal = new JTextField();
		tfTotal.setBounds(83, 211, 115, 20);
		panel.add(tfTotal);
		tfTotal.setColumns(10);
		tfTotal.setText(Integer.toString(livro.getTotal()));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 11, 191, 160);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(28, 11, 135, 128);
		panel_1.add(label);
		label.setIcon(new ImageIcon(FormAtuaLivro.class.getResource("/Imagens/livro.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 202, 183, 90);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSair = new JButton("Cancelar");
		btnSair.setBounds(96, 34, 77, 23);
		panel_2.add(btnSair);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(11, 34, 75, 23);
		panel_2.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					boolean a = Fachada.getInstance().atualizarLivro(tfISBN.getText(), tfTitulo.getText(), tfEdicao.getText(), tfAutor.getText(),
							tfAno.getText(), tfVolume.getText(), tfCategoria.getText(), resumo.getText(), 10, 10);
					if(a){
						//sucesso
						dispose();
					}
					
				}catch(Exception exception){
					
				}
			}
		});
		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					
					dispose();
				}catch(Exception exception){
					
				}
			}
		});
	}

}

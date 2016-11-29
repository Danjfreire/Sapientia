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
	private JTextField tfAutor;
	private JTextField tfEdicao;
	private JTextField tfAno;
	private JTextField tfISBN;
	private JTextField tfVolume;
	private JTextField tfCategoria;
	Livro livro;

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
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 564, 318);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FormAtuaLivro.class.getResource("/Imagens/livro.png")));
		label.setBounds(10, 27, 135, 128);
		panel.add(label);
		
		JLabel label_1 = new JLabel("T\u00EDtulo.:");
		label_1.setBounds(155, 21, 56, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Autor.:");
		label_2.setBounds(155, 51, 46, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Edi\u00E7\u00E3o.:");
		label_3.setBounds(155, 81, 46, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Ano.:");
		label_4.setBounds(155, 111, 46, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("ISBN.:");
		label_5.setBounds(155, 141, 46, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Volume.:");
		label_6.setBounds(369, 16, 46, 14);
		panel.add(label_6);
		
		tfTitulo = new JTextField();
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(235, 11, 115, 20);
		panel.add(tfTitulo);
		tfTitulo.setText(livro.getTitulo());
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(235, 73, 115, 20);
		panel.add(tfAutor);
		tfAutor.setText(livro.getAutor());
		
		tfEdicao = new JTextField();
		tfEdicao.setColumns(10);
		tfEdicao.setBounds(235, 42, 115, 20);
		panel.add(tfEdicao);
		tfEdicao.setText(livro.getEdicao());
		
		tfAno = new JTextField();
		tfAno.setColumns(10);
		tfAno.setBounds(235, 104, 115, 20);
		panel.add(tfAno);
		tfAno.setText(livro.getAno());
		
		tfISBN = new JTextField();
		tfISBN.setColumns(10);
		tfISBN.setBounds(235, 135, 115, 20);
		panel.add(tfISBN);
		tfISBN.setText(livro.getISBN());
		
		tfVolume = new JTextField();
		tfVolume.setColumns(10);
		tfVolume.setBounds(439, 14, 115, 20);
		panel.add(tfVolume);
		tfVolume.setText(livro.getVolume());
		
		JLabel label_7 = new JLabel("Categoria.:");
		label_7.setBounds(369, 46, 72, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Resumo.:");
		label_8.setBounds(369, 81, 46, 14);
		panel.add(label_8);
		
		tfCategoria = new JTextField();
		tfCategoria.setColumns(10);
		tfCategoria.setBounds(439, 45, 115, 20);
		panel.add(tfCategoria);
		tfCategoria.setText(livro.getCategoria());
		
		JTextArea resumo = new JTextArea();
		resumo.setBounds(369, 106, 185, 196);
		panel.add(resumo);
		resumo.setText(livro.getResumo());
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(56, 214, 89, 23);
		panel.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					boolean a = Fachada.getInstance().atualizarLivro(tfISBN.getText(), tfTitulo.getText(), tfAutor.getText(), tfEdicao.getText(),
							tfAno.getText(), tfVolume.getText(), tfCategoria.getText(), resumo.getText(), 10);
					if(a){
						//sucesso
						dispose();
					}
					
				}catch(Exception exception){
					
				}
			}
		});
		
		JButton btnSair = new JButton("Cancelar");
		btnSair.setBounds(235, 214, 89, 23);
		panel.add(btnSair);
		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					
					dispose();
				}catch(Exception exception){
					
				}
			}
		});
		
		JList list = new JList();
		list.setBounds(440, 141, 72, 96);
		panel.add(list);
	}

}

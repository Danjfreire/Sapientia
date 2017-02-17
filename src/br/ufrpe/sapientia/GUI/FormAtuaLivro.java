package br.ufrpe.sapientia.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import java.awt.Font;

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
		setResizable(false);
		this.livro = livro;
		setTitle("Atualizando Livro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel.setBounds(287, 37, 450, 318);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("T\u00EDtulo.:");
		label_1.setForeground(new Color(95, 158, 160));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(10, 52, 56, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Autor.:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setForeground(new Color(95, 158, 160));
		label_2.setBounds(10, 83, 62, 14);
		panel.add(label_2);
		
		JLabel lblEditora = new JLabel("Editora.:");
		lblEditora.setForeground(new Color(95, 158, 160));
		lblEditora.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEditora.setBounds(10, 114, 76, 14);
		panel.add(lblEditora);
		
		JLabel label_4 = new JLabel("Ano.:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setForeground(new Color(95, 158, 160));
		label_4.setBounds(10, 145, 46, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("ISBN.:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setForeground(new Color(95, 158, 160));
		label_5.setBounds(10, 21, 56, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Volume.:");
		label_6.setForeground(new Color(95, 158, 160));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(10, 176, 76, 14);
		panel.add(label_6);
		
		try {
			tfTitulo = new JFormattedTextField(new MaskFormatter("**************************************************"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(96, 51, 115, 20);
		panel.add(tfTitulo);
		tfTitulo.setText(livro.getTitulo());
		
		try {
			tfEdicao = new JFormattedTextField(new MaskFormatter("**************************************************"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfEdicao.setColumns(10);
		tfEdicao.setBounds(96, 113, 115, 20);
		panel.add(tfEdicao);
		tfEdicao.setText(livro.getEdicao());
		
		try {
			tfAutor = new JFormattedTextField(new MaskFormatter("**************************************************"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfAutor.setColumns(10);
		tfAutor.setBounds(96, 82, 115, 20);
		panel.add(tfAutor);
		tfAutor.setText(livro.getAutor());
		
		try {
			tfAno = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfAno.setColumns(10);
		tfAno.setBounds(96, 144, 115, 20);
		panel.add(tfAno);
		tfAno.setText(Integer.toString(livro.getAno()));
		
		tfISBN = new JTextField();
		tfISBN.setEditable(false);
		tfISBN.setColumns(10);
		tfISBN.setBounds(96, 20, 115, 20);
		panel.add(tfISBN);
		tfISBN.setText(livro.getIsbn());
		
		try {
			tfVolume = new JFormattedTextField(new MaskFormatter("**********"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfVolume.setColumns(10);
		tfVolume.setBounds(96, 175, 115, 20);
		panel.add(tfVolume);
		tfVolume.setText(livro.getVolume());
		
		JLabel label_7 = new JLabel("Categoria.:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setForeground(new Color(95, 158, 160));
		label_7.setBounds(10, 206, 88, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Resumo.:");
		label_8.setForeground(new Color(95, 158, 160));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_8.setBounds(247, 27, 76, 14);
		panel.add(label_8);
		
		try {
			tfCategoria = new JFormattedTextField(new MaskFormatter("**************************************************"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tfCategoria.setColumns(10);
		tfCategoria.setBounds(96, 205, 115, 20);
		panel.add(tfCategoria);
		tfCategoria.setText(livro.getCategoria());
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(95, 158, 160));
		textArea.setBounds(245, 47, 185, 235);
		panel.add(textArea);
		textArea.setText(livro.getResumo());
		
		JLabel lblEstoque = new JLabel("Estoque.:");
		lblEstoque.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEstoque.setForeground(new Color(95, 158, 160));
		lblEstoque.setBounds(10, 237, 72, 14);
		panel.add(lblEstoque);
		
		JLabel lblTotal = new JLabel("Total.:");
		lblTotal.setForeground(new Color(95, 158, 160));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(10, 268, 72, 14);
		panel.add(lblTotal);
		
		
		tfEstoque = new JFormattedTextField();
		tfEstoque.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(!(Character.isDigit(e.getKeyChar())) || tfEstoque.getText().length() == 9 ){
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_DELETE)
						getToolkit().beep();
					e.consume();
				}
			}
		});
		tfEstoque.setBounds(96, 236, 115, 20);
		panel.add(tfEstoque);
		tfEstoque.setColumns(10);
		tfEstoque.setText(Integer.toString(livro.getEstoque()));
		
		tfTotal = new JFormattedTextField();
		tfTotal.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(!(Character.isDigit(e.getKeyChar())) || tfTotal.getText().length() == 9 ){
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_DELETE)
						getToolkit().beep();
					e.consume();
				}
			}
		});
		tfTotal.setBounds(96, 267, 115, 20);
		panel.add(tfTotal);
		tfTotal.setColumns(10);
		tfTotal.setText(Integer.toString(livro.getTotal()));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(53, 65, 191, 160);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(28, 11, 135, 128);
		panel_1.add(label);
		label.setIcon(new ImageIcon(FormAtuaLivro.class.getResource("/Imagens/livro.png")));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalvar.setBounds(41, 250, 100, 27);
		contentPane.add(btnSalvar);
		
		JButton btnSair = new JButton("Cancelar");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setBounds(151, 250, 100, 27);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					
					dispose();
				}catch(Exception exception){
					
				}
			}
		});
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					if(tfTitulo.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo título em branco!");
						tfTitulo.grabFocus();
					}
					else if(tfAutor.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo autor em branco!");
						tfAutor.grabFocus();
					}
					else{
						if(	Fachada.getInstance().cadastraLivro(tfTitulo.getText(), tfAutor.getText(), tfEdicao.getText(), Integer.parseInt(tfAno.getText()),
								tfISBN.getText(), tfVolume.getText(), tfCategoria.getText(), textArea.getText(), Integer.parseInt(tfEstoque.getText()),
								Integer.parseInt(tfTotal.getText()))){
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
							textArea.setText("");
							tfVolume.setText("");
							tfEstoque.setText("");
							tfTotal.setText("");
						}
					}
				}catch(SQLException exception){
					ErrosGUI eg = new ErrosGUI(exception, tfISBN, tfEstoque, tfTotal, textArea);
					eg.mensagemLivro();
				
				}catch (NumberFormatException e1) {
					if(tfAno.getText().equals("    ")){
						JOptionPane.showMessageDialog(null, "Campo ano em branco!");
						tfAno.grabFocus();
					}
					else if(tfEstoque.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo estoque em branco!");
						tfEstoque.grabFocus();
					}
					else{
						JOptionPane.showMessageDialog(null, "Campo total em branco!");
						tfTotal.grabFocus();
					}
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);
	}

}

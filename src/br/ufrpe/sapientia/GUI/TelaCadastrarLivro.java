package br.ufrpe.sapientia.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;

import br.ufrpe.sapientia.fachada.Fachada;
import br.ufrpe.sapientia.negocio.beans.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		setBounds(100, 100, 780, 443);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(95, 158, 160)));
		panel.setBounds(236, 62, 506, 279);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo.:");
		lblTtulo.setForeground(new Color(95, 158, 160));
		lblTtulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTtulo.setBounds(10, 27, 72, 14);
		panel.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor.:");
		lblAutor.setForeground(new Color(95, 158, 160));
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAutor.setBounds(10, 52, 62, 14);
		panel.add(lblAutor);
		
		JLabel lblEdio = new JLabel("Edi\u00E7\u00E3o.:");
		lblEdio.setForeground(new Color(95, 158, 160));
		lblEdio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdio.setBounds(10, 77, 62, 14);
		panel.add(lblEdio);
		
		JLabel lblAno = new JLabel("Ano.:");
		lblAno.setForeground(new Color(95, 158, 160));
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAno.setBounds(10, 102, 62, 14);
		panel.add(lblAno);
		
		JLabel lblIsbn = new JLabel("ISBN.:");
		lblIsbn.setForeground(new Color(95, 158, 160));
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIsbn.setBounds(10, 127, 62, 14);
		panel.add(lblIsbn);
		
		JLabel lblVolume = new JLabel("Volume.:");
		lblVolume.setForeground(new Color(95, 158, 160));
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVolume.setBounds(10, 152, 72, 14);
		panel.add(lblVolume);
		
		tfTitulo = new JTextField();
		tfTitulo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfTitulo.getText().length() == 50){
					arg0.consume();
					getToolkit().beep();
				}
			}
		});
		tfTitulo.setBounds(104, 26, 143, 20);
		panel.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		tfEdicao = new JTextField();
		tfEdicao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfEdicao.getText().length() == 10){
					arg0.consume();
					getToolkit().beep();
				}
			}
		});
		tfEdicao.setBounds(104, 76, 143, 20);
		panel.add(tfEdicao);
		tfEdicao.setColumns(10);
		
		tfAutor = new JTextField();
		tfAutor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfAutor.getText().length() == 50){
					arg0.consume();
					getToolkit().beep();
				}
			}
		});
		tfAutor.setColumns(10);
		tfAutor.setBounds(104, 51, 143, 20);
		panel.add(tfAutor);
		
		try {
			tfAno = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		tfAno.setColumns(10);
		tfAno.setBounds(104, 101, 142, 20);
		panel.add(tfAno);
		
		try {
			tfISBN = new JFormattedTextField(new MaskFormatter("###-#-##-######-#"));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		tfISBN.setColumns(10);
		tfISBN.setBounds(105, 126, 142, 20);
		panel.add(tfISBN);
		
		tfVolume = new JTextField();
		tfVolume.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfVolume.getText().length() == 10){
					arg0.consume();
					getToolkit().beep();
				}
			}
		});
		tfVolume.setColumns(10);
		tfVolume.setBounds(105, 151, 142, 20);
		panel.add(tfVolume);
		
		JLabel lblCategoria = new JLabel("Categoria.:");
		lblCategoria.setForeground(new Color(95, 158, 160));
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategoria.setBounds(10, 177, 83, 14);
		panel.add(lblCategoria);
		
		JLabel lblResumo = new JLabel("Resumo.:");
		lblResumo.setForeground(new Color(95, 158, 160));
		lblResumo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResumo.setBounds(294, 27, 72, 14);
		panel.add(lblResumo);
		
		tfCategoria = new JTextField();
		tfCategoria.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(tfCategoria.getText().length() == 50){
					arg0.consume();
					getToolkit().beep();
				}
			}
		});
		tfCategoria.setColumns(10);
		tfCategoria.setBounds(104, 176, 143, 20);
		panel.add(tfCategoria);
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(textArea.getText().length() == 1000){
					arg0.consume();
					getToolkit().beep();
				}
			}
		});
		textArea.setBackground(new Color(95, 158, 160));
		textArea.setBounds(294, 49, 188, 197);
		panel.add(textArea);
		
		JLabel lblEstoque = new JLabel("Estoque.:");
		lblEstoque.setForeground(new Color(95, 158, 160));
		lblEstoque.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEstoque.setBounds(10, 202, 72, 14);
		panel.add(lblEstoque);
		
		JLabel lblTotal = new JLabel("Total.:");
		lblTotal.setForeground(new Color(95, 158, 160));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(10, 227, 62, 14);
		panel.add(lblTotal);
		
		
		tfEstoque = new JTextField();
		tfEstoque.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(!(Character.isDigit(e.getKeyChar())) || tfEstoque.getText().length() == 9 ){
					if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_DELETE)
						getToolkit().beep();
					e.consume();
				}
					
			}
		});
		tfEstoque.setBounds(104, 201, 143, 20);
		panel.add(tfEstoque);
		tfEstoque.setColumns(10);
		
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
		tfTotal.setColumns(10);
		tfTotal.setBounds(104, 226, 143, 20);
		panel.add(tfTotal);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(39, 93, 163, 128);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaCadastrarLivro.class.getResource("/Imagens/livro.png")));
		label_1.setBounds(18, 0, 135, 128);
		panel_1.add(label_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(126, 232, 100, 27);
		getContentPane().add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 232, 100, 27);
		getContentPane().add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					if(tfISBN.getText().equals("   - -  -      - ")){
						JOptionPane.showMessageDialog(null, "O campo isbn esta em branco!");
						tfISBN.grabFocus();
					}
					else if(tfTitulo.getText().equals("")){
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
							tfISBN.setText("");
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
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();			
			}
		});
		
		JLabel lbTelaAzul = new JLabel("");
		lbTelaAzul.setIcon(new ImageIcon(TelaLogon.class.getResource("/Imagens/pensador4.jpg")));
		lbTelaAzul.setBounds(-7, -26, 780, 443);
		getContentPane().add(lbTelaAzul);

	}
}

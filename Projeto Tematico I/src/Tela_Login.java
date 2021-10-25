import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Tela_Login extends JFrame {

	private JPanel contentPane;
	private JTextField EdUsuario;
	private JPasswordField EdSenha;
	private JTextField EdAgencia;
	private JTextField EdConta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Login frame = new Tela_Login();
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
	public Tela_Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BtnNovaConta = new JButton("Nova conta");
		BtnNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Login frame = new Cadastro_Login();
				 
				frame.setVisible(true);
			}
		});
		BtnNovaConta.setIcon(null);
		BtnNovaConta.setForeground(Color.RED);
		BtnNovaConta.setBounds(182, 160, 119, 23);
		contentPane.add(BtnNovaConta);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(40, 160, 111, 23);
		contentPane.add(btnLogin);
		
		EdUsuario = new JTextField();
		EdUsuario.setBounds(59, 32, 206, 20);
		contentPane.add(EdUsuario);
		EdUsuario.setColumns(10);
		
		Label label = new Label("CPF");
		label.setEnabled(false);
		label.setBounds(59, 10, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Senha");
		label_1.setEnabled(false);
		label_1.setBounds(59, 54, 62, 22);
		contentPane.add(label_1);
		
		EdSenha = new JPasswordField();
		EdSenha.setBounds(59, 77, 206, 20);
		contentPane.add(EdSenha);
		
		Label label_1_1 = new Label("Ag\u00EAncia");
		label_1_1.setEnabled(false);
		label_1_1.setBounds(59, 103, 62, 22);
		contentPane.add(label_1_1);
		
		Label label_1_1_1 = new Label("Conta");
		label_1_1_1.setEnabled(false);
		label_1_1_1.setBounds(160, 103, 62, 22);
		contentPane.add(label_1_1_1);
		
		EdAgencia = new JTextField();
		EdAgencia.setColumns(10);
		EdAgencia.setBounds(59, 129, 86, 20);
		contentPane.add(EdAgencia);
		
		EdConta = new JTextField();
		EdConta.setColumns(10);
		EdConta.setBounds(160, 129, 105, 20);
		contentPane.add(EdConta);
	}
}

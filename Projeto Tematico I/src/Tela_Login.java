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


public class Tela_Login extends JFrame {

	private JPanel contentPane;
	private JTextField EdUsuario;
	private JPasswordField EdSenha;

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
		setBounds(100, 100, 408, 306);
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
		BtnNovaConta.setBounds(259, 227, 119, 23);
		contentPane.add(BtnNovaConta);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(140, 175, 111, 23);
		contentPane.add(btnLogin);
		
		EdUsuario = new JTextField();
		EdUsuario.setBounds(59, 78, 265, 20);
		contentPane.add(EdUsuario);
		EdUsuario.setColumns(10);
		
		Label label = new Label("Usu\u00E1rio");
		label.setBounds(59, 56, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Senha");
		label_1.setBounds(59, 100, 62, 22);
		contentPane.add(label_1);
		
		EdSenha = new JPasswordField();
		EdSenha.setBounds(59, 123, 265, 20);
		contentPane.add(EdSenha);
		
		JButton btnAguiar = new JButton("TESTE");
		btnAguiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAguiar.setBounds(140, 21, 111, 23);
		contentPane.add(btnAguiar);
	}
}

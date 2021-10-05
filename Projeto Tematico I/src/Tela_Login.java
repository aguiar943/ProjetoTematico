import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Label;
import javax.swing.JPasswordField;

public class Tela_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
		setBounds(100, 100, 404, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Nova conta");
		btnNewButton.setIcon(null);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(259, 227, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(140, 175, 111, 23);
		contentPane.add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(59, 78, 265, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Label label = new Label("Usu\u00E1rio");
		label.setBounds(59, 56, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Senha");
		label_1.setBounds(59, 100, 62, 22);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(59, 123, 265, 20);
		contentPane.add(passwordField);
		
		JButton btnAguiar = new JButton("AGUIAR");
		btnAguiar.setBounds(140, 21, 111, 23);
		contentPane.add(btnAguiar);
	}
}

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

public class Cadastro_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Login frame = new Cadastro_Login();
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
	public Cadastro_Login() {
		setTitle("Cadastro novo usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Nome");
		label.setBounds(12, 10, 62, 22);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(12, 32, 259, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Label label_1 = new Label("CPF");
		label_1.setBounds(12, 55, 62, 22);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 77, 126, 20);
		contentPane.add(textField_1);
		
		Label label_1_1 = new Label("Celular");
		label_1_1.setBounds(12, 98, 62, 22);
		contentPane.add(label_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 120, 126, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(91, 271, 103, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.RED);
		btnCancelar.setBounds(200, 271, 89, 23);
		contentPane.add(btnCancelar);
		
		Label label_1_1_1 = new Label("E-mail");
		label_1_1_1.setBounds(12, 140, 62, 22);
		contentPane.add(label_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(12, 162, 259, 20);
		contentPane.add(textField_3);
		
		Label label_1_1_1_1 = new Label("Senha");
		label_1_1_1_1.setBounds(12, 182, 62, 22);
		contentPane.add(label_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 204, 164, 20);
		contentPane.add(passwordField);
	}
}

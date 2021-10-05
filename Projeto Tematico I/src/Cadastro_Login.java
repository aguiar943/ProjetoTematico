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
	private JTextField EdNome;
	private JTextField EdCPF;
	private JTextField EdCelular;
	private JTextField EdEmail;
	private JPasswordField EdSenha;

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
		
		EdNome = new JTextField();
		EdNome.setBounds(12, 32, 259, 20);
		contentPane.add(EdNome);
		EdNome.setColumns(10);
		
		Label label_1 = new Label("CPF");
		label_1.setBounds(12, 55, 62, 22);
		contentPane.add(label_1);
		
		EdCPF = new JTextField();
		EdCPF.setColumns(10);
		EdCPF.setBounds(12, 77, 126, 20);
		contentPane.add(EdCPF);
		
		Label label_1_1 = new Label("Celular");
		label_1_1.setBounds(12, 98, 62, 22);
		contentPane.add(label_1_1);
		
		EdCelular = new JTextField();
		EdCelular.setColumns(10);
		EdCelular.setBounds(12, 120, 126, 20);
		contentPane.add(EdCelular);
		
		JButton BtnConfirmar = new JButton("Cadastrar");
		BtnConfirmar.setBounds(91, 271, 103, 23);
		contentPane.add(BtnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.RED);
		btnCancelar.setBounds(200, 271, 89, 23);
		contentPane.add(btnCancelar);
		
		Label label_1_1_1 = new Label("E-mail");
		label_1_1_1.setBounds(12, 140, 62, 22);
		contentPane.add(label_1_1_1);
		
		EdEmail = new JTextField();
		EdEmail.setColumns(10);
		EdEmail.setBounds(12, 162, 259, 20);
		contentPane.add(EdEmail);
		
		Label label_1_1_1_1 = new Label("Senha");
		label_1_1_1_1.setBounds(12, 182, 62, 22);
		contentPane.add(label_1_1_1_1);
		
		EdSenha = new JPasswordField();
		EdSenha.setBounds(12, 204, 164, 20);
		contentPane.add(EdSenha);
	}
}

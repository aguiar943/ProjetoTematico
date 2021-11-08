package com.banco.ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public abstract class TelaCriarContaLay extends JFrame {

	private static final long serialVersionUID = 1L;

	protected JButton btnCadastrar;
	protected JButton btnVoltar;

	protected JLabel lblNome;
	protected JLabel lblSobrenome;
	protected JLabel lblUsuario;
	protected JLabel lblSenha;
	protected JLabel lblConfirmaSenha;
	protected JLabel lblCpf;
	protected JLabel lblEmail;
	protected JLabel lblTelefone;

	protected JTextField txtNome;
	protected JTextField txtSobrenome;
	protected JTextField txtUsuario;
	protected JPasswordField txtSenha;
	protected JPasswordField txtConfirmaSenha;
	protected JTextField txtCpf;
	protected JTextField txtEmail;
	protected JTextField txtTelefone;

	protected String PNL_ATUAL;
	protected final String PNL_INICIAL = "PNL_INICIAL";

	protected abstract void cadastrar();

	protected abstract void exibirTelaLogin();

	public TelaCriarContaLay() {
		this.setTitle("Cadastro");
		this.setSize(470, 380);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new CardLayout());

		this.getContentPane().add(PNL_INICIAL, getPnlInicial());

		setarDefaults();
		addEvents();
	}

	private JPanel getPnlInicial() {
		JPanel pnlCriarConta = new JPanel();

		String colunas = "25px, 200px, 25px, 95px, 5px, 95px, 25px";
		String linhas = "25px, 15px, 50px, 15px, 50px, 15px, 50px, 15px, 50px, 15px, 50px, 25px";

		pnlCriarConta.setLayout(new FormLayout(colunas, linhas));

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField();

		lblSobrenome = new JLabel("Sobrenome:");
		txtSobrenome = new JTextField();

		lblSenha = new JLabel("Senha:");
		txtSenha = new JPasswordField();

		lblConfirmaSenha = new JLabel("Confirma senha:");
		txtConfirmaSenha = new JPasswordField();

		lblUsuario = new JLabel("Usuário:");
		txtUsuario = new JTextField();

		lblCpf = new JLabel("CPF:");
		txtCpf = new JTextField();

		lblEmail = new JLabel("Email:");
		txtEmail = new JTextField();

		lblTelefone = new JLabel("Telefone:");
		txtTelefone = new JTextField();

		btnCadastrar = new JButton("Criar");
		btnVoltar = new JButton("Voltar");

		CellConstraints cc = new CellConstraints();

		pnlCriarConta.add(lblNome, cc.xy(2, 2));
		pnlCriarConta.add(txtNome, cc.xy(2, 3));

		pnlCriarConta.add(lblSobrenome, cc.xyw(4, 2, 3));
		pnlCriarConta.add(txtSobrenome, cc.xyw(4, 3, 3));

		pnlCriarConta.add(lblSenha, cc.xy(2, 4));
		pnlCriarConta.add(txtSenha, cc.xy(2, 5));

		pnlCriarConta.add(lblConfirmaSenha, cc.xyw(4, 4, 3));
		pnlCriarConta.add(txtConfirmaSenha, cc.xyw(4, 5, 3));

		pnlCriarConta.add(lblUsuario, cc.xy(2, 6));
		pnlCriarConta.add(txtUsuario, cc.xy(2, 7));

		pnlCriarConta.add(lblCpf, cc.xyw(4, 6, 3));
		pnlCriarConta.add(txtCpf, cc.xyw(4, 7, 3));

		pnlCriarConta.add(lblEmail, cc.xy(2, 8));
		pnlCriarConta.add(txtEmail, cc.xy(2, 9));

		pnlCriarConta.add(lblTelefone, cc.xyw(4, 8, 3));
		pnlCriarConta.add(txtTelefone, cc.xyw(4, 9, 3));

		pnlCriarConta.add(btnCadastrar, cc.xy(4, 11));
		pnlCriarConta.add(btnVoltar, cc.xy(6, 11));

		return pnlCriarConta;
	}

	private void addEvents() {
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirTelaLogin();
			}
		});

		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
	}

	protected void setarDefaults() {
		txtNome.setText("");
		txtSenha.setText("");
		txtUsuario.setText("");
		txtConfirmaSenha.setText("");
		txtSenha.setText("");
		txtSobrenome.setText("");
		txtUsuario.setText("");
		txtCpf.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
	}
}

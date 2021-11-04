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

public abstract class TelaLoginLayOLD extends JFrame {

	private static final long serialVersionUID = 1L;

	protected JButton btnLogin;
	protected JButton btnCriarConta;
	protected JButton btnCadastrar;
	protected JButton btnVoltar;

	protected JLabel lblUsuario;
	protected JLabel lblSenha;

	protected JTextField txtUsuario;
	protected JPasswordField txtSenha;

	protected JLabel lblNome;
	protected JLabel lblSobrenome;
	protected JLabel lblCadastraUsuario;
	protected JLabel lblCadastraSenha;
	protected JLabel lblConfirmaSenha;
	protected JLabel lblCpf;
	protected JLabel lblEmail;
	protected JLabel lblTelefone;

	protected JTextField txtNome;
	protected JTextField txtSobrenome;
	protected JTextField txtCadastraUsuario;
	protected JPasswordField txtCadastraSenha;
	protected JPasswordField txtConfirmaSenha;
	protected JTextField txtCpf;
	protected JTextField txtEmail;
	protected JTextField txtTelefone;

	protected String PNL_ATUAL;
	protected final String PNL_INICIAL = "PNL_INICIAL";
	protected final String PNL_CRIAR_CONTA = "PNL_CRIAR_CONTA";

	protected abstract void login();

	protected abstract void cadastrar();

	public TelaLoginLayOLD() {
		this.setTitle("Login");
		this.setSize(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new CardLayout());

		this.getContentPane().add(PNL_INICIAL, getPnlInicial());
		this.getContentPane().add(PNL_CRIAR_CONTA, getPnlCriarConta());

		addEvents();
	}

	private JPanel getPnlInicial() {
		JPanel pnlLogin = new JPanel();
		String colunas = "10px, 75px, 10px, 120px, 5px, 120px, 10px";
		String linhas = "25px, 50px, 50px, 50px, 25px";

		pnlLogin.setLayout(new FormLayout(colunas, linhas));

		lblUsuario = new JLabel("Usuário");
		lblSenha = new JLabel("Senha");

		txtUsuario = new JTextField();
		txtSenha = new JPasswordField();

		btnLogin = new JButton("Login");
		btnCriarConta = new JButton("Nova Conta");

		CellConstraints cc = new CellConstraints();

		pnlLogin.add(lblUsuario, cc.xy(2, 2, CellConstraints.RIGHT, CellConstraints.DEFAULT));
		pnlLogin.add(lblSenha, cc.xy(2, 3, CellConstraints.RIGHT, CellConstraints.DEFAULT));
		pnlLogin.add(txtUsuario, cc.xywh(4, 2, 3, 1));
		pnlLogin.add(txtSenha, cc.xywh(4, 3, 3, 1));
		pnlLogin.add(btnCriarConta, cc.xy(4, 4));
		pnlLogin.add(btnLogin, cc.xy(6, 4));

		return pnlLogin;
	}

	private JPanel getPnlCriarConta() {
		JPanel pnlCriarConta = new JPanel();

		String colunas = "25px, 200px, 25px, 95px, 5px, 95px, 25px";
		String linhas = "25px, 15px, 50px, 15px, 50px, 15px, 50px, 15px, 50px, 15px, 50px, 25px";

		pnlCriarConta.setLayout(new FormLayout(colunas, linhas));

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField();

		lblSobrenome = new JLabel("Sobrenome:");
		txtSobrenome = new JTextField();

		lblCadastraSenha = new JLabel("Senha:");
		txtCadastraSenha = new JPasswordField();

		lblConfirmaSenha = new JLabel("Confirma senha:");
		txtConfirmaSenha = new JPasswordField();

		lblCadastraUsuario = new JLabel("Usuário:");
		txtCadastraUsuario = new JTextField();

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

		pnlCriarConta.add(lblCadastraSenha, cc.xy(2, 4));
		pnlCriarConta.add(txtCadastraSenha, cc.xy(2, 5));

		pnlCriarConta.add(lblConfirmaSenha, cc.xyw(4, 4, 3));
		pnlCriarConta.add(txtConfirmaSenha, cc.xyw(4, 5, 3));

		pnlCriarConta.add(lblCadastraUsuario, cc.xy(2, 6));
		pnlCriarConta.add(txtCadastraUsuario, cc.xy(2, 7));

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
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		btnCriarConta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirPnlCriarConta();
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirPnlInicial();
			}
		});

		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
	}

	protected void exibirPnlCriarConta() {
		this.setSize(470, 375);
		this.setTitle("Cadastro");
		this.setLocationRelativeTo(null);
		CardLayout cl = (CardLayout) this.getContentPane().getLayout();
		cl.show(this.getContentPane(), PNL_CRIAR_CONTA);
		setarDefaults();
	}

	protected void exibirPnlInicial() {
		this.setSize(350, 200);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		CardLayout cl = (CardLayout) this.getContentPane().getLayout();
		cl.show(this.getContentPane(), PNL_INICIAL);
		setarDefaults();
	}

	protected void setarDefaults() {
		txtNome.setText("");
		txtCadastraSenha.setText("");
		txtCadastraUsuario.setText("");
		txtConfirmaSenha.setText("");
		txtSenha.setText("");
		txtSobrenome.setText("");
		txtUsuario.setText("");
		txtCpf.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
	}

}

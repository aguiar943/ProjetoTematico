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

public abstract class TelaLoginLay extends JFrame {

	private static final long serialVersionUID = 1L;

	protected JButton btnLogin;
	protected JButton btnCriarConta;

	protected JLabel lblUsuario;
	protected JLabel lblSenha;

	protected JTextField txtUsuario;
	protected JPasswordField txtSenha;

	protected String PNL_ATUAL;
	protected final String PNL_INICIAL = "PNL_INICIAL";

	protected abstract void login();

	protected abstract void exibirTelaCadastro();

	public TelaLoginLay() {
		this.setTitle("Login");
		this.setSize(410, 210);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new CardLayout());

		this.getContentPane().add(PNL_INICIAL, getPnlInicial());

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
				exibirTelaCadastro();
			}
		});

	}
}

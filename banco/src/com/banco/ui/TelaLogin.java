package com.banco.ui;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.banco.database.bo.ContaCorrenteBO;
import com.banco.entidades.ContaCorrente;

public class TelaLogin extends TelaLoginLay {

	private static final long serialVersionUID = 1L;

	@Override
	protected void login() {
		String usuario = txtUsuario.getText();
		String senha = String.valueOf(txtSenha.getPassword());

		if (usuario.contentEquals("") || senha.contentEquals("")) {
			showWarningDialog("Preencha os campos usuário e senha");
			return;
		}

		if (!usuarioExiste(txtUsuario.getText())) {
			showErrorDialog("Usuário não encontrado!");
			return;
		}

		if (!verificaSenhaCorreta(usuario, senha)) {
			showErrorDialog("Senha incorreta!");
			return;
		}
	}

	@Override
	protected void exibirTelaCadastro() {
		TelaCriarConta tela = new TelaCriarConta();
		tela.setVisible(true);
		this.dispose();
	}

	private boolean usuarioExiste(String usuario) {
		ContaCorrenteBO contaCorrenteBo = new ContaCorrenteBO();
		ContaCorrente conta = null;
		try {
			conta = contaCorrenteBo.buscarContaPorUsuario(usuario);
		} catch (SQLException e) {
			showErrorDialog("Ocorreu um erro ao verificar cadastramento do usuário");
			e.printStackTrace();
			return false;
		}

		if (conta == null) {
			return false;
		}

		return true;
	}

	private boolean verificaSenhaCorreta(String usuario, String senha) {
		ContaCorrenteBO contaCorrenteBO = new ContaCorrenteBO();
		ContaCorrente cc = null;
		try {
			cc = contaCorrenteBO.buscarContaPorUsuario(usuario);
		} catch (SQLException e) {
			showErrorDialog("Ocorreu um erro ao verificar a senha");
			e.printStackTrace();
			return false;
		}

		if (!senha.contentEquals(cc.getSenha())) {
			return false;
		}

		return true;
	}

	public void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	public void showWarningDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "AVISO", JOptionPane.WARNING_MESSAGE);
	}

}

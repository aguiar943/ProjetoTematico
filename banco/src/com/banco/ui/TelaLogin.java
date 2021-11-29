package com.banco.ui;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.banco.database.bo.impl.ClienteBoImpl;
import com.banco.database.bo.impl.ContaCorrenteBoImpl;
import com.banco.entidades.Cliente;
import com.banco.entidades.ContaCorrente;
import com.banco.util.ObjectHandle;

public class TelaLogin extends TelaLoginLay {

	private static final long serialVersionUID = 1L;

	@Override
	protected boolean login() {
		String usuario = txtUsuario.getText();
		String senha = String.valueOf(txtSenha.getPassword());

		if (usuario.contentEquals("") || senha.contentEquals("")) {
			showWarningDialog("Preencha os campos usuário e senha");
			return false;
		}

		if (!usuarioExiste(txtUsuario.getText())) {
			showErrorDialog("Usuário não encontrado!");
			return false;
		}

		if (!verificaSenhaCorreta(usuario, senha)) {
			showErrorDialog("Senha incorreta!");
			return false;
		}

		if(!setarUsuarioAtivo(usuario)) {
			showErrorDialog("Erro ao setar usuário ativo");
			return false;
		}
		
		return true;
	}

	@Override
	protected void exibirTelaCadastro() {
		TelaCriarConta tela = new TelaCriarConta();
		tela.setVisible(true);
		this.dispose();
	}

	@Override 
	protected void exibirTelaPrincipal() {
		TelaConta tela = new TelaConta();
		tela.setVisible(true);
		this.dispose();
	}
	
	private boolean usuarioExiste(String usuario) {
		ContaCorrenteBoImpl contaCorrenteBo = new ContaCorrenteBoImpl();
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
		ContaCorrenteBoImpl contaCorrenteBO = new ContaCorrenteBoImpl();
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

	private boolean setarUsuarioAtivo(String userName) {
		String erro = "Ocorreu um erro ao realizar login";
		
		ContaCorrenteBoImpl contaCorrenteBo = new ContaCorrenteBoImpl();
		ContaCorrente conta = null;
		try {
			conta = contaCorrenteBo.buscarContaPorUsuario(userName);
		} catch (SQLException e) {
			showErrorDialog(erro);
			e.printStackTrace();
			return false;
		}

		Integer idCliente = null;
		try {
			idCliente = contaCorrenteBo.getClientId(conta.getNumero());
		} catch (SQLException e) {
			showErrorDialog(erro);
			e.printStackTrace();
			return false;
		}
		
		ClienteBoImpl clienteBo = new ClienteBoImpl();
		Cliente titular = null;
		try {
			titular = clienteBo.buscarPorId(idCliente);
		} catch (SQLException e) {
			showErrorDialog(erro);
			e.printStackTrace();
			return false;
		}
		
		conta.setTitular(titular);
		ObjectHandle.setContaLogada(conta);
		return true;
	}
	
	public void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	public void showWarningDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "AVISO", JOptionPane.WARNING_MESSAGE);
	}

}

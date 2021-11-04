package com.banco.ui;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.banco.database.bo.ClienteBO;
import com.banco.database.bo.ContaCorrenteBO;
import com.banco.entidades.Cliente;
import com.banco.entidades.ContaCorrente;

public class TelaCriarConta extends TelaCriarContaLay {

	private static final long serialVersionUID = 1L;

	@Override
	protected void cadastrar() {
		// verificar se todos os campos estão preenchidos
		if (possuiCampoEmBranco()) {
			showWarningDialog("Todos os campos devem ser preenchidos!");
			return;
		}

		// verificar se o nome de usuário já está em uso
		if (usuarioExiste(txtUsuario.getText())) {
			showErrorDialog("Este nome de usuário já está em uso!");
			return;
		}

		// verificar se cpf já está cadastrado
		if (cpfCadastrado(txtCpf.getText())) {
			showErrorDialog("Já existe uma conta com esse CPF!");
			return;
		}

		// veriricar se o email já está cadastrado
		if (emailCadastrado(txtEmail.getText())) {
			showErrorDialog("Email já cadastrado!");
			return;
		}

		// verificar se o número de telefone já está cadastrado
		if (telefoneCadastrado(txtTelefone.getText())) {
			showErrorDialog("Telefone já cadastrado!");
			return;
		}
		// verificação se o campo 'senha' e 'confirma senha' são iguais
		if (!String.valueOf(txtSenha.getPassword()).equals(String.valueOf(txtConfirmaSenha.getPassword()))) {
			showErrorDialog("Senhas não coincidem");
			return;
		}

		gerarCadastro();
		showInfoDialog("Cadastro realizado com sucesso!");
		exibirTelaLogin();
	}

	@Override
	protected void exibirTelaLogin() {
		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);
		this.dispose();
	}

	private boolean possuiCampoEmBranco() {
		return String.valueOf(txtSenha.getPassword()).contentEquals("")
				|| String.valueOf(txtConfirmaSenha.getPassword()).contentEquals("")
				|| txtUsuario.getText().contentEquals("") || txtNome.getText().contentEquals("")
				|| txtSobrenome.getText().contentEquals("") || txtCpf.getText().contentEquals("");
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

	private void gerarCadastro() {
		String nome = txtNome.getText();
		String cpf = txtCpf.getText();
		String sobrenome = txtSobrenome.getText();
		String email = txtEmail.getText();
		String telefone = txtTelefone.getText();
		Cliente novoCliente = new Cliente(nome, sobrenome, cpf, email, telefone);

		Integer numero = gerarNumeroConta();
		String usuario = txtUsuario.getText();
		String senha = String.copyValueOf(txtSenha.getPassword());
		ContaCorrente novaConta = new ContaCorrente(numero, novoCliente, usuario, senha);

		ClienteBO clienteBO = new ClienteBO();
		clienteBO.cadastrarCliente(novoCliente);

		ContaCorrenteBO contaCorrenteBO = new ContaCorrenteBO();
		contaCorrenteBO.cadastrarConta(novaConta);
	}

	private boolean cpfCadastrado(String cpf) {
		ClienteBO clienteBo = new ClienteBO();
		Cliente cliente = null;
		try {
			cliente = clienteBo.buscarPorCpf(cpf);
		} catch (SQLException e) {
			showErrorDialog("Ocorreu um erro ao consultar cpf");
			e.printStackTrace();
			return false;
		}

		if (cliente == null) {
			return false;
		}

		return true;
	}

	private boolean emailCadastrado(String email) {
		ClienteBO clienteBo = new ClienteBO();
		Cliente cliente = null;
		try {
			cliente = clienteBo.buscarPorEmail(email);
		} catch (SQLException e) {
			showErrorDialog("Ocorreu um erro ao consultar email");
			e.printStackTrace();
		}

		if (cliente == null) {
			return false;
		}

		return true;
	}

	private boolean telefoneCadastrado(String telefone) {
		ClienteBO clienteBo = new ClienteBO();
		Cliente cliente = null;
		try {
			cliente = clienteBo.buscarPorTelefone(telefone);
		} catch (SQLException e) {
			showErrorDialog("Ocorreu um erro ao consultar telefone");
			e.printStackTrace();
		}

		if (cliente == null) {
			return false;
		}

		return true;
	}

	private Integer gerarNumeroConta() {
		int max = 9999;
		int min = 1000;
		ContaCorrenteBO bo = new ContaCorrenteBO();
		Integer numero = (int) Math.floor(Math.random() * (max - min + 1) + min);
		while (true) {
			try {
				if (bo.buscarPorNumero(numero) == null) {
					break;
				}
			} catch (SQLException e) {
				showErrorDialog("Ocorreu um erro ao buscar consultar disponibilidade do número da conta.");
				e.printStackTrace();
			}
			numero = (int) Math.floor(Math.random() * (max - min + 1) + min);
		}
		return numero;
	}

	private void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	private void showWarningDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "AVISO", JOptionPane.WARNING_MESSAGE);
	}

	private void showInfoDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "AVISO", JOptionPane.INFORMATION_MESSAGE);
	}

}

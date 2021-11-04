package com.banco.ui;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.banco.database.bo.ClienteBO;
import com.banco.database.bo.ContaCorrenteBO;
import com.banco.entidades.Cliente;
import com.banco.entidades.ContaCorrente;

public class TelaLoginOLD extends TelaLoginLayOLD {

	private static final long serialVersionUID = 1L;

	@Override
	protected void login() {

		String usuario = txtUsuario.getText();
		String senha = String.valueOf(txtSenha.getPassword());

		if (usuario.contentEquals("") || senha.contentEquals("")) {
			showWarningDialog("Preencha os campos usuário e senha");
			exibirPnlInicial();
			return;
		}

		if (!usuarioExiste(txtUsuario.getText())) {
			showErrorDialog("Usuário não encontrado!");
			exibirPnlInicial();
			return;
		}

		if (!verificaSenhaCorreta(usuario, senha)) {
			showErrorDialog("Senha incorreta!");
			exibirPnlInicial();
			return;
		}

	}

	private void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	private void showWarningDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "AVISO", JOptionPane.WARNING_MESSAGE);
	}

	@Override
	protected void cadastrar() {
		// verificar se todos os campos estão preenchidos
		if (possuiCampoEmBranco()) {
			showWarningDialog("Todos os campos devem ser preenchidos!");
			return;
		}

		// verificar se o nome de usuário já está em uso
		if (usuarioExiste(txtCadastraUsuario.getText())) {
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
		if (!String.valueOf(txtCadastraSenha.getPassword()).equals(String.valueOf(txtConfirmaSenha.getPassword()))) {
			showErrorDialog("Senhas não coincidem");
			return;
		}

		gerarCadastro();
		System.out.println("CONTA CRIADA COM SUCESSO!!");
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

	private boolean possuiCampoEmBranco() {
		return String.valueOf(txtCadastraSenha.getPassword()).contentEquals("")
				|| String.valueOf(txtConfirmaSenha.getPassword()).contentEquals("")
				|| txtCadastraUsuario.getText().contentEquals("") || txtNome.getText().contentEquals("")
				|| txtSobrenome.getText().contentEquals("") || txtCpf.getText().contentEquals("");
	}

	private void gerarCadastro() {
		String nome = txtNome.getText();
		String cpf = txtCpf.getText();
		String sobrenome = txtSobrenome.getText();
		String email = txtEmail.getText();
		String telefone = txtTelefone.getText();
		Cliente novoCliente = new Cliente(nome, sobrenome, cpf, email, telefone);

		Integer numero = gerarNumeroConta();
		String usuario = txtCadastraUsuario.getText();
		String senha = String.copyValueOf(txtCadastraSenha.getPassword());
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
}

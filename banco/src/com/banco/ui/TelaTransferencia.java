package com.banco.ui;

import static com.banco.util.Utils.showErrorDialog;

import java.sql.SQLException;

import com.banco.database.bo.impl.ClienteBoImpl;
import com.banco.database.bo.impl.ContaCorrenteBoImpl;
import com.banco.entidades.Cliente;
import com.banco.entidades.ContaCorrente;
import com.banco.util.ObjectHandle;
import com.banco.util.Utils;

public class TelaTransferencia extends TelaTransferenciaLay {

	private static final long serialVersionUID = 1L;

	private ContaCorrente contaTransferencia;

	private void setContaTrasnferencia(ContaCorrente conta) {
		this.contaTransferencia = conta;
	}

	private ContaCorrente getContaTrasnferencia() {
		return this.contaTransferencia;
	}

	@Override
	protected void buscarUsuario(String usuario) {
		ContaCorrenteBoImpl contaBO = new ContaCorrenteBoImpl();
		ContaCorrente conta = null;
		try {
			conta = contaBO.buscarContaPorUsuario(usuario);
		} catch (SQLException e) {
			showErrorDialog(this, "Erro ao buscar dados da conta");
			e.printStackTrace();
			return;
		}

		ClienteBoImpl clienteBO = new ClienteBoImpl();
		Cliente titular = null;
		try {
			titular = clienteBO.buscarPorId(contaBO.getClientId(conta.getNumero()));
		} catch (SQLException e) {
			showErrorDialog(this, "Erro ao buscar dados do titular");
			e.printStackTrace();
			return;
		}

		conta.setTitular(titular);
		habilitarCampos();
		setContaTrasnferencia(conta);
		atualizarCampos(conta);

	}

	// Atualiza os labels com dados da conta que foi digitada
	private void atualizarCampos(ContaCorrente conta) {
		lblNome.setText(conta.getTitular().getNomeCompleto());
		lblCpf.setText(Utils.formatarCpf(conta.getTitular().getCpf()));
		lblNumConta.setText(conta.getNumero().toString());
		lblAgencia.setText(conta.getAgencia());
	}

	@Override
	protected void realizarTransferencia() {
		// Método busca conta que receberá o dinheiro atráves do valor do numConta
		// Efetuará o depósito na conta buscada
		// Efetuará um saque na conta logada

		ContaCorrenteBoImpl contaBo = new ContaCorrenteBoImpl();
		Double valorOperacao = Double.parseDouble(txtValor.getText());

		getContaTrasnferencia().depositar(valorOperacao);
		contaBo.atualizarSaldo(Integer.valueOf(lblNumConta.getText()), getContaTrasnferencia().getSaldo());

		// subtrair do saldo da conta atual, o valor informado
		ObjectHandle.getContaLogada().sacar(valorOperacao);
		contaBo.atualizarSaldo(ObjectHandle.getContaLogada().getNumero(), ObjectHandle.getContaLogada().getSaldo());
		
		Utils.showInfoDialog(this, "Transferência realizada com sucesso!");
		dialogConfirmaSenha.dispose();
		btnVoltar.doClick();
	}

	@Override
	protected void exibirTelaConta() {
		TelaConta tela = new TelaConta();
		tela.setVisible(true);
		this.dispose();
	}
	
}

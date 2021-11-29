package com.banco.ui;

import com.banco.util.ObjectHandle;

public class TelaConta extends TelaContaLay {

	private static final long serialVersionUID = 1L;

	@Override
	protected void exibirTelaTransferencia() {
		TelaTransferencia tela = new TelaTransferencia();
		tela.setVisible(true);
		this.dispose();
	}

	@Override
	protected void carregarDadosContaLogada() {
		lblAgencia.setText(ObjectHandle.getContaLogada().getAgencia());
		lblNumConta.setText(ObjectHandle.getContaLogada().getNumero().toString());
		lblNome.setText(ObjectHandle.getContaLogada().getTitular().getNomeCompleto());
		lblSaldo.setText(ObjectHandle.getContaLogada().getSaldo().toString());
	}

	@Override
	protected void exibirTelaLogin() {
		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);
		this.dispose();
	}

}

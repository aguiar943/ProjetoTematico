package com.banco.database.bo.impl;

import java.sql.SQLException;
import java.util.List;

import com.banco.database.dao.ContaCorrenteDAO;
import com.banco.entidades.ContaCorrente;

public class ContaCorrenteBoImpl {

	public ContaCorrente buscarContaPorUsuario(String username) throws SQLException {
		ContaCorrenteDAO dao = new ContaCorrenteDAO();
		List<ContaCorrente> lst = dao.selectPorCampoString("co_usuario", username);
		if (!lst.isEmpty()) {
			return lst.get(0);
		}
		return null;
	}

	public ContaCorrente buscarPorNumero(Integer numero) throws SQLException {
		ContaCorrenteDAO dao = new ContaCorrenteDAO();
		List<ContaCorrente> lst = dao.selectPorCampoNumerico("co_num_conta", numero);
		if (!lst.isEmpty()) {
			return lst.get(0);
		}
		return null;
	}

	public Integer getClientId(Integer numConta) throws SQLException {
		ContaCorrenteDAO dao = new ContaCorrenteDAO();
		return dao.getClientId(numConta);
	}

	public void cadastrarConta(ContaCorrente conta) {
		ContaCorrenteDAO dao = new ContaCorrenteDAO();
		dao.cadastrarConta(conta);
	}
	
	public void atualizarSaldo(Integer numConta, Double valor) {
		ContaCorrenteDAO dao = new ContaCorrenteDAO();
		dao.atualizarCampo(numConta, valor);
	}
}

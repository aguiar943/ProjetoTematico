package com.banco.database.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.banco.database.dao.ContaCorrenteDAO;
import com.banco.entidades.ContaCorrente;

public class ContaCorrenteBO {

	public ContaCorrente buscarContaPorUsuario(String username) throws SQLException {
		ContaCorrenteDAO dao = new ContaCorrenteDAO();
		ArrayList<ContaCorrente> lst = dao.selectPorCampoString("co_usuario", username);
		if (lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}

	public ContaCorrente buscarPorNumero(Integer numero) throws SQLException {
		ContaCorrenteDAO dao = new ContaCorrenteDAO();
		ArrayList<ContaCorrente> lst = dao.selectPorCampoNumerico("co_num_conta", numero);
		if (lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}
	
	public void cadastrarConta(ContaCorrente conta) {
		ContaCorrenteDAO dao = new ContaCorrenteDAO();
		dao.cadastrarConta(conta);
	}
}

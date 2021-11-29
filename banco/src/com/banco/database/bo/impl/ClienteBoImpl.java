package com.banco.database.bo.impl;

import java.sql.SQLException;
import java.util.List;

import com.banco.database.bo.ClienteBO;
import com.banco.database.dao.ClienteDAO;
import com.banco.entidades.Cliente;

public class ClienteBoImpl implements ClienteBO {

	@Override
	public Cliente buscarPorEmail(String email) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		List<Cliente> lst = dao.selectPorCampo("cl_email", email);

		if (!lst.isEmpty()) {
			return lst.get(0);
		}
		return null;
	}

	@Override
	public Cliente buscarPorCpf(String cpf) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		List<Cliente> lst = dao.selectPorCampo("cl_cpf", cpf);

		if (!lst.isEmpty()) {
			return lst.get(0);
		}
		return null;
	}

	@Override
	public Cliente buscarPorTelefone(String telefone) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		List<Cliente> lst = dao.selectPorCampo("cl_telefone", telefone);

		if (!lst.isEmpty()) {
			return lst.get(0);
		}
		return null;
	}

	@Override
	public Cliente buscarPorId(Integer id) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		List<Cliente> lst = dao.selectPorCampoNumerico("cl_id", id);

		if (!lst.isEmpty()) {
			return lst.get(0);
		}
		return null;
	}

	@Override
	public Cliente buscarPorObjeto(Cliente cliente) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		List<Cliente> lst = dao.selectPorObjeto(cliente);

		if (!lst.isEmpty()) {
			return lst.get(0);
		}
		return null;
	}

	@Override
	public void cadastrarCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		dao.cadastrarCliente(cliente);
	}

	@Override
	public Integer getNextId() throws SQLException {
		ClienteDAO dao = new ClienteDAO();
		return dao.selectMaxId("cl_id") + 1;
	}

}

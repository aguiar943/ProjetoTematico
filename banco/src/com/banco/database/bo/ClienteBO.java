package com.banco.database.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.banco.database.dao.ClienteDAO;
import com.banco.entidades.Cliente;

public class ClienteBO {

	public Cliente buscarPorEmail(String email) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		ArrayList<Cliente> lst = dao.selectPorCampo("cl_email", email);

		if (lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}

	public Cliente buscarPorCpf(String cpf) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		ArrayList<Cliente> lst = dao.selectPorCampo("cl_cpf", cpf);

		if (lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}

	public Cliente buscarPorTelefone(String telefone) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		ArrayList<Cliente> lst = dao.selectPorCampo("cl_telefone", telefone);

		if (lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}

	public Cliente buscarPorId(Integer id) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		ArrayList<Cliente> lst = dao.selectPorCampoNumerico("cl_id", id);

		if (lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}

	public Cliente buscarPorObjeto(Cliente cliente) throws SQLException {
		ClienteDAO dao = new ClienteDAO();

		ArrayList<Cliente> lst = dao.selectPorObjeto(cliente);

		if (lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}

	public void cadastrarCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		dao.cadastrarCliente(cliente);
	}

}

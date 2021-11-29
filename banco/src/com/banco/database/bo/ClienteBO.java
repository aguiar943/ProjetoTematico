package com.banco.database.bo;

import java.sql.SQLException;

import com.banco.entidades.Cliente;

public interface ClienteBO {
	public Cliente buscarPorEmail(String email) throws SQLException;

	public Cliente buscarPorCpf(String cpf) throws SQLException;

	public Cliente buscarPorTelefone(String telefone) throws SQLException;

	public Cliente buscarPorId(Integer id) throws SQLException;

	public Cliente buscarPorObjeto(Cliente cliente) throws SQLException;

	public void cadastrarCliente(Cliente cliente);

	public Integer getNextId() throws SQLException;
}

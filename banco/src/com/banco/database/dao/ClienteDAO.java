package com.banco.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.banco.database.DbConnection;
import com.banco.entidades.Cliente;

public class ClienteDAO {

	private final String TABLE_NAME = "BA_CLIENTES";

	/**
	 * Seleciona todos os registros da tabela
	 * 
	 * @return ArrayList<Clientes>
	 * @throws SQLException
	 */
	public ArrayList<Cliente> selectAll() throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		ResultSet results = conn.query("select * from ba_clientes");
		conn.disconnect();

		ArrayList<Cliente> lstResult = new ArrayList<Cliente>();

		while (results.next()) {
			String nome = results.getString("cl_nome");
			String sobrenome = results.getString("cl_sobrenome");
			String cpf = results.getString("cl_cpf");
			String email = results.getString("cl_email");
			String telefone = results.getString("cl_telefone");
			lstResult.add(new Cliente(nome, sobrenome, cpf, email, telefone));
		}
		return lstResult;
	}

	/**
	 * Recebe como parâmetro uma coluna e um valor. Retorna todos os registros cuja
	 * coluna possuam um determinado valor
	 * 
	 * @return ArrayList<Clientes>
	 * @throws SQLException
	 */
	public ArrayList<Cliente> selectPorCampo(String coluna, String value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append(" FROM " + TABLE_NAME);
		query.append(" WHERE  " + coluna + " = '" + value + "'");
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<Cliente> lstResult = new ArrayList<Cliente>();

		while (results.next()) {
			Integer id = results.getInt("cl_id");
			String nome = results.getString("cl_nome");
			String sobrenome = results.getString("cl_sobrenome");
			String cpf = results.getString("cl_cpf");
			String email = results.getString("cl_email");
			String telefone = results.getString("cl_telefone");
			lstResult.add(new Cliente(id, nome, sobrenome, cpf, email, telefone));
		}
		return lstResult;
	}

	public ArrayList<Cliente> selectPorCampoNumerico(String coluna, Integer value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuffer query = new StringBuffer();
		query.append("SELECT *");
		query.append(" FROM" + TABLE_NAME);
		query.append(" WHERE " + coluna + " = " + value);
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<Cliente> lstResult = new ArrayList<Cliente>();

		while (results.next()) {
			String nome = results.getString("cl_nome");
			String sobrenome = results.getString("cl_sobrenome");
			String cpf = results.getString("cl_cpf");
			String email = results.getString("cl_email");
			String telefone = results.getString("cl_telefone");
			lstResult.add(new Cliente(nome, sobrenome, cpf, email, telefone));
		}
		return lstResult;
	}

	public ArrayList<Cliente> selectPorObjeto(Cliente cliente) throws SQLException {

		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM " + TABLE_NAME);
		query.append("WHERE cl_nome = '" + cliente.getNome() + "'");
		query.append("AND cl_sobrenome = '" + cliente.getSobrenome() + "'");
		query.append("AND cl_cpf = '" + cliente.getCpf() + "'");
		query.append("AND cl_email = '" + cliente.getEmail() + "'");
		query.append("AND cl_telefone = '" + cliente.getTelefone() + "'");
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<Cliente> lstResult = new ArrayList<Cliente>();

		while (results.next()) {
			Integer id = results.getInt("cl_id");
			String nome = results.getString("cl_nome");
			String sobrenome = results.getString("cl_sobrenome");
			String cpf = results.getString("cl_cpf");
			String email = results.getString("cl_email");
			String telefone = results.getString("cl_telefone");
			lstResult.add(new Cliente(id, nome, sobrenome, cpf, email, telefone));
		}
		return lstResult;
	}

	public void cadastrarCliente(Cliente cliente) {
		String nome = "'" + cliente.getNome() + "'";
		String sobrenome = "'" + cliente.getSobrenome() + "'";
		String cpf = "'" + cliente.getCpf() + "'";
		String email = "'" + cliente.getEmail() + "'";
		String telefone = "'" + cliente.getTelefone() + "'";
		DbConnection conn = new DbConnection();
		conn.connect();

		StringBuffer query = new StringBuffer();
		query.append("insert into " + TABLE_NAME);
		query.append("(cl_nome, cl_sobrenome, cl_cpf, cl_email, cl_telefone) ");
		query.append("values (");
		query.append(nome + ", ");
		query.append(sobrenome + ", ");
		query.append(cpf + ", ");
		query.append(email + ", ");
		query.append(telefone);
		query.append(")");

		conn.insert(query.toString());
		conn.disconnect();
	}
}

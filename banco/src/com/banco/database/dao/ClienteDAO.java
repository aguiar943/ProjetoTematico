package com.banco.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banco.database.DbConnection;
import com.banco.entidades.Cliente;

public class ClienteDAO {

	private static final String TABLE_NAME = "BA_CLIENTES";
	private static final String COLUNA_ID = "cl_id";
	private static final String COLUNA_NOME = "cl_nome";
	private static final String COLUNA_SOBRENOME = "cl_sobrenome";
	private static final String COLUNA_CPF = "cl_cpf";
	private static final String COLUNA_EMAIL = "cl_email";
	private static final String COLUNA_TELEFONE = "cl_telefone";

	/**
	 * Seleciona todos os registros da tabela
	 * 
	 * @return ArrayList<Clientes>
	 * @throws SQLException
	 */
	public List<Cliente> selectAll() throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM " + TABLE_NAME);
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<Cliente> lstResult = new ArrayList<>();

		while (results.next()) {
			Integer id = results.getInt(COLUNA_ID);
			String nome = results.getString(COLUNA_NOME);
			String sobrenome = results.getString(COLUNA_SOBRENOME);
			String cpf = results.getString(COLUNA_CPF);
			String email = results.getString(COLUNA_EMAIL);
			String telefone = results.getString(COLUNA_TELEFONE);
			lstResult.add(new Cliente(id, nome, sobrenome, cpf, email, telefone));
		}
		return lstResult;
	}

	/**
	 * Recebe como parâmetro uma coluna e um valor. Retorna todos os registros cuja
	 * coluna possuam um determinado valor
	 * 
	 * @return List<Clientes>
	 * @throws SQLException
	 */
	public List<Cliente> selectPorCampo(String coluna, String value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append(" FROM " + TABLE_NAME);
		query.append(" WHERE  " + coluna + " = '" + value + "'");
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<Cliente> lstResult = new ArrayList<>();

		while (results.next()) {
			Integer id = results.getInt(COLUNA_ID);
			String nome = results.getString(COLUNA_NOME);
			String sobrenome = results.getString(COLUNA_SOBRENOME);
			String cpf = results.getString(COLUNA_CPF);
			String email = results.getString(COLUNA_EMAIL);
			String telefone = results.getString(COLUNA_TELEFONE);
			lstResult.add(new Cliente(id, nome, sobrenome, cpf, email, telefone));
		}
		return lstResult;
	}

	public List<Cliente> selectPorCampoNumerico(String coluna, Integer value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuilder query = new StringBuilder();
		query.append("SELECT *");
		query.append(" FROM " + TABLE_NAME);
		query.append(" WHERE " + coluna + " = " + value);
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<Cliente> lstResult = new ArrayList<>();

		while (results.next()) {
			Integer id = results.getInt(COLUNA_ID);
			String nome = results.getString(COLUNA_NOME);
			String sobrenome = results.getString(COLUNA_SOBRENOME);
			String cpf = results.getString(COLUNA_CPF);
			String email = results.getString(COLUNA_EMAIL);
			String telefone = results.getString(COLUNA_TELEFONE);
			lstResult.add(new Cliente(id, nome, sobrenome, cpf, email, telefone));
		}
		return lstResult;
	}

	public List<Cliente> selectPorObjeto(Cliente cliente) throws SQLException {

		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM " + TABLE_NAME);
		query.append("WHERE " + COLUNA_NOME + " = '" + cliente.getNome() + "'");
		query.append("AND " + COLUNA_SOBRENOME + "' = '" + cliente.getSobrenome() + "'");
		query.append("AND cl_cpf = '" + cliente.getCpf() + "'");
		query.append("AND cl_email = '" + cliente.getEmail() + "'");
		query.append("AND cl_telefone = '" + cliente.getTelefone() + "'");
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<Cliente> lstResult = new ArrayList<>();

		while (results.next()) {
			Integer id = results.getInt(COLUNA_ID);
			String nome = results.getString(COLUNA_NOME);
			String sobrenome = results.getString(COLUNA_SOBRENOME);
			String cpf = results.getString(COLUNA_CPF);
			String email = results.getString(COLUNA_EMAIL);
			String telefone = results.getString(COLUNA_TELEFONE);
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

		StringBuilder query = new StringBuilder();
		query.append("insert into " + TABLE_NAME);
		query.append("(cl_nome, cl_sobrenome, cl_cpf, cl_email, cl_telefone) ");
		query.append("values (");
		query.append(nome + ", ");
		query.append(sobrenome + ", ");
		query.append(cpf + ", ");
		query.append(email + ", ");
		query.append(telefone);
		query.append(")");

		conn.saveOrUpdate(query.toString());
		conn.disconnect();
	}

	public Integer selectMaxId(String col) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuilder query = new StringBuilder();
		query.append("SELECT MAX(" + col + ") ");
		query.append("FROM " + TABLE_NAME);
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		Integer id = null;
		while (results.next()) {
			id = results.getInt("max");
		}
		return id;
	}
}

package com.banco.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banco.database.DbConnection;
import com.banco.entidades.ContaCorrente;

public class ContaCorrenteDAO {

	private static final String TABLE_NAME = "BA_CONTAS";
	private static final String COLUNA_NUM_CONTA = "CO_NUM_CONTA";
	private static final String COLUNA_AGENCIA = "CO_AGENCIA";
	private static final String COLUNA_SALDO = "CO_SALDO";
	private static final String COLUNA_USUARIO = "CO_USUARIO";
	private static final String COLUNA_SENHA = "CO_SENHA";
	private static final String COLUNA_ID_CLIENTE = "CO_ID_CLIENTE";

	public List<ContaCorrente> selectAll() throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		ResultSet results = conn.query("select * from " + TABLE_NAME);
		conn.disconnect();

		ArrayList<ContaCorrente> lstResult = new ArrayList<>();
		while (results.next()) {
			Integer numero = results.getInt(COLUNA_NUM_CONTA);
			String agencia = results.getString(COLUNA_AGENCIA);
			Double saldo = results.getDouble(COLUNA_SALDO);
			String usuario = results.getString(COLUNA_USUARIO);
			String senha = results.getString(COLUNA_SENHA);
			lstResult.add(new ContaCorrente(numero, agencia, saldo, usuario, senha));
		}
		return lstResult;
	}

	public List<ContaCorrente> selectPorCampoString(String coluna, String value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuilder query = new StringBuilder();
		query.append("SELECT *");
		query.append(" FROM " + TABLE_NAME);
		query.append(" WHERE " + coluna + " = '" + value + "'");
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<ContaCorrente> lstResult = new ArrayList<>();

		while (results.next()) {
			Integer numero = results.getInt(COLUNA_NUM_CONTA);
			String agencia = results.getString(COLUNA_AGENCIA);
			Double saldo = results.getDouble(COLUNA_SALDO);
			String usuario = results.getString(COLUNA_USUARIO);
			String senha = results.getString(COLUNA_SENHA);
			lstResult.add(new ContaCorrente(numero, agencia, saldo, usuario, senha));
		}
		return lstResult;
	}

	public List<ContaCorrente> selectPorCampoNumerico(String coluna, Integer value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuilder query = new StringBuilder();
		query.append("SELECT *");
		query.append(" FROM " + TABLE_NAME);
		query.append(" WHERE " + coluna + " = " + value);
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<ContaCorrente> lstResult = new ArrayList<>();

		while (results.next()) {
			Integer numero = results.getInt(COLUNA_NUM_CONTA);
			String agencia = results.getString(COLUNA_AGENCIA);
			Double saldo = results.getDouble(COLUNA_SALDO);
			String usuario = results.getString(COLUNA_USUARIO);
			String senha = results.getString(COLUNA_SENHA);
			lstResult.add(new ContaCorrente(numero, agencia, saldo, usuario, senha));
		}
		return lstResult;
	}

	public void cadastrarConta(ContaCorrente conta) {
		String agencia = "'" + conta.getAgencia() + "'";
		Integer numero = conta.getNumero();
		Double saldo = conta.getSaldo();
		String usuario = "'" + conta.getUsuario() + "'";
		String senha = "'" + conta.getSenha() + "'";
		String dataAbertura = "'" + conta.getDataAbertura() + "'";
		Integer idCliente = conta.getTitular().getId();
		DbConnection conn = new DbConnection();
		conn.connect();

		StringBuilder querry = new StringBuilder();
		querry.append("insert into " + TABLE_NAME);
		querry.append("(co_agencia, co_num_conta, co_saldo, co_usuario, co_senha, co_data_abertura, co_id_cliente) ");
		querry.append("values (");
		querry.append(agencia + ", ");
		querry.append(numero + ", ");
		querry.append(saldo + ", ");
		querry.append(usuario + ", ");
		querry.append(senha + ", ");
		querry.append(dataAbertura + ", ");
		querry.append(idCliente);
		querry.append(")");

		conn.saveOrUpdate(querry.toString());
		conn.disconnect();
	}

	public Integer getClientId(Integer numConta) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuilder query = new StringBuilder();
		query.append("SELECT " + COLUNA_ID_CLIENTE);
		query.append(" FROM " + TABLE_NAME + " ");
		query.append("WHERE co_num_conta = " + numConta);
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		Integer id = null;
		while (results.next()) {
			id = results.getInt(COLUNA_ID_CLIENTE);
		}
		return id;
	}

	public void atualizarCampo(Integer numConta, Double valor) {
		DbConnection conn = new DbConnection();
		conn.connect();

		StringBuilder querry = new StringBuilder();
		querry.append("UPDATE " + TABLE_NAME);
		querry.append(" SET " + COLUNA_SALDO + " = " + valor);
		querry.append(" WHERE " + COLUNA_NUM_CONTA + " = " + numConta);
		conn.saveOrUpdate(querry.toString());
		conn.disconnect();

	}
}

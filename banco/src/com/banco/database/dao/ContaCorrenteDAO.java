package com.banco.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.banco.database.DbConnection;
import com.banco.entidades.ContaCorrente;

public class ContaCorrenteDAO {

	private final String TABLE_NAME = "BA_CONTAS";

	public ArrayList<ContaCorrente> selectAll() throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		ResultSet results = conn.query("select * from " + TABLE_NAME);
		conn.disconnect();

		ArrayList<ContaCorrente> lstResult = new ArrayList<ContaCorrente>();
		while (results.next()) {
			Integer numero = results.getInt("co_num_conta");
			String agencia = results.getString("co_agencia");
			Double saldo = results.getDouble("co_saldo");
			String usuario = results.getString("co_usuario");
			String senha = results.getString("co_senha");
			lstResult.add(new ContaCorrente(numero, agencia, saldo, usuario, senha));
		}
		return lstResult;
	}

	public ArrayList<ContaCorrente> selectPorCampoString(String coluna, String value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuffer query = new StringBuffer();
		query.append("SELECT *");
		query.append(" FROM " + TABLE_NAME);
		query.append(" WHERE " + coluna + " = '" + value + "'");
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<ContaCorrente> lstResult = new ArrayList<ContaCorrente>();

		while (results.next()) {
			Integer numero = results.getInt("co_num_conta");
			String agencia = results.getString("co_agencia");
			Double saldo = results.getDouble("co_saldo");
			String usuario = results.getString("co_usuario");
			String senha = results.getString("co_senha");
			lstResult.add(new ContaCorrente(numero, agencia, saldo, usuario, senha));
		}
		return lstResult;
	}

	public ArrayList<ContaCorrente> selectPorCampoNumerico(String coluna, Integer value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		StringBuffer query = new StringBuffer();
		query.append("SELECT *");
		query.append(" FROM " + TABLE_NAME);
		query.append(" WHERE " + coluna + " = " + value);
		System.out.println(query);
		ResultSet results = conn.query(query.toString());
		conn.disconnect();

		ArrayList<ContaCorrente> lstResult = new ArrayList<ContaCorrente>();

		while (results.next()) {
			Integer numero = results.getInt("co_num_conta");
			String agencia = results.getString("co_agencia");
			Double saldo = results.getDouble("co_saldo");
			String usuario = results.getString("co_usuario");
			String senha = results.getString("co_senha");
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

		StringBuffer querry = new StringBuffer();
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

		conn.insert(querry.toString());
		conn.disconnect();
	}
}

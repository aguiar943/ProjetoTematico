package com.banco.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.banco.database.DbConnection;
import com.banco.entidades.Endereco;

public class EnderecoDAO {

	private final String PRIMARY_KEY = "cod_endereco";

	public EnderecoDAO() {

	}

	public ArrayList<Endereco> selectAll() throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		ResultSet results = conn.query("select * from ba_enderecos");
		conn.disconnect();

		ArrayList<Endereco> lstResult = new ArrayList<Endereco>();

		while (results.next()) {
			String rua = results.getString("en_rua");
			String bairro = results.getString("en_bairro");
			String cidade = results.getString("en_cidade");
			String complemento = results.getString("en_complemento");
			String cep = results.getString("en_cep");
			Integer numero = results.getInt("en_numero");
			lstResult.add(new Endereco(rua, bairro, cidade, complemento, cep, numero));
		}
		return lstResult;
	}

	public ArrayList<Endereco> selectPorCampo(String coluna, String value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		value = value.toLowerCase();
		String query = "select * from ba_enderecos where lower(" + coluna + ")" + " = '" + value.toLowerCase() + "'";
		ResultSet results = conn.query(query);
		conn.disconnect();

		ArrayList<Endereco> lstResult = new ArrayList<Endereco>();

		while (results.next()) {
			String rua = results.getString("en_rua");
			String bairro = results.getString("en_bairro");
			String cidade = results.getString("en_cidade");
			String complemento = results.getString("en_complemento");
			String cep = results.getString("en_cep");
			Integer numero = results.getInt("en_numero");
			lstResult.add(new Endereco(rua, bairro, cidade, complemento, cep, numero));
		}
		return lstResult;
	}

	public Endereco selectPorPk(String value) throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		String query = "select * from ba_enderecos where " + PRIMARY_KEY + " = " + value;
		ResultSet results = conn.query(query);
		conn.disconnect();

		Endereco endereco = null;
		while (results.next()) {
			String rua = results.getString("en_rua");
			String bairro = results.getString("en_bairro");
			String cidade = results.getString("en_cidade");
			String complemento = results.getString("en_complemento");
			String cep = results.getString("en_cep");
			Integer numero = results.getInt("en_numero");
			endereco = new Endereco(rua, bairro, cidade, complemento, cep, numero);
		}
		return endereco;
	}

}

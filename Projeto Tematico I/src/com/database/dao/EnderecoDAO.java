package com.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.database.DbConnection;
import com.entidades.Endereco;

public class EnderecoDAO {

	public EnderecoDAO() {

	}

	public ArrayList<Endereco> selectAll() throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		ResultSet results = conn.query("select * from enderecos");
		conn.disconnect();

		ArrayList<Endereco> lstResult = new ArrayList<Endereco>();

		while (results.next()) {
			String rua = results.getString("rua");
			String bairro = results.getString("bairro");
			String cidade = results.getString("cidade");
			String complemento = results.getString("complemento");
			String cep = results.getString("cep");
			Integer numero = results.getInt("numero");
			lstResult.add(new Endereco(rua, bairro, cidade, complemento, cep, numero));
		}
		return lstResult;
	}

}

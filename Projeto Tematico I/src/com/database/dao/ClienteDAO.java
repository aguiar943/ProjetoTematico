package com.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.entidades.Cliente;
import com.database.DbConnection;

public class ClienteDAO {
	
	public ClienteDAO() {
		
	}
	
	public ArrayList<Cliente> selectAll() throws SQLException {
		DbConnection conn = new DbConnection();
		conn.connect();
		ResultSet results = conn.query("select * from clientes");
		conn.disconnect();
		
		ArrayList<Cliente> lstResult = new ArrayList<Cliente>();
		
		while(results.next()) {
//			lstResult.add(new Cliente())
		}
		return lstResult;
	}
}

package com.database;

public class TestConnection {
	public static void main(String[] args) {
		
		String host = "localhost";
		Integer port = 5432;
		String database = "postgres";
		String user = "bank";
		String password = "bank";
		DbConnection conn = new DbConnection(host, port, database, user, password);
		conn.connect();
	}
}

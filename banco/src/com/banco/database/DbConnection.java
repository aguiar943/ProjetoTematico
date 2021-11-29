package com.banco.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	private String host;
	private Integer port;
	private String database;
	private String user;
	private String password;
	private String url;
	private String driverJdbc;
	private Connection connection;
	private Statement statement;

	public DbConnection(String host, Integer port, String database, String user, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.user = user;
		this.password = password;

		this.url = "jdbc:postgresql://" + host + ":" + port + "/" + database;

		this.driverJdbc = "org.postgresql.Driver";
	}

	public DbConnection() {
		this.host = "localhost";
		this.port = 5432;
		this.database = "postgres";
		this.user = "bank";
		this.password = "bank";

		this.url = "jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.database;

		this.driverJdbc = "org.postgresql.Driver";
	}

	public void connect() {
		try {
			Class.forName(this.driverJdbc);
		} catch (ClassNotFoundException e) {
			System.out.println("FALHA AO BUSCAR CLASSE PARA O DRIVER: " + this.driverJdbc);
			System.out.println(e);
			e.printStackTrace();
			return;
		}

		try {
			this.connection = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			System.out.println("Falha ao criar conexão com o banco de dados");
			System.out.println(e);
			e.printStackTrace();
			return;
		}

		try {
			this.statement = this.connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Falha ao criar statement");
			System.out.println(e);
			e.printStackTrace();
			return;
		}
	}

	public void disconnect() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.out.println("Falha ao fechar conexão com o banco de dados");
			e.printStackTrace();
		}
	}

	public ResultSet query(String query) {
		try {
			return this.statement.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Falha ao executar querry");
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}

	public void saveOrUpdate(String query) {
		try {
			this.statement.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Falha ao inserir dados");
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public ResultSet getPks(String tableName) {
		try {
			return this.connection.getMetaData().getPrimaryKeys(tableName, tableName, tableName);
		} catch (SQLException e) {
			System.out.println("Falha ao buscar PKs");
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
}

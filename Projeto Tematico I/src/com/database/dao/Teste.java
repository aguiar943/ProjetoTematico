package com.database.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.entidades.Endereco;

public class Teste {
	public static void main(String[] args) {
		EnderecoDAO dao = new EnderecoDAO();
		ArrayList<Endereco> lst = null;
		try {
			lst = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Endereco endereco : lst) {
			System.out.println("Rua: " + endereco.getRua());
		}
		
	}
}	

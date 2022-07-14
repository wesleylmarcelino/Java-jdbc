package br.com.lojavirtual.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost"
				+ "/loja_virtual?useTimezone=true&serverTimezone=UTC", 
				"root", "995612");
		
		System.out.println("Conectou!!");
		System.out.println("---------------------------------");
		
		Statement stm = connection.createStatement();
		stm.execute("select id, nome, descricao from produto");
		
		ResultSet rst = stm.getResultSet();
		
		while (rst.next()) {
			Integer id = rst.getInt("id");
			System.out.println(id);
			String nome = rst.getString("nome");
			System.out.println(nome);
			String descricao = rst.getString("descricao");
			System.out.println(descricao);
			System.out.println("----------------------------------");
		}
		
		connection.close();
		
		System.out.println("Conexão fechada!");
	}
}

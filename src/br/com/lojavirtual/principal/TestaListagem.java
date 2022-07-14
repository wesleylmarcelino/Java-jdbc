package br.com.lojavirtual.principal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.lojavirtual.conexaoDB.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
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

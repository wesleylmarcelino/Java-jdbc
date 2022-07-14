package br.com.lojavirtual.principal;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.lojavirtual.conexaoDB.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		System.out.println("Conectou!!");
		
		connection.close();
		
		System.out.println("Conexão fechada!");
	}
}

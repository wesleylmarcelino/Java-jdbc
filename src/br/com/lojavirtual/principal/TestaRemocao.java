package br.com.lojavirtual.principal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.lojavirtual.conexaoDB.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("delete from produto where id > 2");
		
		Integer linhasAfetadas = stm.getUpdateCount();
		
		System.out.println("Total de linhas afetadas: " + linhasAfetadas);
		
		connection.close();
	}
}

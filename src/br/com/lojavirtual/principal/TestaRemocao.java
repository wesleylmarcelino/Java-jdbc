package br.com.lojavirtual.principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.lojavirtual.conexaoDB.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		PreparedStatement stm = connection.prepareStatement("delete from produto where id > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasAfetadas = stm.getUpdateCount();
		
		System.out.println("Total de linhas afetadas: " + linhasAfetadas);
		
		connection.close();
	}
}

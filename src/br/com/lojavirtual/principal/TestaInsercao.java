package br.com.lojavirtual.principal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.lojavirtual.conexaoDB.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		Statement stm = connection.createStatement(); 
		stm.execute("insert into produto (nome, descricao) values('mouse', 'mouse sem fio')"
				, Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("Produto com o id " + id + " gravado!");
		}
		
		connection.close();
	}
}

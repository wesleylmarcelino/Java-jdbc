package br.com.lojavirtual.principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.lojavirtual.conexaoDB.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		//tratativa de sql injection
		
		
		String nome = "mouse";
		String descricao = "mouse sem fio";
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		PreparedStatement stm = connection.prepareStatement("insert into produto (nome, descricao) values(?, ?)",
				Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("Produto com o id " + id + " gravado!");
		}
		
		connection.close();
	}
}

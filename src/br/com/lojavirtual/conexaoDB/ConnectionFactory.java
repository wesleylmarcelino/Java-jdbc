package br.com.lojavirtual.conexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Factory Pattern
public class ConnectionFactory {

	public Connection recuperaConexao() throws SQLException {
		
		return DriverManager.getConnection("jdbc:mysql://localhost"
				+ "/loja_virtual?useTimezone=true&serverTimezone=UTC", 
				"root", "995612");	
	}
	
}

package br.com.mariojp.sqlclient.negocio;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Banco {
	

	private Connection connection;

	

	public Banco(Configuracao configuracao) {
		try {
			Class.forName(configuracao.getDriver());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(configuracao.getUrl(),configuracao.getUsuario(),
					configuracao.getSenha());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		



	}



	public Connection getConnection() {
		return connection;
	}
	
	
	

	
}

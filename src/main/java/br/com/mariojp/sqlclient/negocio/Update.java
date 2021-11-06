package br.com.mariojp.sqlclient.negocio;

import java.sql.SQLException;
import java.sql.Statement;

public class Update extends Command{

	@Override
	public String executar(Statement statement, String sql) throws SQLException {
		int numero = statement.executeUpdate(sql);
		statement.closeOnCompletion();
		return numero+"";
	}

}

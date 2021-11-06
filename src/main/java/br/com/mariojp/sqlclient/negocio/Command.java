package br.com.mariojp.sqlclient.negocio;

import java.sql.SQLException;
import java.sql.Statement;

public abstract class Command {
	
	public abstract String executar(Statement statement, String sql) throws SQLException;
}

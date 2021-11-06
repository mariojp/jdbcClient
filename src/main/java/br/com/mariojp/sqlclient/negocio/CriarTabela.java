package br.com.mariojp.sqlclient.negocio;

import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela extends Command{

	@Override
	public String executar(Statement statement, String sql) throws SQLException {
		Boolean boleano = statement.execute(sql);
		statement.closeOnCompletion();
		return !boleano+"";
	}

}

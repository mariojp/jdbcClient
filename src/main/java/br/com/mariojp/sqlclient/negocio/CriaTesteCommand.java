package br.com.mariojp.sqlclient.negocio;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Command Concreto
 * @author mariojp
 *
 */
public class CriaTesteCommand extends Command {

	@Override
	public String executar(Statement statement, String sql) throws SQLException {
		CriarTabela cria = new CriarTabela();
		return cria.executar(statement, "CREATE TABLE TESTE (ID INT PRIMARY KEY, NAME VARCAHAR(50))");
	}

	
}

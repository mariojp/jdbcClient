package br.com.mariojp.sqlclient.negocio;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta extends Command {

	@Override
	public String executar(Statement stmt, String sql) throws SQLException {
		
		StringBuilder resultado = new StringBuilder();
		
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int quantidade = rsmd.getColumnCount();
		
		String[] colunas = new String[quantidade];
		
		for (int i = 0; i < quantidade; i++) {
			colunas[i] = rsmd.getColumnLabel(i+1);
			resultado.append(colunas[i]);
			resultado.append("\t \t");
		}

		resultado.append("\n");
		while(rs.next()) {
			for (String nome : colunas) {
				String coluna = rs.getString(nome);
				resultado.append(coluna);
				resultado.append("\t \t");
			}
			resultado.append("\n");
		}
		
		return resultado.toString();
	}

}

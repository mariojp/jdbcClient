package br.com.mariojp.sqlclient.negocio;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
	
		//Invoker
		private Map<String,Command> storeComandos;
	
		private Banco banco;
		
		
		
		public Invoker(Banco banco) {
			this.banco = banco;
			storeComandos= new HashMap<>();
			storeComandos.put("SELECT", new Consulta());
			storeComandos.put("CREATE", new CriarTabela());
			storeComandos.put("UPDATE", new Update());
			storeComandos.put("TESTE", new CriaTesteCommand());
		}




		public String executar(String sql) {

			String[] commados = sql.toUpperCase().split(" ");
			
			Command comando = this.storeComandos.getOrDefault(
					commados[0], 
					this.storeComandos.get("CREATE"));

			
			String retorno = "";
			try {
				retorno = comando.executar(banco.getConnection().createStatement(), sql);	
			} catch (Exception sqlErro) {
				sqlErro.printStackTrace();
				retorno = sqlErro.getMessage();
			}
			
			return retorno;

		}

}

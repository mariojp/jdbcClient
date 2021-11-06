package br.com.mariojp.sqlclient;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JFrame;

import br.com.mariojp.sqlclient.negocio.Configuracao;
import br.com.mariojp.sqlclient.view.ConfiguracaoPanel;
import br.com.mariojp.sqlclient.view.TelaConsulta;

public class JSQLClient {

	
	
	public static void main(String[] args) {
		ConfiguracaoPanel configuracao = new ConfiguracaoPanel();
		configuracao.setVisible(true);
		
	}
}

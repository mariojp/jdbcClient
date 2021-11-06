package br.com.mariojp.sqlclient.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet.ColorAttribute;

import br.com.mariojp.sqlclient.negocio.Configuracao;

public class ConfiguracaoPanel extends JFrame{
	
	private Configuracao configuracao = new Configuracao();
	
	public Configuracao getConfiguracao() {
		return configuracao;
	}

	private JLabel url = new JLabel("URL:",SwingConstants.RIGHT);
	private JLabel usuario = new JLabel("Usuario:",SwingConstants.RIGHT);
	private JLabel senha = new JLabel("Senha:",SwingConstants.RIGHT);
	private JLabel driver = new JLabel("Driver:",SwingConstants.RIGHT);
	
	private JTextField urlText = new JTextField(20);
	private JTextField usuarioText = new JTextField(20);
	private JTextField senhaText = new JTextField(20);
	private JTextField driverText = new JTextField(20);
	
	private JPanel grid = new JPanel(new GridLayout(5,2));
	
	private JButton confirmar = new JButton("Confirmar");
	private JButton cancelar = new JButton("Cancelar");

	public ConfiguracaoPanel() {
		super("Configuracões");
		setLayout(new FlowLayout());
		
		setResizable(false);
		
		this.setSize(400,400);
		grid.add(url);
		grid.add(urlText);
		//urlText.setText("jdbc:hsqldb:mem:.;get_column_name=false");
		urlText.setText("jdbc:hsqldb:mem:.");

		grid.add(usuario);

		grid.add(usuarioText);
		usuarioText.setText("SA");
		
		grid.add(senha);

		grid.add(senhaText);
		senhaText.setText("");
		grid.add(driver);

		grid.add(driverText);
		driverText.setText("org.hsqldb.jdbc.JDBCDriver");
		
		grid.add(cancelar);
		grid.add(confirmar);
		
		
		this.add(grid);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		
		confirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				configuracao.setUrl(urlText.getText());
				configuracao.setUsuario(usuarioText.getText());
				configuracao.setSenha(senhaText.getText());
				configuracao.setDriver(driverText.getText());
				setVisible(false);
				TelaConsulta janela = new TelaConsulta(configuracao);
				janela.setVisible(true);
			}
			
		});
		
		
		this.pack(); 
		
	}
	
	
	
	
	
}

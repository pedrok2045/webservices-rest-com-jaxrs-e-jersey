package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import junit.framework.Assert;

public class ClienteTest {
	private HttpServer servidor;
	private WebTarget target;
	
	@Before
	public void before(){
		servidor = Servidor.iniciaServidor();
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		
		Client client = ClientBuilder.newClient();
		target = client.target("http://localhost:80/");
	}
	
	@After
	public void After(){
		servidor.stop();
	}
	
	
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado(){
		
		Carrinho conteudo = target.path("carrinhos/1").request().get(Carrinho.class);
			Assert.assertEquals("Jogo de esporte",conteudo.getProdutos().get(1).getNome());
	}
}

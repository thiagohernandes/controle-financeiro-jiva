package jiva.com.tdd;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import jiva.com.domain.Lancamento;

/**
 * Controller Testes
 * @author Thiago Hernandes de Souza
 * @since 21-04-2018
 * */

public class LancamentoControllerTestes {
	
	private static final String URL_BASE = "http://localhost:8080/controle-financeiro-jiva/rest/lancamentos";
	private Lancamento lancamentoMock; 
	private Lancamento lancamentoMockAlterar; 
	private Lancamento lancamentoMockExcluir; 
	
	
	@Before
	public void init() {
		this.lancamentoMock = new Lancamento(1,"Teste Mock",new Date(),1478.9,"R");
		this.lancamentoMockAlterar = new Lancamento(2,"Teste Mock",new Date(),17.77,"D");
		this.lancamentoMockExcluir = new Lancamento(3);
	}
	
    @Test
    public void todosFuncionarios() throws Exception {
    	Client client = ClientBuilder.newClient(); 
		WebTarget target = client.target(URL_BASE+"/todos");
 	    Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get(); 
		assertEquals(200, response.getStatus());
    }
    
    @Test
    public void novoFuncionario() {
    	Client client = ClientBuilder.newClient(); 
		WebTarget target = client.target(URL_BASE+"/novo");
 	    Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(this.lancamentoMock, MediaType.APPLICATION_JSON));
		assertEquals(200, response.getStatus());
    }
    
    @Test
    public void alterarFuncionario() {
    	Client client = ClientBuilder.newClient(); 
		WebTarget target = client.target(URL_BASE+"/alterar");
 	    Invocation.Builder invocationBuilder = target.request();
 	    this.lancamentoMockAlterar.setDescricao("alterada mock");
		Response response = invocationBuilder.put(Entity.entity(this.lancamentoMockAlterar, MediaType.APPLICATION_JSON));
		assertEquals(200, response.getStatus());
    }
    
    @Test
    public void excluirFuncionario() {
    	Client client = ClientBuilder.newClient(); 
		WebTarget target = client.target(URL_BASE+"/excluir/"+this.lancamentoMockExcluir.getId());
		Invocation.Builder invocationBuilder = target.request();
		Response response = invocationBuilder.delete(); 
		assertEquals(200, response.getStatus());
    }
    
    @Test
    public void getFuncionario() {
    	Client client = ClientBuilder.newClient(); 
		WebTarget target = client.target(URL_BASE+"/"+this.lancamentoMock.getId());
 	    Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get(); 
		assertEquals(200, response.getStatus());
    }
    
}

package jiva.com.tdd;

import jiva.com.dao.LancamentoDAO;
import jiva.com.domain.Lancamento;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * DAO Testes
 * @author Thiago Hernandes de Souza
 * @since 20-04-2018
 * */

public class LancamentoDAOTestes {
	
	@InjectMocks
	private LancamentoDAO lancamentoDAOInjectMocks;
	
    @Mock
    private LancamentoDAO lancamentoDAOMockService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
    @Test
	public void todosLancamentos() {
    	assertThat(lancamentoDAOMockService.getTodosLancamentos(), is(notNullValue()));
	}
    
    @Test
   	public void getLancamento() {
    	when(lancamentoDAOMockService.getLancamento(any(Integer.class))).thenReturn(new Lancamento());
   	}
    
    @Test
   	public void novoLancamento() {
    	when(lancamentoDAOMockService.novoLancamento(any(Lancamento.class))).thenReturn(new Lancamento());
   	}
    
    @Test
   	public void alterarLancamento() {
    	when(lancamentoDAOMockService.alterarLancamento(any(Lancamento.class))).thenReturn(null);
   	}
    
    @Test
   	public void excluirLancamento() {
    	when(lancamentoDAOMockService.excluirLancamento(any(Integer.class))).thenReturn(new Lancamento());
   	}
	
}

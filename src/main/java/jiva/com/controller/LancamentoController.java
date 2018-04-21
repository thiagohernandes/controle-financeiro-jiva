package jiva.com.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jiva.com.dao.LancamentoDAO;
import jiva.com.domain.Lancamento;

/**
 * Controler Lançamentos
 * @author Thiago Hernandes de Souza
 * @since 20-04-2018
 * */

@Component
@Path("/lancamentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LancamentoController {

	@Autowired
    private LancamentoDAO lancamentoDAO;
    
	/**
	 * Todos os lançamentos
	 * @author Thiago Hernandes de Souza
	 * @since 21-04-2018
	 * @return lista de todos os lançamentos
	 * */
    @GET   
    @Path(value = "todos")
    public List<Lancamento> getTodosLancamentos() {
        return lancamentoDAO.getTodosLancamentos();
    }
    
    /**
	 * Lançamento por código
	 * @author Thiago Hernandes de Souza
	 * @since 21-04-2018
	 * @param id/código
	 * @return lançamento
	 * */
    @GET
    @Path("{id}")
    public Lancamento getUser(@PathParam("id") Integer id) {
        return lancamentoDAO.getLancamento(id);
    }
    
    /**
	 * Novo lançamento financeiro
	 * @author Thiago Hernandes de Souza
	 * @since 21-04-2018
	 * @param objeto lançamento
	 * @return lançamento gravado em banco
	 * */
    @POST
    @Path("novo")
    public Lancamento novoLancamento(Lancamento lancamento) {
        return lancamentoDAO.novoLancamento(lancamento);
    }
    
    /**
	 * Alteração de lançamento financeiro
	 * @author Thiago Hernandes de Souza
	 * @since 21-04-2018
	 * @param objeto lançamento
	 * @return lançamento alterado em banco
	 * */
    @PUT
    @Path("alterar")
    public Lancamento updateUser(Lancamento lancamento) {
        return lancamentoDAO.alterarLancamento(lancamento);
    }
    
    /**
	 * Exclusão de lançamento financeiro
	 * @author Thiago Hernandes de Souza
	 * @since 21-04-2018
	 * @param id/código
	 * @return lançamento excluído do banco
	 * */
    @DELETE
    @Path("excluir/{id}")
    public Lancamento deleteUser(@PathParam("id") Integer id) throws Exception {
        return lancamentoDAO.excluirLancamento(id);
    }
}

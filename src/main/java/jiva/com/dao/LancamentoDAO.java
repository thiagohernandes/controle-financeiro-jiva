package jiva.com.dao;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jiva.com.domain.Lancamento;

/**
 * DAO Lançamentos
 * @author Thiago Hernandes de Souza
 * @since 20-04-2018
 * */

@Repository
public class LancamentoDAO {
	
	private static Logger logger = Logger.getLogger(LancamentoDAO.class.getName());
	
	@Autowired
    private SessionFactory sessionFactory;
	
	private static final long HR24 = 24L * 60L * 60L * 1000L;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	/**
	 * Lista de todos os lançamentos
	 * @author Thiago Hernandes de Souza
	 * @since 20-04-2018
	 * @return lista de lançamentos
	 * */
    @Transactional
    public List<Lancamento> getTodosLancamentos() {
    	try {
	        Session session = sessionFactory.getCurrentSession();
	        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Lancamento> criteriaQuery = criteriaBuilder.createQuery(Lancamento.class);
	        Root<Lancamento> from = criteriaQuery.from(Lancamento.class);
	        CriteriaQuery<Lancamento> select = criteriaQuery.select(from);
	        TypedQuery<Lancamento> typedQuery = session.createQuery(select);
	        List<Lancamento> listaLancamentos = typedQuery.getResultList();
	        logger.info("Consulta de lançamentos efetuada com sucesso!");
	        return listaLancamentos;
    	} catch(Exception e) {
    		logger.severe("Problemas na consulta de lançamentos! Erro original--> "+e.getMessage());
    		return null;
    	}
    }
    
	/**
	 * Criação de um novo lançamento financeiro
	 * @author Thiago Hernandes de Souza
	 * @since 20-04-2018
	 * @param objeto lançamento
	 * */
    @Transactional
    public Lancamento novoLancamento(Lancamento lancamento) {
    	try {
    		lancamento.setVencimento(new Date(lancamento.getVencimento().getTime() + HR24));
            sessionFactory.getCurrentSession().save(lancamento);
            logger.info("Sucesso na criação de novo lançamento financeiro!");
            return lancamento;
    	} catch(Exception e) {
    		logger.severe("Problemas na criação de um novo lançamento financeiro! Erro original--> "+e.getMessage());
    		return null;
    	}
    	
    }
    
	/**
	 * Retorno de um lançamento por id
	 * @author Thiago Hernandes de Souza
	 * @since 20-04-2018
	 * @param id
	 * @return objeto lançamento
	 * */
    @Transactional
    public Lancamento getLancamento(Integer id) {
	    try {
	    	Lancamento lancamento = (Lancamento) sessionFactory.getCurrentSession().get(Lancamento.class, id);
	    	logger.info("Sucesso ao obter lançamento financeiro!");
	        return lancamento;
    	} catch(Exception e) {
			logger.severe("Problemas ao obter lançamento financeiro! Erro original--> "+e.getMessage());
			return null;
		}
       
    }
    
	/**
	 * Alteração de dados de lançamento
	 * @author Thiago Hernandes de Souza
	 * @since 20-04-2018
	 * @param objeto lançamento
	 * */
    @Transactional
    public Lancamento alterarLancamento(Lancamento lancamento) {
    	try {
    		lancamento.setVencimento(new Date(lancamento.getVencimento().getTime() + HR24));
            sessionFactory.getCurrentSession().update(lancamento);
            logger.info("Sucesso na alteração de lançamento financeiro!");
            return lancamento;
    	} catch(Exception e) {
    		logger.severe("Problemas na alteração de lançamento financeiro! Erro original--> "+e.getMessage());
    		return null;
    	}
    	
    }
    
	/**
	 * Parse de string to date
	 * @author Thiago Hernandes de Souza
	 * @since 20-04-2018
	 * @param string data
	 * @return data formatada yyyy-MM-dd
	 * */
    @Transactional
    public Lancamento excluirLancamento(Integer id) {
    	try {
	    	Lancamento lancamento = getLancamentoSession(id);
	        sessionFactory.getCurrentSession().delete(lancamento);
	        logger.info("Sucesso na exclusão de lançamento financeiro!");
	        return lancamento;
	    } catch(Exception e) {
			logger.severe("Problemas na exclusão de lançamento financeiro! Erro original--> "+e.getMessage());
			return null;
		}
    }
    
    /**
	 * Lançamento por id
	 * @author Thiago Hernandes de Souza
	 * @since 20-04-2018
	 * @param id do objeto
	 * @return lançamento
	 * */
    private Lancamento getLancamentoSession(Integer id) {
    	try {
    		logger.info("Lançamento financeiro consulta com sucesso na sessão!");
    		return (Lancamento) sessionFactory.getCurrentSession().get(Lancamento.class, id);
    	} catch(Exception e) {
			logger.severe("Problemas na consulta de lançamento financeiro na sessão! Erro original--> "+e.getMessage());
			return null;
		}
    	
    }

}

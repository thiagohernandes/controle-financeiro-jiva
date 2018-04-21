package jiva.com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.logging.Logger;

/**
 * Possíveis métodos utilitários
 * @author Thiago Hernandes de Souza
 * @since 20-04-2018
 * */
public class Util {
	
	private static Logger logger = Logger.getLogger(Util.class.getName());
	
	/**
	 * Parse de string to date
	 * @author Thiago Hernandes de Souza
	 * @since 20-04-2018
	 * @param string data
	 * @return data formatada yyyy-MM-dd
	 * */
	public Date stringToDate(String str){
	     try {
	    	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	         Date data = formatter.parse(str);
	         logger.info("Formatação de string para data efetuada com sucesso!");
	         return data;
	
	     } catch (ParseException e) {
	    	 logger.severe("Problemas na formatação de string para data! Erro original --> "+e.getStackTrace().toString());
	         return null;
	     }
	}
	
}

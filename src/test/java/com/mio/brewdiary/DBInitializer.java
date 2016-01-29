package com.mio.brewdiary;

import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mio.brewdiary.model.Style;
import com.mio.brewdiary.util.AbstractEntries;
import com.mio.brewdiary.util.Styles;
import com.mio.brewdiary.web.EMF;

public class DBInitializer {
	
	static Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	
	public DBInitializer(){
	}

	public static void main(String[] args) {
		System.setProperty("test.dal.mio.pc", "OK");
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		try {
			logger.info("DBInitializer...");
			cleanUp(em);
			initAbstract(em, new Styles());
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("",e);
		}
		em.close();
	}
	
	private static void cleanUp(EntityManager em){
		logger.info("removed {} styles",em.createQuery("delete from Style").executeUpdate());
	}
	
	
	private static void initAbstract(EntityManager em, AbstractEntries entriesClass){
		Map.Entry<Integer, String> pair = null;
		
		Iterator<Map.Entry<Integer, String>> it = entriesClass.entries();
	    while (it.hasNext()) {
	        pair = (Map.Entry<Integer, String>)it.next();
	        Object obj = null;
			try {
				obj = entriesClass.getEntryType().newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				logger.error("error persisting {} : {}", entriesClass.getEntryType().getCanonicalName(),pair.getValue(), e);
			}
	        entriesClass.setter(obj, pair);
	        em.persist(entriesClass);
	        logger.info("persisting {} : {}", entriesClass.getEntryType().getCanonicalName(),pair.getValue());
	    }
	}
	
	
	
	

}

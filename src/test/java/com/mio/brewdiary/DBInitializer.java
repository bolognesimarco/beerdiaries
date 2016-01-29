package com.mio.brewdiary;

import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mio.brewdiary.util.AbstractEntries;
import com.mio.brewdiary.util.HopFormats;
import com.mio.brewdiary.util.HopTypes;
import com.mio.brewdiary.util.MaltTypes;
import com.mio.brewdiary.util.MashPhases;
import com.mio.brewdiary.util.SpiceTypes;
import com.mio.brewdiary.util.Styles;
import com.mio.brewdiary.util.WaterTypes;
import com.mio.brewdiary.util.YeastFormats;
import com.mio.brewdiary.util.YeastTypes;
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
			initAbstract(em, new HopFormats());
			initAbstract(em, new HopTypes());
			initAbstract(em, new MaltTypes());
			initAbstract(em, new MashPhases());
			initAbstract(em, new SpiceTypes());
			initAbstract(em, new WaterTypes());
			initAbstract(em, new YeastFormats());
			initAbstract(em, new YeastTypes());
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("",e);
		}
		em.close();
	}
	
	private static void cleanUp(EntityManager em){
		logger.info("removed {} styles",em.createQuery("delete from Style").executeUpdate());
		logger.info("removed {} hop formats",em.createQuery("delete from HopFormat").executeUpdate());
		logger.info("removed {} hop types",em.createQuery("delete from HopType").executeUpdate());
		logger.info("removed {} malt types",em.createQuery("delete from MaltType").executeUpdate());
		logger.info("removed {} mash phases",em.createQuery("delete from MashPhase").executeUpdate());
		logger.info("removed {} spice types",em.createQuery("delete from SpiceType").executeUpdate());
		logger.info("removed {} yeast formats",em.createQuery("delete from YeastFormat").executeUpdate());
		logger.info("removed {} water types",em.createQuery("delete from WaterType").executeUpdate());
		logger.info("removed {} yeast types",em.createQuery("delete from YeastType").executeUpdate());
	}
	
	
	private static void initAbstract(EntityManager em, AbstractEntries entriesClass){
		Map.Entry<Integer, Object> pair = null;
		
		Iterator<Map.Entry<Integer, Object>> it = entriesClass.entries();
	    while (it.hasNext()) {
	        pair = (Map.Entry<Integer, Object>)it.next();
	        Object obj = null;
			try {
				obj = entriesClass.getEntryType().newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				logger.error("error persisting {} : {}", entriesClass.getEntryType().getCanonicalName(),pair.getValue(), e);
			}
	        entriesClass.setter(obj, pair);
	        em.persist(obj);
	        logger.info("persisting {} : {}", entriesClass.getEntryType().getCanonicalName(),pair.getValue());
	    }
	}
	
	
	
	

}

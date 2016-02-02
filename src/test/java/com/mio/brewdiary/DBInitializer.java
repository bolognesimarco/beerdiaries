package com.mio.brewdiary;

import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mio.brewdiary.model.Hop;
import com.mio.brewdiary.model.HopFormat;
import com.mio.brewdiary.model.HopType;
import com.mio.brewdiary.model.Malt;
import com.mio.brewdiary.model.MaltType;
import com.mio.brewdiary.model.Mash;
import com.mio.brewdiary.model.MashPhase;
import com.mio.brewdiary.model.Recipe;
import com.mio.brewdiary.model.Style;
import com.mio.brewdiary.model.Water;
import com.mio.brewdiary.model.WaterType;
import com.mio.brewdiary.model.Yeast;
import com.mio.brewdiary.model.YeastFormat;
import com.mio.brewdiary.model.YeastType;
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
			
			Recipe winterAle = new Recipe();
			winterAle.setName("winter ale");
			winterAle.setExpectedFG(1022);
			winterAle.setExpectedOG(1064);
			winterAle.setStyle(em.getReference(Style.class, Styles.STYLE_WINTER_ALE));
			winterAle.setMashWater(new Water(21, em.getReference(WaterType.class, WaterTypes.WATER_TYPE_TUB)));
			winterAle.setSparge(new Water(21, em.getReference(WaterType.class, WaterTypes.WATER_TYPE_TUB)));
			winterAle.getMalts().add(new Malt(1570, em.getReference(MaltType.class, MaltTypes.MALT_TYPE_MUNICH)));
			winterAle.getMalts().add(new Malt(520, em.getReference(MaltType.class, MaltTypes.MALT_TYPE_CARA_120)));
			winterAle.getMalts().add(new Malt(1000, em.getReference(MaltType.class, MaltTypes.MALT_TYPE_MARIS_OTTER)));
			winterAle.getMalts().add(new Malt(4100, em.getReference(MaltType.class, MaltTypes.MALT_TYPE_VIENNA)));
			winterAle.getHops().add(new Hop(100, 80, new HopType(HopTypes.HOP_TYPE_SAAZ), new HopFormat(HopFormats.HOP_FORMAT_LEAF)));
			winterAle.setYeast(new Yeast(11.5, new YeastType(YeastTypes.YEAST_TYPE_SAFALE_S04), new YeastFormat(YeastFormats.YEAST_FORMAT_DRY)));
			winterAle.getMashSteps().add(new Mash(65, 60, new MashPhase(MashPhases.MASH_PHASE_SACCARIFICAZIONE)));
			winterAle.getMashSteps().add(new Mash(78, 15, new MashPhase(MashPhases.MASH_PHASE_MASH_OUT)));
			em.persist(winterAle);
			
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

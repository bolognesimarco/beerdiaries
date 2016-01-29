package com.mio.brewdiary.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EMF implements ServletContextListener {

	private static EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
			emf = Persistence.createEntityManagerFactory("BEER_PU");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
        	if(System.getProperty("test.dal.mio.pc")!=null){
        		emf = Persistence.createEntityManagerFactory("BEER_PU");
        	}else{
        		throw new IllegalStateException("Context is not initialized yet.");
        	}
        }

        return emf.createEntityManager();
    }

}

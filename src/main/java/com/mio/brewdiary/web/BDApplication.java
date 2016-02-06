package com.mio.brewdiary.web;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class BDApplication extends ResourceConfig {
	public BDApplication() {
        packages("com.mio.brewdiary.export");
    }
	
}

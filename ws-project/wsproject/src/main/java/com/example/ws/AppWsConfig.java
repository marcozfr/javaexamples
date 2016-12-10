package com.example.ws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Configurable;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("ws")
public class AppWsConfig extends ResourceConfig {
	
	public AppWsConfig(@Context Configurable configurable){
		
		packages("com.example.ws.resource");
		
	}

}

package com.example.ws;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("ws")
public class AppWsConfig extends ResourceConfig {
	
	public AppWsConfig(){
		packages("com.example.ws.resource");
	}

}

package com.example.web.rest.jersey;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("jersey")
public class JerseyAppConfig extends ResourceConfig {

    public JerseyAppConfig(){
        packages("com.example.web.rest.jersey.resource");
    }
}

package com.example.web.rest.jersey;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("jersey")
public class JerseyAppConfig extends ResourceConfig {

    public JerseyAppConfig(){
        packages("com.example.web.rest.jersey.resource","com.example.web.rest.jersey.context");
        
    }
    
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> classes = new HashSet<>();
//        classes.add(CatalogResource.class);
//        classes.add(ProductsResource.class);
//        classes.add(CurrenciesResource.class);
//        classes.add(TestResource.class);
//        return classes;
//    }
    
}

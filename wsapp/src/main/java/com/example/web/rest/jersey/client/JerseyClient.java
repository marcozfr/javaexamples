package com.example.web.rest.jersey.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response.Status;

import com.example.web.model.AppCatalog;

public class JerseyClient {
    
    public static void main(String[] args)  throws Exception{
        Client client = ClientBuilder.newClient();
        AppCatalog  catalog = client.target(URI.create("http://localhost:8180/wsapp/jersey/catalog")).request().get(AppCatalog.class);
        System.out.println(catalog.getBooks());
        //response.close();
        
    }

}

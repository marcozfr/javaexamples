package com.example.web.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/customer")
public class CustomerResource {

    @GET
    @Produces("text/plain")
    public String getCustomer(){
        return "sucess";
    }
    
}

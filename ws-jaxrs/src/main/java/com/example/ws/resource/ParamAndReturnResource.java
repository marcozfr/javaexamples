package com.example.ws.resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/pr")
public class ParamAndReturnResource {

    @Path("/paramconverter")
    @GET
    public Response getData(
            @QueryParam("formatDate") Date date){
        
        return Response.ok(date).build();
    }
    
}

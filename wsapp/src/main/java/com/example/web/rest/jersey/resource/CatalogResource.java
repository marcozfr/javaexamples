package com.example.web.rest.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.model.Resource;

import com.example.web.repository.CatalogRepository;

@Path("catalog")
public class CatalogResource {
    
    @Path("/book")
    public Resource getBookResource(){
        return Resource.from(BookResource.class);
    }
    
    @GET
    @Produces("application/xml")
    public Response getCatalog(){
       return Response.ok(CatalogRepository.getAppCatalog()).build();
    }
    
}

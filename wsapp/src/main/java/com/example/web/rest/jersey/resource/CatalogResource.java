package com.example.web.rest.jersey.resource;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;

import com.example.web.repository.CatalogRepository;

@Path("catalog")
@Singleton // jersey root resources are request scoped by default
public class CatalogResource {
    
    public CatalogResource(){
        System.out.println("Init catalog resource");
    }
    
    @Path("/book")
    public 
    //Resource
    BookResource getBookResource(){
        //return Resource.from(BookResource.class);
        return new BookResource(100);
    }
    
    @GET
    public Response getCatalog(@Context Request request){
        
        List<Variant> accepts = Variant.mediaTypes(MediaType.APPLICATION_XML_TYPE,
                        MediaType.APPLICATION_JSON_TYPE).build();
        
        Variant reqAccept = request.selectVariant(accepts);
        
        if(reqAccept == null) {
            return Response.notAcceptable(accepts).build();
        }
        
        return Response.ok(CatalogRepository.getAppCatalog(),reqAccept).build();
        
//        if(accept!=null){
//            return Response.ok(CatalogRepository.getAppCatalog()).type(accept).build();
//        }
//        else 
//            return Response.ok(CatalogRepository.getAppCatalog()).build();
    }
    
}

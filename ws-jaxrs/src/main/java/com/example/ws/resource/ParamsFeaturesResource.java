package com.example.ws.resource;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.ws.model.Book;
import com.example.ws.model.BookType;

public class ParamsFeaturesResource {

    /**
     * 
     * 
     * @param id
     * @param book sets isbn in an encoded form in single String argument Constructor
     * @param save 
     * @param type works due to valueOf from Enum
     * @return
     */
    @Path("/param-types")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getData(
            @HeaderParam("id") long id,
            @Encoded @QueryParam("book") Book book,
            @DefaultValue("false") @QueryParam("save") boolean save,
            @DefaultValue("COMEDY") @QueryParam("type") BookType type){
        book.setId(id);
        book.setType(type);
        book.setSave(save);
        return Response.ok(book.toString()).build();
    }
    
    @Path("/generic-entity")
    @GET
    public Response getGenericEntity(){
        List<String> supportedContentTypes = Arrays.asList(MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.TEXT_PLAIN);
                
        return Response.ok(new GenericEntity<List<String>>(supportedContentTypes){}).build();
    }

    
    
}


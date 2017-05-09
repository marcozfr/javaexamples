package com.example.ws.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.UriInfo;

import com.example.ws.model.Book;
import com.example.ws.model.BookType;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    
    @Path("headers")
    @GET
    @Produces("application/json")
    public StreamingOutput showHeaders(@Context HttpHeaders headers){
    	
    	return new StreamingOutput(){
    		@Override
    		public void write(OutputStream output) throws IOException, WebApplicationException {
    			try {
    				new ObjectMapper().writeValue(output, headers.getRequestHeaders());
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	};
    }
    
    @Path("form")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postForm(MultivaluedMap<String, String> form){
    	
    	System.out.println(form);
    	
    	return Response.ok("Received data").type(MediaType.TEXT_PLAIN).build();
    }
    
    @Path("uriInfo/{id:\\d+}")
    @GET
    public Response showParamsFromUri(@Context UriInfo uriInfo){
    	
    	MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters(false);

    	System.out.println("key: process ->" + queryParams.get("process"));	

    	MultivaluedMap<String, String> pathParams = uriInfo.getPathParameters(false);

    	System.out.println("key: id ->" + pathParams.get("id"));	

    	return Response.ok("<h2>Path</h2>").type(MediaType.TEXT_HTML).build();
    }
    
    @Path("/generic-entity")
    @GET
    public Response getGenericEntity(){
        List<String> supportedContentTypes = Arrays.asList(MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.TEXT_PLAIN);
                
        return Response.ok(new GenericEntity<List<String>>(supportedContentTypes){}).build();
    }

    
    
}


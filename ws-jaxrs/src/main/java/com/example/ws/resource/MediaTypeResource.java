package com.example.ws.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;

import com.example.ws.model.Book;
import com.example.ws.model.BookType;

public class MediaTypeResource {
    
    @GET
    @Path("get-book")
    @Produces("application/books+xml")
    public Book getBookAsXml(){
        Book book = new Book("ISBN00012");
        book.setId(100021);
        book.setSave(true);
        book.setType(BookType.DRAMA);
        return book;
    }
    
    @GET
    @Path("get-book")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getBookAsPlain(){
        Book book = new Book("ISBN00012");
        book.setId(100021);
        book.setSave(true);
        book.setType(BookType.DRAMA);
        return Response.ok(book.toString()).build();
    }
    
    @POST
    @Path("save-book")
    @Consumes({"application/books+xml","text/xml"})
    @Produces("text/xml")
    public Response saveBook(Book book){
        System.out.println("Book received: " + book);
        return Response.accepted(book).build();
    }
    
    @GET
    @Path("choose")
    public Response chooseObject(@HeaderParam("accept-encoding") String acceptEncoding, 
    		@HeaderParam("accept-language") String acceptLanguage,
    		@Context Request request){
    	
    	List<Variant> variants = new ArrayList<>();
    	variants.add(new Variant(MediaType.APPLICATION_JSON_TYPE,"en","US","gzip"));
    	variants.add(new Variant(MediaType.APPLICATION_XML_TYPE,"en","US","gzip"));
    	Variant selectedVariant = request.selectVariant(variants);
    	String response = null;
    	if(selectedVariant.getMediaType().equals(MediaType.APPLICATION_JSON_TYPE)){
    		response = "{\"response\" : \"ok\"}";
    	}else if(selectedVariant.getMediaType().equals(MediaType.APPLICATION_XML_TYPE)){
    		response = "<response>ok</response>";
    	}
    	
    	return Response.ok(response).type(selectedVariant.getMediaType()).build();
    }
    
    

}

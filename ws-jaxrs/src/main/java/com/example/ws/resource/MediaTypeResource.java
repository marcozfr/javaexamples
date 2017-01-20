package com.example.ws.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

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
    @Consumes("application/books+xml")
    public Response saveBook(Book book){
        System.out.println("Book received: " + book);
        return Response.accepted().build();
    }
    
    

}

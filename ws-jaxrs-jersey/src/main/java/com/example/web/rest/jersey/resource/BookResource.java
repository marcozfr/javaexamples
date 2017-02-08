package com.example.web.rest.jersey.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.example.web.model.AppBook;
import com.example.web.model.AppCatalog;
import com.example.web.repository.CatalogRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookResource {
    
    private long maxRows;
    
    public BookResource(@DefaultValue("100") @QueryParam("max")  long maxRows){
        super();
        this.maxRows = maxRows;
    }
    
    public BookResource() {
        System.out.println("Init book resource");
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBooks(){
        List<AppBook> books = CatalogRepository.getAppCatalog().getBooks().stream().limit(maxRows).collect(Collectors.toList());
//        GenericEntity<List<AppBook>> entity = new GenericEntity<List<AppBook>>(books){};
        return Response.ok().entity(books).build();
    }
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    //@Notification(fire="a new book was added")
    public JAXBElement<AppBook> addBook(MultivaluedMap<String, String> qParams, @Context HttpHeaders headers){
        AppBook book = new AppBook();
        book.setId(qParams.getFirst("id"));
        book.setAuthor(qParams.getFirst("author"));
        book.setTitle(qParams.getFirst("title"));
        book.setPrice(Double.valueOf(qParams.getFirst("price")));
        book.setDescription(qParams.getFirst("description"));
        CatalogRepository.getAppCatalog().getBooks().add(book);
        return new JAXBElement<AppBook>(new QName("book"), AppBook.class, book);
    }
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AppBook addBook(InputStream is) throws JsonParseException, JsonMappingException, IOException{
        AppBook book = new ObjectMapper().readValue(is, AppBook.class);
        CatalogRepository.getAppCatalog().getBooks().add(book);
        return book;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public JAXBElement<AppBook> getBookById(@PathParam("id") String id){
        
        if(id == null){
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        
        Optional<AppBook> book = CatalogRepository.getAppCatalog().getBooks().stream()
                .filter(b -> b.getId().equals(id)).findFirst();
        if(book.isPresent()){
            return new JAXBElement<AppBook>(new QName("book"), AppBook.class, book.get()); 
        }
        return null;
    }
    
    // response object matches MediaType : XML and object annotation XmlRootElement, automatic conversion is done
    @GET
    @Path("genre/{genre}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getBookByGenre(@PathParam("genre") String genre){
        List<AppBook> books = CatalogRepository.getAppCatalog().getBooks().stream()
                .filter(b -> b.getGenre().equals(genre)).limit(maxRows).collect(Collectors.toList());
        AppCatalog catalog = new AppCatalog();
        catalog.setBooks(books);
        return Response.ok(catalog, MediaType.APPLICATION_XML).build();
    }
    
}

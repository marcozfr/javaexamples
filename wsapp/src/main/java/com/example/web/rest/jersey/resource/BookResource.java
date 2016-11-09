package com.example.web.rest.jersey.resource;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.example.web.model.AppBook;
import com.example.web.model.AppCatalog;
import com.example.web.repository.CatalogRepository;

public class BookResource {
    
    private long maxRows;
    
    public BookResource(@DefaultValue("100") @QueryParam("max")  long maxRows){
        this.maxRows = maxRows;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public AppCatalog getBooks(){
        List<AppBook> books = CatalogRepository.getAppCatalog().getBooks().stream().limit(maxRows).collect(Collectors.toList());
        AppCatalog cat = new AppCatalog();
        cat.setBooks(books);
        return cat;
    }
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public JAXBElement<AppBook> addBook(@Context UriInfo uriInfo){
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        AppBook book = new AppBook();
        // TODO Add Book Implementation 
        return new JAXBElement<AppBook>(new QName("book"), AppBook.class, book);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public JAXBElement<AppBook> getBookById(@PathParam("id") String id){
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

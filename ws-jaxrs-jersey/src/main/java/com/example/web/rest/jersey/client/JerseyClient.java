package com.example.web.rest.jersey.client;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.web.model.AppBook;
import com.example.web.model.AppCatalog;
import com.example.web.rest.jersey.context.JsonListMessageBodyReader;
import com.example.web.rest.jersey.context.JsonMessageBodyReader;
import com.example.web.rest.jersey.context.JsonMessageBodyWriter;

public class JerseyClient {

    public static void main(String[] args) throws Exception {
        String book = "bk988";
        getCatalog();
//        getBooks();
//        addBook("bk992");
        
        addBookForm(book);
        getBook(book);
    }

    public static void getBook(String bkid) {
        Client client = ClientBuilder.newBuilder().property("connection.timeout", 100).build();

        String s = client.target("http://localhost:8180/wsapp/jersey/catalog/book/{id}").resolveTemplate("id", bkid)
                .queryParam("log", true).request().accept("application/xml").header("Content-Type", "text/html")
                .get(String.class);
        System.out.println("Book :" + s);
        client.close();

    }

    public static void getCatalog() {
        Client client = ClientBuilder.newClient();
        Response response= client.target(URI.create("http://localhost:8180/wsapp/jersey/catalog")).request()
                .get();
        if(response.getStatus() == Status.OK.getStatusCode()){
            response.bufferEntity();
            AppCatalog c = response.readEntity(AppCatalog.class);
            System.out.println("books as list : "+ c.getBooks());
            
        }
        response.close();
        client.close();
    }

    public static void getBooks() {
        Client client = ClientBuilder.newBuilder().register(JsonListMessageBodyReader.class).build();

        List<AppBook> books = client.target("http://localhost:8180/wsapp/jersey/catalog/book").request()
                .get(new GenericType<List<AppBook>>() {
                });
        
        books.forEach(System.out::println);
        client.close();
    }
    
    public static void addBookForm(String id){
        Client client = ClientBuilder.newBuilder().build();
        Builder builder =  client.target("http://localhost:8180/wsapp/jersey/catalog/book/add").request();
        Form form = new Form().param("id",id).param("price", "543.34").param("title", "As always");
        
        String xmlResponse = builder.post(Entity.form(form),String.class);
        
        System.out.println("New book added with form: "+ xmlResponse);
    }
    
    public static void addBook(String id) {
        Client client = ClientBuilder.newBuilder()
                .register(JsonMessageBodyReader.class)
                .register(JsonMessageBodyWriter.class)
                .build();
        
        AppBook book = new AppBook();
        book.setId(id);
        book.setPrice(345.44);
        book.setPublishDate(new Date());
        book.setTitle("Long story short");

        Response response = client.target("http://localhost:8180/wsapp/jersey/catalog/book/add")
                .request().post(Entity.json(book));
        
        if(response.getStatus() == 200){
            response.bufferEntity();
            AppBook newBook = response.readEntity(AppBook.class);
            System.out.println("Added book: " + newBook);
        }else {
            System.out.println( " # " + response.getStatus() + " # "+ response.getStatusInfo());
        }
        response.close();
        client.close();
    }

}

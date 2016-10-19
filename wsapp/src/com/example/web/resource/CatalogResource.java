package com.example.web.resource;

import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.example.web.rest.data.AppBook;
import com.example.web.rest.data.AppCatalog;

@Path("/catalog")
public class CatalogResource {

    private AppCatalog catalog;
    
    @PostConstruct
    public void init(){
        InputStream catalogXml = CatalogResource.class.getResourceAsStream("META-INF/books.xml");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(AppCatalog.class);
            
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            catalog = (AppCatalog) unmarshaller.unmarshal(catalogXml);
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    @GET
    @Path("/book/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public AppBook getBookById(@PathParam("id") String id){
        return catalog.getBooks().stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }
    
}

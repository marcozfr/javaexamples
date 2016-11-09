package com.example.web.rest.jersey.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.example.web.model.AppCurrency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/money")
public class CurrenciesResource {

    @Context
    ServletContext servletContext; 
    
    Map<String,AppCurrency> currencyMap;
    
    @PostConstruct
    public void init() {
        currencyMap = (Map<String, AppCurrency>) servletContext.getAttribute("currencyMap");
    }

    @GET
    @Path("/currency/{code: [A-Z]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurrency(@PathParam("code") String code) throws JsonProcessingException {
        
        Optional<AppCurrency> jsonValue = Optional.ofNullable(currencyMap.get(code));
        if (jsonValue.isPresent()) {
            return Response.ok(new ObjectMapper().writeValueAsString(jsonValue.get())).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }
    
    @GET
    @Path("/currency/jaxb")
    @Produces(MediaType.APPLICATION_XML)
    public Response getCurrencyAsXml(@QueryParam("code") String code) throws JAXBException{
        
        Optional<AppCurrency> currency = Optional.ofNullable(currencyMap.get(code));
        String currencyFile = "currency"+code+".xml";
        JAXBContext ctx = JAXBContext.newInstance(AppCurrency.class);
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        currency.ifPresent(c -> {
            try (FileOutputStream f = new FileOutputStream(currencyFile)){
                m.marshal(c, System.out);
                m.marshal(c, f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        Unmarshaller um = ctx.createUnmarshaller();
        AppCurrency c1 =  (AppCurrency) um.unmarshal(new File(currencyFile));
        return Response.ok(c1, MediaType.APPLICATION_XML).build();
    }
}

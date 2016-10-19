package com.example.web.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.web.rest.data.AppCurrency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/")
public class CurrenciesResource {
    
    private Map<String, AppCurrency> currencyMap = new HashMap<>();

    @PostConstruct
    public void init() {
        InputStream is = CurrenciesResource.class.getClassLoader().getResourceAsStream("META-INF/currency.json");
        // BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            currencyMap = new ObjectMapper().readValue(is, new TypeReference<Map<String, AppCurrency>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/currency/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCurrency(@PathParam("code") String code) {
        try {
            return new ObjectMapper().writeValueAsString(currencyMap.get(code));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}

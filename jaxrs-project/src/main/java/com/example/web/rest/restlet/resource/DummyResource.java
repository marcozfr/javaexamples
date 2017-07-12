package com.example.web.rest.restlet.resource;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.example.web.repository.CatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DummyResource extends ServerResource {

    @Get
    public Representation getCatalog() throws JsonProcessingException{
        return new JsonRepresentation(
                new ObjectMapper().writeValueAsString(CatalogRepository.getAppCatalog()));
    }
    
}

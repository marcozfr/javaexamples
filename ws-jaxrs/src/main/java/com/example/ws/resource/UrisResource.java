package com.example.ws.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriBuilderException;
import javax.ws.rs.core.UriInfo;

public class UrisResource {
    
    @Path("/info")
    @GET
    public Response getUriInformation(@Context UriInfo uriInfo,@Context Request request){
        
        StringBuilder sb = new StringBuilder();
        sb.append("{ \"path\" : \""+uriInfo.getPath()+"\" ,");
        sb.append(" \"abs-path\" : \""+uriInfo.getAbsolutePath()+"\" ,");
        sb.append(" \"uri\" : \""+uriInfo.getBaseUri()+"\" ,");
        sb.append(" \"path-params\" : \""+uriInfo.getPathParameters()+"\" ,");
        sb.append(" \"query-params\" : \""+uriInfo.getQueryParameters()+"\" ,");
        sb.append(" \"segments\" : \""+uriInfo.getPathSegments()+"\" ,");
        sb.append(" \"request-uri\" : \""+uriInfo.getRequestUri()+"\" }");
        
        return Response.ok(sb.toString()).type("application/json").build();
    }
    
    
    @Path("/build")
    @GET
    public String builder(@QueryParam("resource") String resource) throws IllegalArgumentException, UriBuilderException, URISyntaxException{
        URI uri = UriBuilder.fromUri(new URI("http://localhost:8180/jaxws-local")).path("{resource}").build(resource);
        return uri.toString();
    }
}

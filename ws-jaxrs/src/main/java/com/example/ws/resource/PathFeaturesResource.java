package com.example.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PathFeaturesResource {
	
	/**
	 * defaultGet will be chosen over defaultGetJson as the default GET for this resource {@link #defaultGetJson()}
	 * @return javax.ws.rs.core.Response
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response defaultGet(){
		return Response.ok("<h2>Default "+this.getClass()+"</h2>").build();
	}
	
	/**
	 * defaultGet for Json Accept for this resource
	 * @return javax.ws.rs.core.Response
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response defaultGetJson(){
		return Response.ok(" { \"default\" : \""+this.getClass()+"\" }").build();
	}

    @GET
    @Path("{id:\\d+}")
    @Produces(MediaType.TEXT_HTML)
    public Response getResourceRegex(@PathParam("id") Integer id){
        return Response.ok(id).build();
    }
    
    @GET
    @Path("{surname}-{lastname}")
    @Produces(MediaType.TEXT_HTML)
    public Response getResourceComposed(
            @PathParam("surname")String surname, 
            @PathParam("lastname") String lastname){
        String c = lastname.concat(", ").concat(surname);
        return Response.ok(c).build();
    }
    
}

package com.example.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

import com.sun.istack.logging.Logger;

public class PathFeaturesResource {
	
	private static Logger logger = Logger.getLogger(PathFeaturesResource.class); 
	
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

	/**
	 * PathSegment Usage
	 * @param id
	 * @return
	 */
    @GET
    @Path("{id:\\d+}/lookup")
    @Produces(MediaType.TEXT_HTML)
    public Response getResourceRegex(@PathParam("id") PathSegment id){
    	MultivaluedMap<String, String> matrixParams = id.getMatrixParameters();
    	logger.info("Matrix Params: " + matrixParams);
    	logger.info("Path Segment's path:" + id.getPath());
    	
        return Response.accepted("Received " + id.getPath()).build();
    }
    
    /**
     * surname path will take the last occurrence value only 
     * 
     * @param surname
     * @param lastname
     * @return
     */
    @GET
    @Path("{surname}-{lastname}-{surname}")
    @Produces(MediaType.TEXT_HTML)
    public Response getResourceComposed(
            @PathParam("surname")String surname, 
            @PathParam("lastname") String lastname){
        String c = lastname.concat(", ").concat(surname);
        return Response.ok(c).build();
    }
    
}

package com.example.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.example.ws.resource.exception.EntityNotFoundException;

public class ExceptionMapResource {
	
	@Path("throw")
	@GET
	public Response throwException(@QueryParam("doThrow") boolean doThrow){
		
		if(doThrow){
			ResponseBuilder rb = Response.status(Status.NOT_FOUND);
			rb.type("text/html");
			rb.entity("<h1>Not Found</h1>");
			throw new WebApplicationException(rb.build());
		}
		
		return Response.ok("<h1>Message received</h1>","text/html").build();
	}
	
	@Path("mapper")
	@GET
	public Response exceptionMapper(@QueryParam("doThrow") boolean doThrow) throws EntityNotFoundException{
		
		if(doThrow){
			throw new EntityNotFoundException("Requested item does not exist");
		}
		
		return Response.ok("<h1>Message received</h1>","text/html").build();
	}

}

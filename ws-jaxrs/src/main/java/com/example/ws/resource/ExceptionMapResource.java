package com.example.ws.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.example.ws.resource.exception.EntityNotFoundException;

public class ExceptionMapResource {
	
	@Path("not-authorized")
	@GET
	public Response notAuthorized(){
		//NotAuthorizedException
		//ForbiddenException
		//NotAcceptableException etc..
		throw new NotAuthorizedException("Bearer");
	}
	
	@Path("temporary-redirect")
	@POST
	public Response temporaryRedirect() throws URISyntaxException{
		throw new WebApplicationException(Response.temporaryRedirect(new URI("http://localhost:8180/ws-jaxrs-impl/resources/features/exception/throw")).build());
	}
	
	@Path("bad-request")
	@GET
	public Response badRequest(){
		//NotAuthorizedException
		//ForbiddenException
		//NotAcceptableException etc..
		throw new BadRequestException("This is a bad request");
	}
	
	@Path("not-found")
	@GET
	public Response resourceNotFound(){
		throw new WebApplicationException(Status.NOT_FOUND);
	}
	
	@Path("not-modified")
	@PUT
	public Response resourceNotModified(String column){
		return Response.notModified(new EntityTag("ETAGXFG00232")).build();
	}
	
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

package com.example.ws.resource.provider.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.ws.resource.exception.EntityNotFoundException;

@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException>{

	@Override
	public Response toResponse(EntityNotFoundException exception) {
		return Response.status(Status.NOT_FOUND)
				.type(MediaType.TEXT_HTML)
				.entity("<h2>Object not found </h2> <h3>Exception msg: "+exception.getMessage()+"</h3>").build();
	}

}

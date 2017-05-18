package com.example.ws.resource.provider.mapper;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Will map NotAcceptableException thrown by application 
 * @author floma4y
 *
 */
@Provider
public class NotSupportedExceptionMapper implements ExceptionMapper<NotSupportedException>{

	@Override
	public Response toResponse(NotSupportedException exception) {
		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse.put("class", exception.getClass());
		mapResponse.put("message", exception.getMessage());
		
		return Response.ok(mapResponse).type(MediaType.APPLICATION_JSON).build();
	}

}

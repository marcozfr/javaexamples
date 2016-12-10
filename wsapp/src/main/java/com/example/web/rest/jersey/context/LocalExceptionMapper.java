package com.example.web.rest.jersey.context;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.web.app.exception.LocalException;

@Provider
public class LocalExceptionMapper implements ExceptionMapper<LocalException> {

    @Override
    public Response toResponse(LocalException exception) {
        System.out.println("Mapping exception : " + exception.getMessage());
        return Response.status(Status.NOT_FOUND).build();
    }

}

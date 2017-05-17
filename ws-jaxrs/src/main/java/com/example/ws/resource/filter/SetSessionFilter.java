package com.example.ws.resource.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import com.example.ws.annotation.SetSession;
import com.sun.istack.logging.Logger;

@Provider
@SetSession
public class SetSessionFilter implements ContainerRequestFilter{
    
    private static Logger logger = Logger.getLogger(SetSessionFilter.class);
    
    @Context
    HttpServletRequest httpServletRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        HttpSession session = httpServletRequest.getSession(true);
        
        logger.info("Session: " + session.getId()+ ". Created on " + new Date(session.getCreationTime()));
        
    }

}

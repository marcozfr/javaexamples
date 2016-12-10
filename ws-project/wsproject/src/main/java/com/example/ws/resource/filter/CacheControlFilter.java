package com.example.ws.resource.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.CacheControl;

public class CacheControlFilter implements ContainerResponseFilter {
	
	private int maxAge;
	
	public CacheControlFilter(int maxAge) {
		this.maxAge = maxAge;
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		if(requestContext.getMethod().equals("GET")){
			System.out.println("Setting cache " + requestContext.getUriInfo());
			CacheControl cc = new CacheControl();
			cc.setMaxAge(this.maxAge);
			responseContext.getHeaders().add("Cache-Control", cc);
		}
	}

}

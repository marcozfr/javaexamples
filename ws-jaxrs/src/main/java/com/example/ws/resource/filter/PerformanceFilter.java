package com.example.ws.resource.filter;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import com.example.ws.annotation.Performance;

@Provider
@Performance
public class PerformanceFilter implements ContainerRequestFilter , ContainerResponseFilter {
	
	private Instant i1; 
	private Instant i2;
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		i2 = Instant.now();
		System.out.println("Time Taken "+ ChronoUnit.MILLIS.between(i1, i2));
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		i1 = Instant.now();
	}

}

package com.example.ws.resource;

import java.time.Instant;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.example.ws.annotation.MaxAge;
import com.example.ws.annotation.Performance;

public class CacheFeaturesResource {
	
	@Path("cache-control")
	@Produces("text/html")
	@GET
	public Response getCachedResource(@Context Request request){
		String resource = "<html><h3>Cached resource</h3></html>";
		
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(1*60);
		
		ResponseBuilder rb = request.evaluatePreconditions(new Date()); // always resolves to null
		
		if(rb!=null){
			rb.cacheControl(cacheControl);
			return rb.build();
		}
		
		return Response.ok(resource)
				.lastModified(new Date())
				.cacheControl(cacheControl).build();
	}
	
	@Path("cache-etag")
	@Produces("text/html")
	@GET
	public Response getCachedETagResource(@Context Request request){
		String resource = "<html><h3>Cached resource</h3></html>";
		
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(1*60);
		EntityTag tag = new EntityTag(String.valueOf(resource.hashCode()));
		ResponseBuilder rb = request.evaluatePreconditions(tag); 
		
		if(rb!=null){
			rb.cacheControl(cacheControl);
			return rb.build();
		}
		
		return Response.ok(resource)
				.tag(tag)
				.cacheControl(cacheControl).build();
	}
	
	@Path("expires")
	@Produces("text/html")
	@GET
	public Response getExpiresResource(@Context Request request){
		Instant timeNow = Instant.now().plusSeconds(60);
		String resource = "<html><h3>Cached resource, expires on </h3>" + timeNow + "</html>";
		Date d = Date.from(timeNow);
		
		return Response.ok(resource).expires(d).build();
	}
	
	@Path("max-age")
	@Produces("text/html")
	@MaxAge(600)
	@GET
	public Response getWithMaxAge(){
		return Response.ok("Ok").build();
	}
	
	@Path("check-performance")
	@Produces("text/html")
	@Performance
	@GET
	public Response getCheckPerformance(){
		
		int i = 10000;
		int k = 1;
		for(int j = 0 ; j < i ; j++){
			k = k + j;
			System.out.println(k);
		}
		
		return Response.ok(k).build();
	}


}

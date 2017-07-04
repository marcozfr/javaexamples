package com.example.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

public class ConfidentialResource {
	
	private String id = "default";
	
	public ConfidentialResource() {
	}
	
	public ConfidentialResource(@QueryParam("id") String id){
		this.id = id;
	}
	
	
	@GET
	@Produces("text/plain")
	public Response getSecuredResource(){
		return Response.ok("Resource returned 200. It is secured. Param id: " + id).build();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}

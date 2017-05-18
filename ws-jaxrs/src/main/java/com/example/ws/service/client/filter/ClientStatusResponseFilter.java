package com.example.ws.service.client.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.Response.Status;

public class ClientStatusResponseFilter implements ClientResponseFilter {

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		if(responseContext.getStatus() != Status.OK.getStatusCode()){
			String msg = "[Client Wrap] An error has ocurred with HTTP Status: " + responseContext.getStatus();
			InputStream stream = new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8));
			responseContext.setEntityStream(stream);
		}
	}

}

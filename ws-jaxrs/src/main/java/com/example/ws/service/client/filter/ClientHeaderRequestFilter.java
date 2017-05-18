package com.example.ws.service.client.filter;

import java.io.IOException;
import java.net.InetAddress;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

public class ClientHeaderRequestFilter implements ClientRequestFilter {

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add("Client-Addr", InetAddress.getLocalHost().getHostAddress()); 
	}

}

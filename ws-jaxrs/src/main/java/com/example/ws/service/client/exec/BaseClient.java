package com.example.ws.service.client.exec;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.example.ws.resource.interceptor.GzipDecodeInterceptor;
import com.example.ws.service.client.filter.ClientHeaderRequestFilter;

public class BaseClient {
	
	protected static final String BASE_URL = "http://localhost:8180/";
	
	protected static final String APP_CTX = "ws-jaxrs-impl";
	
	protected static final String BASE_APP = BASE_URL + APP_CTX;
	
	protected Client client;
	
	public BaseClient() {
		client = ClientBuilder.newBuilder()
				.property("connection.timeout", 1000)
				.register(GzipDecodeInterceptor.class)
				.register(ClientHeaderRequestFilter.class)
				.build();
	}
	
}

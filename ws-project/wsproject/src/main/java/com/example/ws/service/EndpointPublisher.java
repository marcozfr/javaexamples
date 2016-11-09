package com.example.ws.service;

import javax.xml.ws.Endpoint;

public class EndpointPublisher {
	
	public static void main(String args[]){
		final String url = "http://localhost:8888/rs";
		System.out.println("Publishing RandService at endpoint " + url);
		Endpoint.publish(url, new RandomServiceImpl());
	}

}

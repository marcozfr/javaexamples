package com.example;

import javax.xml.ws.Endpoint;

public class Publisher {
	
	public static void main(String args[]){

		Endpoint.publish("http://localhost:9988/ws", new WsService());

	}
}
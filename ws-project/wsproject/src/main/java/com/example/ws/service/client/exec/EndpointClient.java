package com.example.ws.service.client.exec;

import com.example.ws.service.client.RandomService;
import com.example.ws.service.client.RandomServiceImplService;

public class EndpointClient {
	
	public static void main(String[] args) {
		RandomServiceImplService clientServie = new RandomServiceImplService();
		RandomService rs = clientServie.getRandomServiceImplPort();
		
		System.out.println("Next Method: "+rs.next());
		
		System.out.println("NextN Method:");
		rs.nextN(5).stream().forEach(System.out::println);

		
	}

}

package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void testTestController() {
		String customer = UUID.randomUUID().toString();
		String product = UUID.randomUUID().toString();
		Map<String,Object> uris = new HashMap<>();
		uris.put("customer", customer);
		uris.put("product", product);
		UriComponents url = UriComponentsBuilder
				.fromHttpUrl("http://localhost:"+port)
				.path("/test")
				.path("/{customer}")
				.path("/test")
				.path("/{product}")
				.queryParam("category", "cat1")
				.queryParam("sector", "sec5")
				.buildAndExpand(uris);
	
		ResponseEntity<String> response = restTemplate.exchange(url.toString(), 
				HttpMethod.GET, RequestEntity.EMPTY, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		assertTrue(response.getBody().contains(customer));
		assertTrue(response.getBody().contains(product));
	}
	
}

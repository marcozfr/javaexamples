package com.example.ws.service.client.exec;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.RedirectionException;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

public class RsSamples {
	
	public static final String SERVICES_URL = "http://www.thomas-bayer.com/sqlrest/";
	
	public static void main (String args[]){
		RsSamples.testCaptcha();
	}
	
	public static void testCaptcha(){
		Client client = ClientBuilder.newClient();
//		http://localhost/vec/public/stream/captcha
//		https://vecportalqa4.ebiz.verizon.com/vec/public/stream/captcha
		Builder b = client.target("https://vecportalqa2.ebiz.verizon.com/vec/public/stream/captcha").request();
		Invocation inv = b.buildGet();
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i < 10000; i ++ ){
			try {
				es.execute(() -> {
						Response r = inv.invoke();
						String idHeader = (String)r.getHeaders().getFirst("_cid");
						System.out.println(idHeader);
				});
				
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
		
		client.close();
	}
	
	public void getProduct(Client client, String id, int times) {
		Builder b = client.target(SERVICES_URL).path(Item.PRODUCT.name()).path(id).request();
		Invocation inv = b.buildGet();
		try {
			for(int i = 0; i < times; i ++ ){
				System.out.println("Product invocation " + i);
				System.out.println(inv.invoke(String.class));
			}
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ClientErrorException e){
			System.out.println("Default 400s Exception: " + e.getMessage());
		} catch (ServerErrorException e){
			System.out.println("Default 500s Exception: " + e.getMessage());
		} catch (RedirectionException e){
			System.out.println("300s Exception: " + e.getMessage());
			System.out.println("Redirection location " + e.getLocation());
		}
	}

	public void getCustomer(Client client, String id){
		
		Builder b = client.target(SERVICES_URL).path(Item.CUSTOMER.name()).path(id).request();
		Response response = b.get();
		if(response.getStatus() == 200){
			response.bufferEntity();
			String xmlResponse = response.readEntity(String.class);
			System.out.println(xmlResponse);
		}else{
			System.out.println("Server returned with status:  "  + response.getStatus() + " # "+ response.getStatusInfo());
		}
		response.close();
		
	}
	
	
	public enum Item {
		CUSTOMER,
		INVOICE,
		ITEM,
		PRODUCT
	}

}

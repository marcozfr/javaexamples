package com.example.ws.http.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.internal.util.collection.MultivaluedStringMap;

public class JerseyClient {
	
	public static void main(String[] args) throws SOAPException, IOException {
//		postRunProcess();
		postForm();
	}
	
	public static void postForm() throws SOAPException, IOException{
		Client client = ClientBuilder.newClient();
		
		MultivaluedMap<String, String> form = new MultivaluedStringMap();
		form.add("firstName", "M");
		form.add("lastName", "F");
		
		Builder b = client.target("http://localhost:8180/ws-jaxrs-impl/resources/features/params/form").request(MediaType.TEXT_PLAIN);
		Response response = b.post(Entity.form(form));
		
		System.out.println(response.readEntity(String.class));
	}
	
	public static void postRunProcess() throws SOAPException, IOException{
		
		HttpAuthenticationFeature auth = HttpAuthenticationFeature.basic("admin", "c90100a".getBytes());
		Client c = ClientBuilder.newClient();
		c.property(ClientProperties.READ_TIMEOUT, 4000);
		c.property(ClientProperties.FOLLOW_REDIRECTS, true);
		c.register(auth);
		
		Builder b = c.target("http://localhost:8180/jaxws-local/{endpoint}").resolveTemplate("endpoint", "LongProcessService").request();
		
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage();
		SOAPBodyElement bodyElement = message.getSOAPBody().addBodyElement(new QName("http://process.ws.example.com","run"));
		SOAPElement element = bodyElement.addChildElement(new QName("arg0"));
		element.setTextContent("Hi all");
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		message.writeTo(out);
		String strMsg = new String(out.toByteArray());
		System.out.println("Sending : ");
		System.out.println(strMsg);
		Response response = b.post(Entity.entity(strMsg, MediaType.TEXT_XML));
		System.out.println(response.readEntity(String.class));
		c.close();
	}

}

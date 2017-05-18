package com.example.ws.service.client.exec;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ParamsFeaturesClient extends BaseClient {
	
	private static Logger logger = Logger.getLogger(ParamsFeaturesClient.class.getName());
	
	public void postMultivaluedForm() throws URISyntaxException{
		
		URI uri = new URI(BASE_APP + "/resources/features/params/form");
		
		WebTarget target = client.target(uri);
		
		MultivaluedMap<String, String> form = new MultivaluedHashMap<>();
		form.add("form1key", "form1value");
		
		Builder builder = target.request().accept(MediaType.TEXT_PLAIN);
		
		Response response = builder.post(Entity.form(form));
		
		logger.info(response.getStatusInfo().toString());
		logger.info(response.getMediaType().toString());
		logger.info(response.getHeaders().toString());
		logger.info(response.readEntity(String.class));
	}
	
	public void postFormObject(){
		Builder builder = client.target(BASE_APP+"/resources/features/params/form").request();
		Form form = new Form();
		form.param("firstName", "Marco");
		form.param("lastName", "Flores");
		Response response = builder.post(Entity.form(form));
		if(response.getStatusInfo().equals(Status.OK)){
			String responseString = response.readEntity(String.class);
			logger.info(responseString);
		}
	}
	
	public void buildPostCustomerBean(){
		Builder builder = client.target(BASE_APP+"/resources/features/params/customer-bean").request();
		Form form = new Form();
		form.param("firstName", "Marco");
		form.param("lastName", "Flores");
		
		Invocation invocation = builder
//				.header("Referer", "JerseyClient")
				.header("backendSystem", "S3")
				.accept(MediaType.APPLICATION_JSON)
				.buildPost(Entity.form(form));
		
		Response response  = invocation.invoke();
		
		String responseString = response.readEntity(String.class);
		logger.info(responseString);
	}

}

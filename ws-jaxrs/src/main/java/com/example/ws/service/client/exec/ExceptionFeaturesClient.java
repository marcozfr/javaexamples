package com.example.ws.service.client.exec;

import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import com.example.ws.service.client.filter.ClientStatusResponseFilter;

public class ExceptionFeaturesClient extends BaseClient {
	
	private static Logger logger = Logger.getLogger(ParamsFeaturesClient.class.getName());
	
	public void exceptionResponse(){
		
		Builder builder = client.target(BASE_APP + "/resources/features/exception/not-authorized")
				.register(ClientStatusResponseFilter.class)
				.request();
		Invocation invocation = builder.buildGet();
		
		Response response = invocation.invoke();
		
		logger.info(response.readEntity(String.class));
	}

}

package com.example.ws.service.client.exec;

import java.net.URISyntaxException;

public class MainClient {
	
	public static void main(String[] args) throws URISyntaxException {
		ParamsFeaturesClient pathFeaturesClient = new ParamsFeaturesClient();
//		pathFeaturesClient.postMultivaluedForm();
//		pathFeaturesClient.postFormObject();
//		pathFeaturesClient.buildPostCustomerBean();
		
		ExceptionFeaturesClient client = new ExceptionFeaturesClient();
		client.exceptionResponse();
	}

}

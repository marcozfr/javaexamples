package com.example.ws.process.server.endpoint;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;

import com.example.ws.process.server.LongProcessService;

public class LongProcessServicePublisher {
	
	public static void main(String[] args) {
		
		Endpoint longProcessEndpoint = Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING, new LongProcessService(), new MTOMFeature(true));
		Map<String,Object> properties = new HashMap<>();
		properties.put(Endpoint.WSDL_PORT, new QName("http://endpoint.process.com","lpPort"));
		properties.put(Endpoint.WSDL_SERVICE, new QName("http://endpoint.process.com","lpService"));
		longProcessEndpoint.setProperties(properties);
		((SOAPBinding)longProcessEndpoint.getBinding()).setMTOMEnabled(true);
		
		longProcessEndpoint.publish("http://localhost:8190/lp");
		
	}

}

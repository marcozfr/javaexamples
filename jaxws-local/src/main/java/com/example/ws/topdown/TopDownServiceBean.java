package com.example.ws.topdown;

import javax.jws.WebService;

@WebService(portName="TopDownServiceSOAP", 
	serviceName="TopDownService", name="TopDownService", 
	targetNamespace="http://topdown.ws.example.com/TopDownService/",endpointInterface="com.example.ws.topdown.TopDownService")
public class TopDownServiceBean implements TopDownService{
	
	public String downloadImage(){
		return "hello";
	}
	
	public String registerUser(){
		return "helloUser";
	}

}

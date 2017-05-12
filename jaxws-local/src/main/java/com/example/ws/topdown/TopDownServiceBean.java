package com.example.ws.topdown;

import javax.jws.WebService;

@WebService(portName="TopDownServiceSOAP", serviceName="TopDownService", name="TopDownService", endpointInterface="com.example.ws.topdown.TopDownService", targetNamespace="http://topdown.ws.example.com/TopDownService/")
public class TopDownServiceBean implements TopDownService{
	
	public String downloadImage(){
		return "hello";
	}
	
	public String registerUser(){
		return "helloUser";
	}

}

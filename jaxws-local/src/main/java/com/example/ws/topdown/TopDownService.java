package com.example.ws.topdown;

import javax.jws.WebService;

@WebService(portName="TopDownServiceSOAP", 
	serviceName="TopDownService", name="TopDownService", 
	targetNamespace="http://topdown.ws.example.com/TopDownService/")
public interface TopDownService {
	
	public String downloadImage();
	
	public String registerUser();

}

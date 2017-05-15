package com.example.ws.topdown;

import javax.jws.WebService;

@WebService(endpointInterface="com.example.ws.topdown.TopDownService")
public class TopDownServiceBean implements TopDownService{
	
	public String downloadImage(){
		return "hello";
	}
	
	public String registerUser(){
		return "helloUser";
	}

}

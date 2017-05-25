package com.example.ws.topdown;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(portName="TopDownServicePort", 
	serviceName="TopDownServiceEndpoint", name="TopDownServicePortType", 
	targetNamespace="http://topdown.ws.example.com/TopDownService/",endpointInterface="com.example.ws.topdown.TopDownService")
@SOAPBinding(parameterStyle=ParameterStyle.BARE,style=Style.DOCUMENT,use=Use.LITERAL)
public class TopDownServiceBean implements TopDownService{
	
	public String downloadImage(){
		return "hello";
	}
	
	public String registerUser(){
		return "helloUser";
	}

}

package com.example.messages;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(name="Exchange", portName= "ExchangeServicePort", serviceName="ExchangeService")
public class MessageExchange {
	
	@WebMethod
	public void receive(String message){
		System.out.println("Received: " + message);
	}

	@WebMethod
	public String exchange(String message){
		return "Echoing the following message:  " + message ;
	}

}
package com.example.web.ws.client;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.example.web.ws.provider.WsUtils;

public class SOAPConnectionClient {
	
	public static void main(String[] args) {
		if(args.length < 2){
			System.out.println("Usage: SOAPConnectionClient <endpoint> <message>");
			return;
		}
		String endpoint = args[0];
		String message = args[1];
		performCall(endpoint,message);
	}
	
	public static void performCall(String endpoint, String message){
		try {
			SOAPConnectionFactory connectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = connectionFactory.createConnection();
			
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage soapMessage = messageFactory.createMessage();
			
			soapMessage.getSOAPBody().setTextContent(message);
			
			System.out.println("Sending:");
			WsUtils.logSOAPMessage(soapMessage);
			
			SOAPMessage response = connection.call( soapMessage,endpoint);
			
			System.out.println("Receiving:");
			WsUtils.logSOAPMessage(response);
			
			connection.close();
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}

}

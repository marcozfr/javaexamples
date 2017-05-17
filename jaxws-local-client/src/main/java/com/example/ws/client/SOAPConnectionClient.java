package com.example.ws.client;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.client.handler.LogPayloadLogicalHandler;
import com.example.ws.domain.util.WsUtils;

public class SOAPConnectionClient {
	
	private static Logger logger = LoggerFactory.getLogger(SOAPConnectionClient.class);
	
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
			WsUtils.logSOAPMessage(logger,soapMessage);
			
			SOAPMessage response = connection.call( soapMessage,endpoint);
			
			System.out.println("Receiving:");
			WsUtils.logSOAPMessage(logger,response);
			
			connection.close();
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}

}

package com.example.ws.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class WsUtils {
	
	public static void logSOAPMessage(SOAPMessage request){
		String requestString = null;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			request.writeTo(baos);
			requestString = baos.toString();
		} catch (IOException | SOAPException e) {
			e.printStackTrace();
		}
		
		System.out.println("SOAP Message: ");
		System.out.println(requestString);
	}

}

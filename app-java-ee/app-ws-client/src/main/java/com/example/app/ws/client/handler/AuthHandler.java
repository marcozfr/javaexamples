package com.example.app.ws.client.handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class AuthHandler implements SOAPHandler<SOAPMessageContext>{

	private String authCode;
	
	public AuthHandler(String authCode){
		this.authCode = authCode;
	}
	
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			
			Boolean isOut = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if(isOut){
				
				SOAPHeader header = context.getMessage().getSOAPHeader();
				
				SOAPFactory factory = SOAPFactory.newInstance();
				SOAPElement authElement1 = factory.createElement("AuthCode", "CAT", "http://com.example.ws");
				
				authElement1.addTextNode(authCode);
				
				header.addChildElement(authElement1);
				
				System.out.println("Building msg::::");
				context.getMessage().writeTo(System.out);
				System.out.println();
			}
			
		} catch (SOAPException | IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		try {
			System.out.println("Getting fault msg::::");
			context.getMessage().writeTo(System.err);
			System.out.println();
		} catch (SOAPException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("Closing Auth client Handler");
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}

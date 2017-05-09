package com.example.ws.http.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class SimpleAuthenticator extends Authenticator{
	
	private String userName;
	private char[] password;
	
	public SimpleAuthenticator(String userName, char[] password){
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}

}

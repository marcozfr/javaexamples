package com.example.ws.http.client;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class HttpConnectionClient {
	
	public static void main(String[] args) throws IOException {
		
		if(args[0] == null){
			System.out.println("Usage: HttpClient <method> <url> <user> <pwd>");
		}
		if(args[2]!=null && args[3]!=null){
			Authenticator.setDefault(new SimpleAuthenticator(args[2],args[3].toCharArray()));
		}
		
		String endpoint = args[1];
		String method = args[0];
		URL url = new URL(endpoint);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod(method);
		conn.setReadTimeout(5000);
		conn.connect();
		
		String result = IOUtils.toString(conn.getInputStream(),"utf-8");
		System.out.println(result);
		
	}

}

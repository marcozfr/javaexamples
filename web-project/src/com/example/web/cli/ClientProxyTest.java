package com.example.web.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientProxyTest {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
//		System.getProperties().put("proxySet", "true");
		System.getProperties().put("https.proxyHost", "proxy.ebiz.verizon.com");
		System.getProperties().put("https.proxyPort", "80");
//		System.getProperties().put("http.proxyHost", "proxy.ebiz.verizon.com");
//		System.getProperties().put("http.proxyPort", "1234");
		
//		try {
//            InetAddress ip = InetAddress.getByAddress("74.125.224.72".getBytes());
//            System.out.println(ip.toString());
//        }catch (UnknownHostException uhx) {
//        	uhx.printStackTrace();
//        }
		

		HttpURLConnection conn = (HttpURLConnection) new URL("https://www.google.com").openConnection();
//		System.out.println(conn.getContent());
		InputStream is = (InputStream)conn.getContent();
		try(BufferedReader bf = new BufferedReader(new InputStreamReader(is))){
			String a = null;
			if(is!=null){	
				while((a = bf.readLine()) !=null){
					System.out.println(a);
				}
			}
		}
		
		conn.disconnect();
	}

}

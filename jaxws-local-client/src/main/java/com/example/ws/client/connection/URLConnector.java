package com.example.ws.client.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnector {

    public static void main(String[] args) {
        
        URL url;
        try {
            url = new URL(args[0].trim());
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Accept", "text/xml");
            conn.setDoOutput(true);
            
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
                String record = null;
                while( (record = br.readLine())!= null){
                    System.out.println(record);
                }
            }
            
        } catch (MalformedURLException e) {
            System.out.println("Malformed url " +e.getMessage());
        } catch (IOException e) {
            System.out.println("io exception " +e.getMessage());
        }
        
    }

}

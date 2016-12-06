package com.example.web.app;


import java.net.InetSocketAddress;

import javax.ws.rs.ext.RuntimeDelegate;

import com.example.web.rest.jersey.JerseyAppConfig;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class ServerPublish {
    
    public static final String URI = "/s";
    public static final int PORT = 9090;
    public static final String HOSTNAME = "localhost";
    
    public static void main(String args []){
        
        ServerPublish sp = new ServerPublish();
        sp.publish();
        
    }
    
    private void publish(){
        HttpServer server = getServer(PORT);
        HttpHandler requestHandler = RuntimeDelegate.getInstance().createEndpoint(new JerseyAppConfig(), HttpHandler.class);
        server.createContext(URI,requestHandler);
        server.start();
        
        msg(server);
    }
        
    private HttpServer getServer(int port){
        HttpServer httpServer = null;
        int backlog = 8;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(HOSTNAME, port), backlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpServer;
    }
    
    private void msg(HttpServer server){
        String out = "Publishing on "+ server.getAddress() + ". ";
        System.out.println(out);
    }

}

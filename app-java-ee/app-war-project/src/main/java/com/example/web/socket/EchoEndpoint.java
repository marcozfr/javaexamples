package com.example.web.socket;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoEndpoint {

	@OnMessage
	public void onMessage(Session session, String msg){
		try{
			session.getBasicRemote().sendText(msg);
		}catch(IOException e){
			
		}
	}
	
}

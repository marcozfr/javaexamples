package com.example.web.socket;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/build-echo")
public class BuildMessageEndpoint {

	@OnOpen
	public void open(Session session){
		session.getUserProperties().put("message", "");
	}
	
	@OnMessage
	public void message(Session session, String msg){
		String prevMsg = (String)session.getUserProperties().get("message");
		msg =  prevMsg + " "+ msg;
		session.getUserProperties().put("message", msg);
		
		try {
			session.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

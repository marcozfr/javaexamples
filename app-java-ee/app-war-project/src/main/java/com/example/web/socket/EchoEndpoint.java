package com.example.web.socket;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ServerEndpoint("/echo")
public class EchoEndpoint {
	
	public static Logger logger = LogManager.getLogger(EchoEndpoint.class);
	
	private ScheduledExecutorService fixedRateExecutor = null;
	
	@OnOpen
	public void onOpen(Session session){
		logger.info("session "+session.getId() + " has opened a connection");
		fixedRateExecutor = Executors.newScheduledThreadPool(2);
		fixedRateExecutor.scheduleAtFixedRate(() -> {
			try{
				session.getBasicRemote().sendText("[" + Thread.currentThread().getName() + "] Connection checker");
			}catch(IOException e){
				e.printStackTrace();
			}
		}, 0, 5, TimeUnit.SECONDS);
	}

	@OnMessage
	public void onMessage(Session session, String msg){
		try{
			session.getBasicRemote().sendText("[" + Thread.currentThread().getName() + "] Server received: " + msg);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@OnClose
	public void onClose(Session session){
		logger.info("session " + session.getId() + " being closed");
		fixedRateExecutor.shutdown();
	}
	
}

package com.example.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class MyHttpSessionListener implements HttpSessionListener{

	private AtomicInteger counter = new AtomicInteger();

	public int sessionCounter(){
		return counter.get();
	}
	
	public void sessionCreated(HttpSessionEvent evt){
		System.out.println("session created: " + evt.getSession().getId());
		System.out.println("active sessions: " + counter.incrementAndGet());
	}

	public void sessionDestroyed(HttpSessionEvent  evt){
		System.out.println("session destroyed: " + evt.getSession().getId());
		System.out.println("active sessions: " + counter.decrementAndGet());
	}

}
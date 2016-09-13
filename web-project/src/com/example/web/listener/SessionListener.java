package com.example.web.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	
	private AtomicInteger count = new AtomicInteger(0);
	
	public void sessionCreated(HttpSessionEvent evt){
		System.out.println("Session created: " +evt.getSession().getId());
		System.out.println("Session count:" + count.incrementAndGet());
	}
	
	public void sessionDestroyed(HttpSessionEvent evt){
		System.out.println("Session destroyed: " +evt.getSession().getId());
		System.out.println("Session count:" + count.decrementAndGet());
	}

}

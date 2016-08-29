package com.example.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener{
	
	public void sessionCreated(HttpSessionEvent evt){
		System.out.println("session created: " + evt.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent  evt){
		System.out.println("session destroyed: " + evt.getSession().getId());
	}

}
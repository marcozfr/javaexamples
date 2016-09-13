package com.example.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class SessionActivationListener implements HttpSessionActivationListener {

	public void sessionDidActivate(HttpSessionEvent evt){
		System.out.println("Session activation" + evt.getSession().getId());
	}
	
	public void sessionWillPassivate(HttpSessionEvent evt){
		System.out.println("Session passivation"+ evt.getSession().getId());
	}
	
}

package com.example.web.listener;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

public class AppContextListener implements ServletContextListener{
	
	public void contextInitialized(ServletContextEvent evt){
		System.out.println(" listening context event ");
		ServletContext context = evt.getServletContext();
		String version = context.getInitParameter("version");
		context.setAttribute("app-version",version);
	}

	public void contextDestroyed(ServletContextEvent evt){
		
	}
}
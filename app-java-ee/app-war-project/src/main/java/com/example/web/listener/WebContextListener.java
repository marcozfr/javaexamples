package com.example.web.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener("webContextListener")
public class WebContextListener implements ServletContextListener {
	
	public static Logger logger = LogManager.getLogger(WebContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("Web App Initialized at {}", new Date());
	}

}

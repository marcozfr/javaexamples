package com.example.ws.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LocalServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // initialize JAX WS resources logging
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // shutting down..
    }

}

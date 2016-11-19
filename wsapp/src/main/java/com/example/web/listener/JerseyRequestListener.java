package com.example.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener(value="Listens jersey jax rs requests")
public class JerseyRequestListener implements ServletRequestListener {

    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest sr = (HttpServletRequest)sre.getServletRequest();
        if(sr.getRequestURI().contains("/jersey/")){
           
        }
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // TODO Auto-generated method stub
        
    }

    
}

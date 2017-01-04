package com.example.web.listener;

import java.util.Enumeration;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener(value="Listens jersey jax rs requests")
public class JerseyRequestListener implements ServletRequestListener {

    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest sr = (HttpServletRequest)sre.getServletRequest();
        if(sr.getRequestURI().contains("/jersey/")){
           System.out.println("## Jersey request");
           System.out.println("## "+sr.getRequestURI() +" "+sr.getMethod() );
           Enumeration<String> headers = sr.getHeaderNames();
           while(headers.hasMoreElements()){
               String headerName = headers.nextElement();
               System.out.println(headerName + ":"+sr.getHeader(headerName));
           }
           System.out.println();
        }
    }

    
}

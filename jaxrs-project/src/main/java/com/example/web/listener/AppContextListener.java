package com.example.web.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.example.web.model.AppCurrency;
import com.example.web.rest.jersey.resource.CurrenciesResource;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("WsApp Context Destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("WsApp Context Initialized");
        Enumeration<String> params = arg0.getServletContext().getInitParameterNames();
        while (params.hasMoreElements()) {
            String paramName = (String) params.nextElement();
            String paramValue = arg0.getServletContext().getInitParameter(paramName);
            System.out.println("Init Param : " + paramName + ":" + paramValue);
        }
        
        loadCurrencies(arg0);
    }
    
    public void loadCurrencies(ServletContextEvent arg0){
        
        Map<String, AppCurrency> currencyMap = new HashMap<>();
        InputStream is = CurrenciesResource.class.getClassLoader().getResourceAsStream("currency.json");
        // BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            currencyMap = new ObjectMapper().readValue(is, new TypeReference<Map<String, AppCurrency>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        arg0.getServletContext().setAttribute("currencyMap", currencyMap);
    }

    
    
}

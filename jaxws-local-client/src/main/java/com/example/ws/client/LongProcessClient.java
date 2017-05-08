package com.example.ws.client;

import javax.xml.ws.BindingProvider;

import com.example.ws.process.LongProcessService;
import com.example.ws.process.LongProcessServicePort;
import com.example.ws.process.ProcessException_Exception;

public class LongProcessClient {
    
    public static void main(String[] args) throws ProcessException_Exception {
        LongProcessService longProcessService = new LongProcessService();
        LongProcessServicePort port = longProcessService.getLongProcessPort();
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "c90100a");
        String response = port.runProcess("Local JAVa client");
        System.out.println(response);
    }

}

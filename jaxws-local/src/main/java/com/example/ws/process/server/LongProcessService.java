package com.example.ws.process.server;

import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(name="LongProcessPortType",portName="LongProcessPort",
    serviceName="LongProcessService",targetNamespace="http://process.ws.example.com")
public class LongProcessService {
    
    @Resource
    WebServiceContext webServiceContext;

    @WebMethod(operationName="run", exclude=false)
    @RolesAllowed("home")
    public String run(String in) throws ProcessException {
        
        MessageContext messageContext = webServiceContext.getMessageContext();
        
        String pathInfo = (String) messageContext.get(MessageContext.QUERY_STRING);
        
        final int secs = ThreadLocalRandom.current().nextInt(1, 3);
//        new Thread(() -> {
            try {
                Thread.sleep(secs*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done in " + Thread.currentThread().getName());
//        }).start();
        
        return "Wroking "+ in +" in background for " + secs+ " seconds";
    }
    
    @WebMethod
    @Oneway
    public void runLong(@WebParam(mode=Mode.IN) String in){
        int secs = ThreadLocalRandom.current().nextInt(6, 10);
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worked on long process on "+ in +" for " + secs+ " seconds");
    }
    
    @WebMethod
    @SOAPBinding(parameterStyle=ParameterStyle.BARE)
    @WebResult(partName="runResponse",header=true)
    public String runSecure(@WebParam(header=true) String token){
        System.out.println("Token: " + token);
        return "Called runSecure with token "+token+", echo on " + Thread.currentThread().getName();
    }

}

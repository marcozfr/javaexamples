package com.example.ws.process.client;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Response;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.client.SOAPConnectionClient;
import com.example.ws.client.handler.LogPayloadLogicalHandler;
import com.example.ws.process.LongProcessService;
import com.example.ws.process.LongProcessServicePort;
import com.example.ws.process.ProcessException_Exception;
import com.example.ws.process.RunResponse;

public class LongProcessClient {
	
	private static Logger logger = LoggerFactory.getLogger(LongProcessClient.class);
    
    public static void main(String[] args) throws ProcessException_Exception, InterruptedException, ExecutionException {
        LongProcessService longProcessService = new LongProcessService();
        longProcessService.setHandlerResolver(new HandlerResolver() {
			@Override
			public List getHandlerChain(PortInfo portInfo) {
				return Collections.singletonList(new LogPayloadLogicalHandler());
			}
		});
        LongProcessServicePort port = longProcessService.getLongProcessPort();
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "c90100a");
        
        if(args!=null && args[0].equals("async-pool")){
        	Future<?> resp = port.runProcessAsync("From Client", new AsyncHandler<RunResponse>() {
				public void handleResponse(Response<RunResponse> res) {
					logger.info("Receiving response asyncly");
					try {
						logger.info(res.get().getReturn());
					} catch (Exception e){// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
        	
        	logger.info("Waiting to end " + resp.get());
        	
        }else if(args!=null && args[0].equals("async-callback")){
        	Response<RunResponse> response = port.runProcessAsync("Long Processing");
        	int i = 0;
        	while(!response.isDone()){
        		logger.info("Waiting loop, sec " + i);
        		Thread.sleep(1000);
        		i++;
        	}
        	logger.info(response.get().getReturn());
        }else {
        	String response = port.runProcess("Local JAVa client");
        	logger.info(response);
        }
        
    }

}

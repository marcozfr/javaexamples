package com.example.ws.process.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Response;

import com.example.ws.process.LongProcessService;
import com.example.ws.process.LongProcessServicePort;
import com.example.ws.process.ProcessException_Exception;
import com.example.ws.process.RunResponse;

public class LongProcessClient {
    
    public static void main(String[] args) throws ProcessException_Exception, InterruptedException, ExecutionException {
        LongProcessService longProcessService = new LongProcessService();
        LongProcessServicePort port = longProcessService.getLongProcessPort();
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "c90100a");
        if(args!=null && args[0].equals("async-pool")){
        	Future<?> resp = port.runProcessAsync("From Client", new AsyncHandler<RunResponse>() {
				public void handleResponse(Response<RunResponse> res) {
					System.out.println("Receiving response asyncly");
					try {
						System.out.println(res.get().getReturn());
					} catch (Exception e){// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
        	
        	System.out.println("Waiting to end " + resp.get());
        	
        }else if(args!=null && args[0].equals("async-callback")){
        	Response<RunResponse> response = port.runProcessAsync("Long Processing");
        	int i = 0;
        	while(!response.isDone()){
        		System.out.println("Waiting loop, sec " + i);
        		Thread.sleep(1000);
        		i++;
        	}
        	System.out.println(response.get().getReturn());
        }else {
        	String response = port.runProcess("Local JAVa client");
            System.out.println(response);
        }
        
    }

}

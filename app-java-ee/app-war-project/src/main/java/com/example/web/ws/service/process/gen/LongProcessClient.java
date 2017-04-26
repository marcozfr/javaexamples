package com.example.web.ws.service.process.gen;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.web.resource.BookResource;
import com.example.web.ws.service.process.RunResponse;

public class LongProcessClient {
	
	public static Logger logger = LogManager.getLogger(LongProcessClient.class);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		LongProcessService longProcess = new LongProcessService();
		
		AsyncHandler<RunResponse> asyncHandler = new AsyncHandler<RunResponse>() {
			@Override
			public void handleResponse(Response<RunResponse> res) {
				RunResponse response = null;
				try {
					System.out.println(Thread.currentThread().getName());
					response = res.get();
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String a = response.getReturn();
				logger.info("handling response : " + a);
			}
		};
		logger.info(Thread.currentThread().getName());
//		Future<?> result =  longProcess.getLongProcessServicePort().runProcessAsync("Hello", asyncHandler );
//		System.out.println(((RunResponse)result.get()).getReturn());
		
		Response<RunResponse> response =  longProcess.getLongProcessServicePort().runProcessAsync("Hello" );
		
		logger.info("Still in main");
		Thread.sleep(10000);
		logger.info("main resuming");
		logger.info(response.get().getReturn());
	
	}

	

}

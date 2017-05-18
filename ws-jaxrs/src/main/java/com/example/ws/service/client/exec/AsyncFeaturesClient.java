package com.example.ws.service.client.exec;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class AsyncFeaturesClient extends BaseClient {
	
	private static Logger logger = Logger.getLogger(AsyncFeaturesClient.class.getName());
	
	
	public static void main(String[] args) throws Exception {
		AsyncFeaturesClient c = new AsyncFeaturesClient();
//		c.getResponseAsync();
//		c.getResponseAsyncCallback();
		c.getServerAsyncResponse();
	}
	
	public void getResponseAsync() throws InterruptedException, ExecutionException{
		
		WebTarget target = client.target(BASE_APP + "/resources/features/cache/check-performance");
		Builder builder = target.request();
		Future<Response> future = builder.async().get();
		
		while(!future.isDone()){
			logger.info("Waiting for response ...");
			Thread.sleep(500);
		}
		
		String read = future.get().readEntity(String.class);
		logger.info("Response: " + read);
		
	}
	
	public void getResponseAsyncCallback() throws InterruptedException, ExecutionException{
		
		WebTarget target = client.target(BASE_APP + "/resources/features/cache/check-performance");
		Builder builder = target.request();
		builder.async().get(new InvocationCallback<Response>(){
			@Override
			public void completed(Response response) {
				String responseString = response.readEntity(String.class);
				logger.info("Response : " + responseString);
			}
			
			@Override
			public void failed(Throwable throwable) {
				throwable.printStackTrace();
			}
		});
		
	}
	
	public void getServerAsyncResponse(){
		WebTarget target = client.target(BASE_APP + "/resources/features/async/book");
		Builder builder = target.request();
		Entity entity = Entity.entity("<book><id>13</id></book>","application/books+xml");
		builder.async().get(new InvocationCallback<Response>(){

			@Override
			public void completed(Response response) {
				logger.info("Response: ");
				logger.info(response.getStatusInfo().toString());
				logger.info(response.readEntity(String.class));
//				target.request().async().get(this);
			}

			@Override
			public void failed(Throwable throwable) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

}

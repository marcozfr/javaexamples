package com.example.web.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class HeavyAsyncListener
 *
 */
@WebListener
public class HeavyAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent arg0) throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public void onError(AsyncEvent arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTimeout(AsyncEvent arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}

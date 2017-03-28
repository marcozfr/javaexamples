package com.example.ejb.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.example.ejb.jms.DefaultJmsMessageConsumer;

@Singleton
@Startup
public class JmsListenerSingleton {
	
	@Inject
	DefaultJmsMessageConsumer jmsMessageConsumer;
	
	ExecutorService executor = Executors.newSingleThreadExecutor();
	
	@PostConstruct
	public void init(){
		executor.execute(jmsMessageConsumer);
		
	}
}

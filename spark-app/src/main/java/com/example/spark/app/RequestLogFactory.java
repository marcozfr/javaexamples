package com.example.spark.app;

import java.io.IOException;

import org.eclipse.jetty.server.AbstractNCSARequestLog;
import org.slf4j.Logger;

public class RequestLogFactory {
	
	private Logger logger;

    public RequestLogFactory(Logger logger) {
        this.logger = logger;
    }
    
    AbstractNCSARequestLog create() {
    	return new AbstractNCSARequestLog() {
			
			@Override
			public void write(String requestEntry) throws IOException {
				logger.info(requestEntry);
			}
			
			@Override
			protected boolean isEnabled() {
				return true;
			}
		};
    }

}

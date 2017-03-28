package com.example.ejb.session.extension;

import java.time.Duration;
import java.time.Instant;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingInterceptor {
	
	public static Logger logger = LogManager.getLogger(LoggingInterceptor.class);

	@AroundInvoke
	public Object interceptToLog(InvocationContext ic){
		Instant now = null; Instant then = null;
		try {
			now = Instant.now();
			logger.info("Entering Class: {} Method: {}",ic.getTarget().toString(),ic.getMethod().getName());
			Object obj = ic.proceed();
			then = Instant.now();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			logger.info("Finishing Class: {} Method: {}",ic.getTarget().toString(),ic.getMethod().getName());
			logger.info("Time spent (ms): " + Duration.between(now, then).toMillis());
		}
	}
	
}

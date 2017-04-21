package com.example.ejb.session.extension;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingInterceptor implements Serializable {
	
    public static Logger logger = LogManager.getLogger(LoggingInterceptor.class);

	@AroundInvoke
	public Object interceptToLog(InvocationContext ic) throws Exception{
		Instant now = Instant.now();
		Instant then = null;
		try {
			logger.info("Entering Class: {} Method: {}",ic.getTarget().toString(),ic.getMethod().getName());
			Object obj = ic.proceed();
			return obj;
		} catch (Exception e) {
			logger.error("Error on Class: {} Method: {}",ic.getTarget().toString(),ic.getMethod().getName());
			logger.error("Error Message: {}",e.getMessage());
			throw e;
		} finally {
			then = Instant.now();
			logger.info("Finishing Class: {} Method: {}",ic.getTarget().toString(),ic.getMethod().getName());
			logger.info("Time spent (ms): " + Duration.between(now, then).toMillis());
		}
	}
	
}

package com.example.web.ws.service.process.impl;

import java.util.concurrent.ThreadLocalRandom;

import javax.jws.WebService;

import com.example.web.ws.service.longprocessservice.LongProcessServicePort;
import com.example.web.ws.service.longprocessservice.RunProcessFault_Exception;

@WebService(
serviceName="LongProcessService",
portName="LongProcessServicePort",
targetNamespace = "http://service.ws.web.example.com/LongProcessService/", 
name = "LongProcessServiceImpl",
endpointInterface="com.example.web.ws.service.longprocessservice.LongProcessServicePort")
public class LongProcessServiceImpl implements LongProcessServicePort {

	public String runProcess(String in) throws RunProcessFault_Exception {

		int secs = ThreadLocalRandom.current().nextInt(1, 5);
		int count = 0;
		
		while(count < secs){
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " running loop " + count + " out of " + secs);
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return "Job Done";
	}

}

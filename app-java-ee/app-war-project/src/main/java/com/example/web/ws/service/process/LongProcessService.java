package com.example.web.ws.service.process;

import java.util.concurrent.ThreadLocalRandom;

import javax.jws.WebService;

@WebService(name="LongProcessPortType",portName="LongProcessServicePort",serviceName="LongProcessService")
public class LongProcessService {
	
	public String run(String in) {

		int secs = ThreadLocalRandom.current().nextInt(5, 10) + 1;
		int actual = secs -1 ;
		int count = 1;
		
		while(count < secs){
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " running loop " + count + " out of " + actual);
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return "Job Done in " + actual;
	}

}

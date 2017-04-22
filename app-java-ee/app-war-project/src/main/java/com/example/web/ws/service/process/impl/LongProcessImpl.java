package com.example.web.ws.service.process.impl;

import java.util.concurrent.ThreadLocalRandom;

public class LongProcessImpl {

	public String run(String in) {

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

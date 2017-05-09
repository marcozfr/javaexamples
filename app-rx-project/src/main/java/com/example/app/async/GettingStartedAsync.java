package com.example.app.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

import rx.Observable;
import rx.functions.Action1;

public class GettingStartedAsync {
	
	public static void main(String[] args) throws InterruptedException {
		
		Callable<String> callableString = new Callable<String>() {
			@Override
			public String call() throws Exception {
				int secs =  ThreadLocalRandom.current().nextInt(3, 7);
				Thread.sleep(secs*1000);
				return "worked for " + secs + " secs on thread" + Thread.currentThread();
			}
		}; 
		
		Action1<String> sub = s -> System.out.println(s); 
		
		Observable.fromCallable(callableString).subscribe(sub);	
		
//		Thread.sleep(10*1000);
//		System.out.println("Finished main thread");
	}

}

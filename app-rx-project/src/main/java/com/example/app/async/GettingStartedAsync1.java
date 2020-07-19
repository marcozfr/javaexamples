package com.example.app.async;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class GettingStartedAsync1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Flowable.create(new FlowableOnSubscribe<String>() {
			public void subscribe(io.reactivex.FlowableEmitter<String> emitter) throws Exception {
				emitter.onNext("Goal!");
			};
		}, BackpressureStrategy.BUFFER)
				.subscribeOn(Schedulers.io())
				.observeOn(Schedulers.newThread())
				.subscribe(System.out::println);	
		Thread.sleep(2000l);
	}

}

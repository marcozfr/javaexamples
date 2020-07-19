package com.example.app;

import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscription;

import java.util.concurrent.CountDownLatch;

public class FixedCountExample {
	
	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(2);

		Flowable<String> namesObserver = Flowable.create(s -> {
			int counter = 0;
			while(!s.isCancelled()){
				Thread.sleep(1000);
				s.onNext("New item " + ++counter);
			}

		}, BackpressureStrategy.BUFFER)
				.subscribeOn(Schedulers.computation())
				.map(s -> (String)s);

		namesObserver.subscribe(new FixedCountSubscriber("flow1", 4, countDownLatch));
		namesObserver.subscribe(new FixedCountSubscriber("flow2", 2, countDownLatch));
		countDownLatch.await();
	}

	static class FixedCountSubscriber implements FlowableSubscriber<String> {
			Subscription s ;
			private int count;
			private String name;
			private CountDownLatch countDownLatch;

			public FixedCountSubscriber(String name, int count, CountDownLatch countDownLatch){
				this.count = count;
				this.name = name;
				this.countDownLatch = countDownLatch;
			}

			@Override
			public void onSubscribe(Subscription s) {
				System.out.println(name + " subscribed to " + s.toString());
				this.s = s;
				s.request(1);
			}

			@Override
			public void onNext(String t) {
				System.out.println("onNext on " + name + " : " + t);
				if(count == 0){
					s.cancel();
					countDownLatch.countDown();
				}else{
					s.request(1);
					count--;
				}

			}

			@Override
			public void onComplete() {
				System.out.println("Completed");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Error ocurred");
				e.printStackTrace();
			}
	}
}

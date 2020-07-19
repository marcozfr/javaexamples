package com.example.app;

import java.time.LocalDateTime;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;

public class PullBasedBackpressureSample {
	
	public static void main(String[] args) {
		
		Flowable<String> getInstants = Flowable.fromPublisher(new Publisher<String>() {
			@Override
			public void subscribe(Subscriber<? super String> s) {
				s.onSubscribe(new Subscription() {
					@Override
					public void request(long n) {
						for (int i = 0; i < n; i++) {
							s.onNext(LocalDateTime.now().toString());
						}
					}
					
					@Override
					public void cancel() {
						System.out.println("Cancelled");
						s.onComplete();
					}
				});
			}
		});
		
		getInstants.blockingSubscribe(new Subscriber<String>() {
			
			Subscription s;
			
			@Override
			public void onSubscribe(Subscription s) {
				this.s = s;
				this.s.request(1);
			}

			@Override
			public void onNext(String t) {
				System.out.println(t);
				try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
				s.request(1);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("Error");
				t.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Completed");
			}
		});
		
	}

}

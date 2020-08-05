package com.example.app;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class DisposingObserversSample {

    /*
    shows disposable feature
     */
    public static void disposableOnConsumer() throws InterruptedException {
        Observable<Long> seconds = Observable.interval(1, 1, TimeUnit.SECONDS)
                .doOnDispose(()-> {
                    System.out.println("Disposing subscription");
                });

        Thread.sleep(3000);

        Disposable disposable = seconds.subscribe(System.out::println);

        Thread.sleep(3000);

        disposable.dispose();
    }

    /*
    shows subscribeWith to return a disposable
     */
    public static void disposableSubscribeWith() throws InterruptedException {
        Observable<Long> seconds = Observable.intervalRange(
                5, 50, 0, 1, TimeUnit.SECONDS);
        ResourceObserver resourceObserver = new ResourceObserver() {
            @Override
            public void onNext(@NonNull Object o) {
                System.out.println(o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Disposable disposable = seconds.subscribeWith(resourceObserver);
        Thread.sleep(6000);
        disposable.dispose();
    }



    public static void main(String[] args) throws InterruptedException {

        disposableSubscribeWith();

    }
}

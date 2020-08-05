package com.example.app;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class CompositeDisposableSample {

    private static final CompositeDisposable disposables =
            new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS);
        //subscribe and capture disposables
        Disposable disposable1 = seconds
                .subscribe(l -> System.out.println("Observer 1: " + l));
        Disposable disposable2 = seconds
                .subscribe(l -> System.out.println("Observer 2: " + l));
        //put both disposables into CompositeDisposable
        disposables.addAll(disposable1, disposable2);
        //sleep 5 seconds
        Thread.sleep(5000);
        //dispose all disposables
        disposables.dispose();
        //sleep 5 seconds to prove
        //there are no more emissions
        Thread.sleep(5000);
    }
}

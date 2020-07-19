package com.example.app;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HotObservableExample {

    public static void main(String[] args) {

        Observable<String> consoleInputObservable =
            Observable.create(e -> {
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
                    String input;
                    while(!"quit".equals(input = reader.readLine())){
                        e.onNext(input);
                    }
                }catch(Exception err) {
                    e.onError(err);
                };
            }).subscribeOn(Schedulers.newThread())
                    .cast(String.class);

        consoleInputObservable.subscribe(c -> {
            System.out.println("Input - FirstTerminal: " + c);
        });

    }

}

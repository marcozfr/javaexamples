package com.example.app;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.UUID;

/*
A cold observable sends a limited number of emissions until completes.
 */
public class ColdObservableExample {

    public static class Entity {
        private String id;
        public Entity (String id){
            this.id = id;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Observable<Entity> obs = Observable.<Entity>create(emitter -> {
            emitter.onNext(new Entity(UUID.randomUUID().toString()));
            emitter.onNext(new Entity(UUID.randomUUID().toString()));
            emitter.onComplete();
        });

        obs.subscribe(c -> {
            System.out.println(c);
        });

        obs.subscribe(c -> {
            System.out.println(c);
        });

    }
}

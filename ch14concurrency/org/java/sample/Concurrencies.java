package org.java.sample;

import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;

public class Concurrencies {
    
    public static void main (String args[]) throws InterruptedException{
        Counter c = new BestCounter();
        Thread a = new Thread(new Th(c));
        Th b = new Th(c);
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(c.get());
    }
}

class Th extends Thread {
    Counter c = null;
    public Th(Counter c){
     this.c = c;
    }
    
    public void run(){
        for(int i = 0 ; i < 100000; i++){
            c.increment();
        }
    }
}

abstract class Counter {
    abstract void increment();
    abstract Long get();
}

class NotCounter extends Counter {
    private Long ai = 0l;
    public void increment(){
        ai++;
    }
    public Long get(){
        return ai;
    }
}

class BestCounter extends Counter {
    private AtomicLong ai = new AtomicLong();
    public void increment(){
        ai.getAndIncrement();
    }
    public Long get(){
        return ai.longValue();
    }
}
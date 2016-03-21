package org.java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ConditionConcurrent extends Thread {
    
    private Lock l = new ReentrantLock();
    private Condition c;

    public Condition getCondition(){
        return c;
    }
    
    public Lock getLock(){
        return l;
    }
    
    public void run(){
        String threadName = Thread.currentThread().getName();
        l.lock();
        c = l.newCondition();
        System.out.println(threadName+" Started. ");
        while(true){
            try{
                c.await();
                System.out.println(threadName+" Received something, processing ... ");
                Thread.sleep(3000);
                System.out.println(threadName+" Processed. ");
            }catch(InterruptedException ie){
                System.out.println(threadName+" Timeout or error... "+ ie.getMessage());
            }finally{
                System.out.println(threadName+" Unlocking... ");
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        ConditionConcurrent tc = new ConditionConcurrent();
        tc.setName("Thread-MainProcessor");
        tc.start();
        for(int i = 0 ; i < args.length ; i ++){
            Thread.sleep(Integer.valueOf(args[i]));
            new Thread(new RunConcurrent(tc.getLock(), tc.getCondition())).start();
        }
    }
}

class RunConcurrent implements Runnable {
    
    private Lock l;
    private Condition c;
    
    public RunConcurrent(Lock l, Condition c){
        this.l = l;
        this.c = c;
    }
    
    public void receiver(String threadName){
        l.lock();
        try{
            c.signalAll();
            System.out.println(threadName + " Sending something Notifying ...");
        }finally{
            System.out.println(threadName+" Unlocking... ");
            l.unlock();
        }
    }
    
    public void run (){
       receiver(Thread.currentThread().getName());
    }
}
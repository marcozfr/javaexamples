package org.java.samples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrent extends Thread {
    
    private final Lock l = new ReentrantLock();
    
    public void myConcurrentMethod(String threadName){
        try{
            System.out.println(threadName+" Waiting to lock... ");
            boolean locked = l.tryLock(2,TimeUnit.SECONDS);
            if(locked){
                try{
                    System.out.println(threadName + " Locked. Sleeping 4 secs... ");
                    Thread.sleep(6000);
                }finally{
                    System.out.println(threadName+" Unlocking... ");
                    l.unlock();
                }
            }else{
                System.out.println(threadName+" Finishing without performing actions (Maybe waiting time expired)");
            }
        }catch(InterruptedException ie){
            System.out.println(threadName+" Timeout or error... "+ ie.getMessage());
            //ie.printStackTrace();
        }
    }
    
    public void run (){
       myConcurrentMethod(Thread.currentThread().getName());
    }
    
    public static void main(String[] args){
        Concurrent tc = new Concurrent();
        new Thread(tc).start();
        new Thread(tc).start();
        new Thread(tc).start();
    }
}

class RunConcurrent implements Runnable {
    
    public void run (){
        System.out.println("Running runnable concurrent");
    }
}
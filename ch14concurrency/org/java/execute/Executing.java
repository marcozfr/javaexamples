package org.java.execute;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Executing {
    
    public static void main (String ... args){
        Runtime r = Runtime.getRuntime();
        System.out.println("available processors: " +r.availableProcessors() );
        
        tryForkJoin();
        //tryCallabes();
    }
    
    public static void tryForkJoin(){
        ForkJoinPool fjp = new ForkJoinPool();
        
    }
    
    public static void tryCallabes(){
        Callable<String> c = new CallObject();
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> f =  es.submit(c);
        try{
            System.out.println("Waiting ");
            String s = f.get(); // blocks until done
            System.out.println("Result: "+s);
            es.shutdown();
        }catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
}

class CallObject implements Callable<String>{
    
    @Override
    public String call (){
        try{Thread.sleep(2000);} catch(Exception e) {e.printStackTrace();}
        int i = ThreadLocalRandom.current().nextInt(3,10);
        System.out.println("Running "+ Thread.currentThread().getName());
        return String.valueOf(i);
    }
    
}
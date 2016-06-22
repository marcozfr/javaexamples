package org.java.sample;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;

class Locking {
    public static void main (String args[]) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newScheduledThreadPool(2);
        ((ThreadPoolExecutor)es).setCorePoolSize(2);
        
        Future<Long> f = null;
        for(int i = 0 ; i < args.length; i++){
            //Runnable r = new MyRunnable(Long.valueOf(args[i]));
            //es.execute();
            //((ScheduledThreadPoolExecutor)es).scheduleWithFixedDelay(r,1,3,TimeUnit.SECONDS);
            f = es.submit(new MyCallable());
            
            try {
                Long result = f.get();
                System.out.println("returned: "+result);
            }catch(Exception e){
                //e = new InterruptedException();
                throw e;
            }
        }
        
        
        /*
        try {
            es.shutdown();
            boolean isOver = es.awaitTermination(6,TimeUnit.SECONDS);
            System.out.println(isOver);
            
            if(!isOver){
                System.out.println("Forcing shutdown");
                List<Runnable> pendingList  = es.shutdownNow();
                System.out.println(pendingList);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        */
    }
}

class MyRunnable implements Runnable {
    private long time;
    public MyRunnable(long time){
        this.time = time;
    }
    public String toString(){
        return (super.toString() + time);
    }
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+" is sleeping for "+time);
            Thread.sleep(time);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<Long>{
    public Long call(){
        Long l = null;
        try{
            l= ThreadLocalRandom.current().nextLong(1000,3500);
            System.out.println(Thread.currentThread().getName()+" callable is sleeping for "+ l);
            Thread.sleep(l);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }
}

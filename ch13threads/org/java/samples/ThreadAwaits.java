package org.java.samples;

public class ThreadAwaits extends Thread {
     
    private Processor p;
    
    public ThreadAwaits(Processor p){
        this.p=p;
    }
    
    public Processor getProcessor(){
        return p;
    }
    
    public void run (){
        while(true){
            synchronized(p){
                try{
                    p.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("something has been processed ...");
            }
        }
    }
    
    public static void main (String args[]){
        Processor p = new Processor();
        ThreadAwaits ta = new ThreadAwaits(p);
        ta.start();
        for(int i = 0; i < args.length ; i ++){
            Thread tmail = new Thread(p);
            p.setProcTime(Integer.valueOf(args[i]));
            tmail.start();
        }
        
    } 
    
}

class Processor implements Runnable {
    private int proctime = 1000;
    
    public Processor(){
    }
    
    public synchronized void setProcTime(int proctime){
        this.proctime = proctime;
    }
    
    public void run (){
        synchronized (this){
            try{
                System.out.println("processing ...");
                System.out.println("estimated proc time :" + proctime + " ...");
                Thread.sleep(proctime); 
                System.out.println("finished ...");
                notify();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }    
    }

}
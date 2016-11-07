<<<<<<< HEAD
package org.java.samples;

import java.lang.*;

public class SyncUp implements Runnable {
    
    private StringBuffer sb = new StringBuffer("");

    @Override
    public void run(){
        
       // synchronized(sb){
            for(int i = 0; i < 20; i++){
                try{
                    Thread.sleep(100);
                }catch (Exception e){e.printStackTrace();}
                sb.append(Thread.currentThread().getName());
            }
            System.out.println("sb: "+sb.toString());
        //}
        
    }
    
    public static void main (String args[]){
        SyncUp s = new SyncUp();
        Thread t1 = new Thread(s,"a");
        Thread t2 = new Thread(s,"b");
        
        t1.start();
        t2.start();
    }
    
=======
package org.java.samples;

import java.lang.*;

public class SyncUp implements Runnable {
    
    private StringBuffer sb = new StringBuffer("");

    @Override
    public void run(){
        
       // synchronized(sb){
            for(int i = 0; i < 20; i++){
                try{
                    Thread.sleep(100);
                }catch (Exception e){e.printStackTrace();}
                sb.append(Thread.currentThread().getName());
            }
            System.out.println("sb: "+sb.toString());
        //}
        
    }
    
    public static void main (String args[]){
        SyncUp s = new SyncUp();
        Thread t1 = new Thread(s,"a");
        Thread t2 = new Thread(s,"b");
        
        t1.start();
        t2.start();
    }
    
>>>>>>> origin/master
}
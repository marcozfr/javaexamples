package org.java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import java.util.List;
import java.util.ArrayList;

public class ReentrantReadWrite {

    private List<Integer> list ;
    private ReentrantReadWriteLock rl = new ReentrantReadWriteLock();
    private Integer numberOfRemovals = 0;
    
    public ReentrantReadWrite(List<Integer> list){
        this.list = list;
    }
    
    public Integer getNumberOfRemovals(){
        return numberOfRemovals;
    }
    
    public Integer readSize(){
        Lock read = rl.readLock();
        read.lock();
        try{
            return list.size();
        }finally{
            read.unlock();
        }
    }
    
    public void remove(Integer number){
        Lock write = rl.writeLock();
        write.lock();
        String threadName = Thread.currentThread().getName();
        try{
            boolean removed =  list.remove(number);
            if(removed){
                System.out.println(threadName + " successfully removed "+number);
                numberOfRemovals++;
            }else{
                System.out.println(threadName + " couldn't remove "+number);
            }
            System.out.println(threadName + " Size: "+ readSize());
        }finally{
            write.unlock();
        }
    }
    
    public static void main (String args[]) throws Exception{
        List<Integer> list = new ArrayList<Integer>();
        List<Thread> threads = new ArrayList<Thread>();
        ReentrantReadWrite rd = new ReentrantReadWrite(list);
        for(int i = 0 ; i < args.length ; i ++){
            list.add(Integer.valueOf(args[i]));
            threads.add(new Thread(new MyBucketRemoval(rd,Integer.valueOf(args[i]))));
            threads.add(new Thread(new MyBucketRemoval(rd,Integer.valueOf(args[i]))));
        }

        
        for(int i = 0 ; i < threads.size() ; i ++){
            Thread t = threads.get(i);
            t.start();
        }
        
        Thread.sleep(2000);
        System.out.println("Removals needed: "+rd.getNumberOfRemovals());
        
    }
    
}

class MyBucketRemoval implements Runnable {

        private ReentrantReadWrite rd;
        private Integer itemToRemove;
        
        public MyBucketRemoval(ReentrantReadWrite rd, Integer itemToRemove){
            this.rd= rd;
            this.itemToRemove = itemToRemove;
        }
        
        public void run (){
            rd.remove(itemToRemove);
        }
    }


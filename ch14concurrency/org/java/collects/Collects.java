package org.java.collects;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Collects{
    
    public static void main (String args[]) throws Exception{
        //tryingCopyOnWriteArrays();
        //tryingConcurrents();
        tryingBloquingQueues();
    } 
    
    public static void tryingCopyOnWriteArrays(){
        Collection<Integer> al =  //new CopyOnWriteArrayList<>();
            new CopyOnWriteArraySet<>();
        al.add(4); al.add(16); al.add(9);al.add(4);
        
        for(Integer i : al){
            System.out.print(i+" ");
            al.add(10); // will add but reflected only after iterator is closed
            al.remove(9);
        }
        
        System.out.println();
        for(Integer i : al){
            System.out.print(i+" "); // reflects additions during previous iteration
        }
        
        System.out.println();
        Iterator it = al.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
            //it.remove(); //when using iterator to remove, UnsupportedOperationException is thrown
        }
    }
    
    public static void tryingConcurrents(){
        ConcurrentHashMap<Integer,String> chm = new ConcurrentHashMap<>();
        chm.put(1,"test"); chm.put(6,"best"); 
        chm.put(-1,"nest"); chm.put(4,"fest");
        chm.putIfAbsent(6,"rest");
        
        for(Integer i : chm.keySet()){
            System.out.print(chm.get(i) + " ");
        }
        System.out.println();
        
        // Concurrent Skip List Map and Concurrent Skip List Set are both SORTED BY NATURAL ORDER 
        ConcurrentSkipListMap<Integer, String> cslm = new ConcurrentSkipListMap<>();
        cslm.put(5,"old"); cslm.putIfAbsent(7,"told");
        cslm.putIfAbsent(1,"mold"); cslm.putIfAbsent(4,"sold");
        cslm.putIfAbsent(9,"roll");
        
        for(Integer i : cslm.keySet()){
            System.out.print(cslm.get(i) + " ");
        }
        System.out.println();
        
        ConcurrentSkipListSet<String> csls = new ConcurrentSkipListSet<>();
        csls.add("tone"); csls.add("plutone");
        csls.add("mitone"); csls.add("zutone");
        
        for(String i : csls){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void tryingBloquingQueues(){
        // Bounded queues: ArrayBlockingQueue LinkedBlockingQueue LinkedBlockingDeque(optional-bound)  
        // have method which can block
        // these are ordered FIFO!!
        // these are bounded! have a limited capacity
        try{
            BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(3);
            bq.add(9); // adds if free space available, exception if full
            bq.put(5); // can wait forever if queue is full 
            bq.offer(4,5,TimeUnit.SECONDS); // waits until free space available, on timeout, returns false
            System.out.println(bq.element()); // peeks element, exception if empty
            System.out.println(bq.take()); 
            System.out.println(bq.poll());
            System.out.println(bq.poll());
           // System.out.println(bq.take()); // waiting forever.
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        // SynchronousQueue : Capacitity of 0, will block if insert until other takes the element
        try{
             final SynchronousQueue <String> sq = new SynchronousQueue<String>();
             new Thread(new Runnable(){
                 int count = 0;
                 public void run() {
                     try{
                         while(true){
                             System.out.println(sq.take()); // if no elements, hangs forever
                             System.out.println("took the element, success!");
                             if(++count >= 2){
                                break;
                             }
                         }
                     }catch(Exception e) {System.out.println(e);}
                 }
             }).start();
             sq.put("hello"); // hangs until other thread receives it
             //sq.peek(); // always returns null
             //sq.element(); // exception?? yes. exception always
             Thread.sleep(500);
             System.out.println(sq.poll()); // tries to retrieve, but fails. Already taken by prev thread.
             sq.offer("byebye"); // will only put the element, if some other is waiting.
             System.out.println(sq.poll()); 
            // wowwwwww!!
            
       }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println();
       // DelayQueue 
       // unbounded 
       // elements can only be taken when the delay has expired.
       // elements must implement Delayed
        try{
            Thread.sleep(500);
            DelayQueue<Holder> dq = new DelayQueue<>();
            System.out.println("put into delay queue");
            dq.put(new Holder(4));
            dq.put(new Holder(6));
            System.out.println(dq.take()); // will hang until delay expires. delay is 0 secs
            System.out.println(dq.poll()); // will try to poll
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
       // LinkedTransferQueue supers ConcurrentLinkedQueue, LinkedBlockingQueue, SynchronousQueue
       // and implements TransferQueue, Queue, and wow...
       // unbounded, works like a SynchronousQueue
        // every put , offer or add will add it to the tail of the queue
        // transfer works the same as put in SynchronousQueue                                     
        try{
       final TransferQueue<Integer> tq = new LinkedTransferQueue<Integer>();    
       
       new Thread(new Runnable(){
             int count = 0;
             public void run() {
                 try{
                     while(true){
                         System.out.println(tq.take()); // if no elements, hangs forever
                         System.out.println("transfered the element, success!");
                         if(++count >= 5){
                            break;
                         }
                     }
                 }catch(Exception e) {System.out.println(e);}
             }
         }).start();
        tq.put(13); tq.put(6); tq.offer(32); 
        tq.tryTransfer(16,2,TimeUnit.SECONDS); // will hang until received or timeout, otherwise, objects stays on tail.
        tq.transfer(22); // will hang until is received 
        // tq.transfer(11); // will hang forever, no receivers left.
        }catch(InterruptedException e){
            e.printStackTrace();
        }
       // PriorityBlockingQueue 
    }
    
} 

class Holder implements Delayed {
    public Integer ab;
    Holder(int ab){
        this.ab = ab;
    }
    public String toString(){
        return ab+"";
    }
    public int compareTo(Delayed d){
        return (((Holder)d).ab - this.ab);
    }
    public long getDelay(TimeUnit unit){
        return -1;
    }   

}

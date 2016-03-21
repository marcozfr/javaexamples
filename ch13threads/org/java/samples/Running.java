package org.java.samples;

public class Running {
    public static void main(String [] args) throws InterruptedException{

        Player a = new Player(4);
        Thread t1 = new Thread(a);
        t1.setName("Rick");
        
        
        Thread t2 = new Thread(a);
        t2.setName("Lucy");
        
        Thread t3 = new Thread(a);
        t3.setName("John");
        
        t1.start();
        t2.start();
        t3.start();
        
//        System.out.println("Increment at the end: " + a.getIncrement());
        
//        Thread t3 = new Thread(new Player(7));
//        t3.setName("ply3");
//        t3.setPriority(Thread.MAX_PRIORITY);
//        t3.start();
    }
}
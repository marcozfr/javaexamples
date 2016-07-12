package org.java.sample;

import java.io.*;

public class ExceptionAuto {
    
    public static void main(String args[]){
        
        try(ReadIO r = new ReadIO(); ProxyIO p = new ProxyIO();){
           // r.close();
            System.out.println("operating over object obj");
            throw new MyException();
            
        }catch(MyException | IOException e){
            // p.close(); // p object is out of scope.
            System.out.println("exception "+e.getClass());
            for(Throwable t : e.getSuppressed()){
                System.out.println("suppresed ex "+t.getClass());
            }
        }finally{
            // r.close(); // r object is out of scope.
            System.out.println("finally ");
        }
        
    }
    
}

class ReadIO implements AutoCloseable {
    public void close() throws IOException {
        System.out.println("closing read obj");
        throw new FileNotFoundException();
    }
}

class WriteIO implements Closeable {
    public void close() throws IOException {
        System.out.println("closing write obj");
        
    }
}

class ProxyIO implements AutoCloseable {
    public void close() throws MyException {
        try{
            System.out.println("closing proxy obj");
         throw new MyMyException();
        }finally{
            System.out.println("finnaly proxy obj");
            throw new MyException();
        }
        
    }
}

class MyException extends Exception{
    
}

class MyMyException extends MyException{
    
}
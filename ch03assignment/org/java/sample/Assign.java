package org.java.sample;

import static java.lang.System.out;

import java.io.*;

public class Assign {
    
    public static void myex () throws IOException {
        
    }
    public static void mysec () throws SecException {
        
    }
    public static void main(String ...args) throws MyException{
        try{
            
             myex ();
            mysec();
            throw new Exception();
        }
        catch(MyException | SecException e){
           // e =  new MyException();                                                    
          //  e.printStackTrace();
            throw e;
        }
        catch(Exception ioe){
            ioe = new MyException();
            System.out.println("caught"+ ioe.getClass());
            //ioe.printStackTrace();
            //    throw ioe;
            // throw ioe;
        }
    }
    
}

class MyException extends Exception {
    
}

class SecException extends Exception {
    
}
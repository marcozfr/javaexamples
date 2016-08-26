<<<<<<< HEAD
package org.java.sample;

import java.util.Scanner;
import java.io.IOException;

public class Scan {
    
    public static void main (String... args){
        System.out.print("input: ");
        System.out.flush();
        try(Scanner s = new Scanner(System.in) ) {
            String token = null;
            do{
                token = s.findInLine(args[0]);
                System.out.println("found: "+token);
            }while(token!=null);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
=======
package org.java.sample;

import java.util.Scanner;
import java.io.IOException;

public class Scan {
    
    public static void main (String... args){
        System.out.print("input: ");
        System.out.flush();
        try(Scanner s = new Scanner(System.in) ) {
            String token = null;
            do{
                token = s.findInLine(args[0]);
                System.out.println("found: "+token);
            }while(token!=null);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
>>>>>>> origin/master
}
package org.java.sample;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Tokening {
    
    public static void main (String...args){
        
        Scanner s = new Scanner ("1112.34 basic 0x45 0xaf 123 -900 100000.00");
        s.useDelimiter("\\s");
        while(s.hasNext()){
            if(s.hasNextDouble()){ // it will take integers in the string as doubles!
                System.out.printf(">%(,.4f<d\n", s.nextDouble());    
            } else if(s.hasNextInt()){
                System.out.printf(">%1$(d<i\n", s.nextInt());
            } else {
                System.out.println(">"+s.next()+"<s");    
            }
            
        }
        
        StringTokenizer st = new StringTokenizer(" handling every single code of old systems is a tough work", "\\s");
        System.out.println("token size: "+st.countTokens());
        while(st.hasMoreTokens()){
            System.out.println("tok>"+st.nextToken()+"<tok");
        }
        System.out.println("token size: "+st.countTokens());
        
    }
    
}
<<<<<<< HEAD
package org.java.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Patterns {
    
    public static void main (String args[]){
        //String pattern = readPattern(new File(args[0]));
        String pattern = args[0];
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(args[1]);
        System.out.println("src: "+args[1]);
        System.out.println("idx: 0123456789");
        System.out.println("exp: "+m.pattern());
        while(m.find()){
           System.out.println(m.start()+ " "+m.group()); 
        }
    }
 
    public static String readPattern (File f){
        String a = null;
        try(BufferedReader br = new BufferedReader(new FileReader(f))){
            a = br.readLine();
            System.out.println(a);
        }catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }
    
=======
package org.java.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Patterns {
    
    public static void main (String args[]){
        //String pattern = readPattern(new File(args[0]));
        String pattern = args[0];
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(args[1]);
        System.out.println("src: "+args[1]);
        System.out.println("idx: 0123456789");
        System.out.println("exp: "+m.pattern());
        while(m.find()){
           System.out.println(m.start()+ " "+m.group()); 
        }
    }
 
    public static String readPattern (File f){
        String a = null;
        try(BufferedReader br = new BufferedReader(new FileReader(f))){
            a = br.readLine();
            System.out.println(a);
        }catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }
    
>>>>>>> origin/master
}
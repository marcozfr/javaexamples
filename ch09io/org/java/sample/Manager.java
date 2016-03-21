package org.java.sample;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager{
    
    public static void main (String ...args){
        try {
            String filedir = args[0];
            String subfile = args[1];
            File f = new File(new File(filedir), subfile);
            System.out.println(f.exists());
            new MyReader().enhancedRead(f);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}

class MyReader {
    
    public void read(File f) throws IOException {
        FileReader fr = new FileReader(f);
        char[] chars = new char[1000];
        int size = fr.read(chars);
        System.out.println("read size: "+ size);
        for(char c : chars){
            System.out.print(c);
        }
        fr.close();
    }
    
    public String enhancedRead(File f) throws IOException {
        try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr);){
            //br.close();
            System.out.println(br.readLine());
        //     String a  = null;
        //     while( (a= br.readLine()) !=null ){
        //        System.out.println(a);
        //      }
        }
        //fr.close();
        //fr.close(); // can close multiple times
    }
    
}
package org.java.sample;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.net.URI;
import java.io.IOException;

public class Pathing {
    
    public static void main(String args[]){
        Path p = Paths.get("files","file.log"); Paths.get(URI.create("file:///c:opt/java/ch09io/files/pattern.log"));
        System.out.println(p.toString());
        
        Path a = Paths.get("files","file1");
        Path b = Paths.get("files","file1","file1.log");
        Path c = Paths.get("files","file1","../file2");
        Path d = Paths.get("files","../files/file2/file2.log");
        Path e = Paths.get("./files/file2/file3.log");
        
        try{
            if(Files.notExists(a))Files.createDirectory(a);
            if(Files.notExists(b))Files.createFile(b);
            if(!Files.exists(c))Files.createDirectory(c);
            if(!Files.exists(d))Files.createFile(d);
            System.out.println(a);
            System.out.println(b);
            System.out.println(c.normalize());
            System.out.println(d.normalize());
            System.out.println(Files.copy(d,e,StandardCopyOption.REPLACE_EXISTING).normalize());
        }catch(IOException iee){
            iee.printStackTrace();
        }
    }
    
}
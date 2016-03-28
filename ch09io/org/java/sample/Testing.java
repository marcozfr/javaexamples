package org.java.sample;

import java.nio.file.*;
import java.io.*;
    
public class Testing {
    public static void main (String []args) throws IOException{
        Path p = Paths.get("../tutorials/files");
        Path abs = Paths.get("c:/opt/");
        Path abs1 = Paths.get("c:/rust/relax");
        Path p1 = Paths.get("files");
        //System.out.println(p.subpath(0,01));
        //System.out.println(p.getName(0));
        System.out.println("1:"+p.resolve(abs));
        System.out.println(p.resolve(abs1));
        System.out.println("2:"+p1.relativize(p));
        System.out.println(Files.getLastModifiedTime(p1));
        
        DirectoryStream<Path> ds = Files.newDirectoryStream(p1,"[p]*.???");
        for(Path pes : ds){
            System.out.println(">"+pes.getFileName());
        }
        ds.close();
        
    }
}
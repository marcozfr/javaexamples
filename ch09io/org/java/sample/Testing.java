package org.java.sample;

import java.nio.file.*;
<<<<<<< HEAD
import java.util.concurrent.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.net.URI;

public class Testing {
    
    public static void main (String args[]) throws IOException{
        Path p1 = Paths.get("files");
        
        Files.walkFileTree(p1, new Visitor());
        
        final WatchService ws = FileSystems.getDefault().newWatchService();
        p1.register(ws,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
        
        Thread t1  = new Thread(new Runnable(){
            public void run(){
              while(true){
                  WatchKey key = null;
                  try{
                      key  = ws.poll(1,TimeUnit.MINUTES);
                  }catch(InterruptedException e){ e.printStackTrace();  return;}
                  for(WatchEvent<?> event : key.pollEvents()){
                      WatchEvent.Kind<?> kind = event.kind();
                      System.out.println(event.context()+ " was "+kind.name());
                  }
                  key.reset();
              }  
            }
        });
        t1.start();
    }
    
}

class Visitor extends SimpleFileVisitor<Path>{
    
    private PathMatcher pm = FileSystems.getDefault().getPathMatcher("glob:**/{file1,file2}");
        
    public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes bfa){
        System.out.println("pre visiting directory: "+file);
        if(pm.matches(file)){
            System.out.println("match: "+file);
            return FileVisitResult.SKIP_SIBLINGS; // skip will make post visit to be omitted
        }
        return FileVisitResult.CONTINUE;        
    }
    
    public FileVisitResult visitFile(Path file, BasicFileAttributes bfa){        
        System.out.println("visiting file: "+file);
        if(pm.matches(file)){
            System.out.println("match: "+file);
            //return FileVisitResult.TERMINATE;
        }
        return FileVisitResult.CONTINUE;
    }
    
    public FileVisitResult visitFileFailed(Path file, IOException ioe){
        return FileVisitResult.TERMINATE;
    }
    
    public FileVisitResult postVisitDirectory(Path file, IOException ioe){
        System.out.println("post visiting directory: "+file);
        return FileVisitResult.CONTINUE;
    }
    
=======
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
>>>>>>> origin/master
}
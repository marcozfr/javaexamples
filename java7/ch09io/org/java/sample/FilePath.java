<<<<<<< HEAD
package org.java.sample;

import java.nio.file.PathMatcher;
import java.nio.file.WatchKey;
import java.nio.file.WatchEvent;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.DirectoryStream;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

public class FilePath {
    
    public static void main (String args[]){
       directoryWalk();
        System.out.println();
       fileWalk(); 
        System.out.println();
        matching();
        watchout();
    }
    
    public static void watchout(){
        
        
       
            try{
                Path p1 = Paths.get("files/");

                 WatchService ws = FileSystems.getDefault().newWatchService();
                p1.register(ws,StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE);

                while(true){
                    WatchKey key = //ws.poll(60,TimeUnit.SECONDS);
                        ws.take();

                    for(WatchEvent<?> event : key.pollEvents()){
                        WatchEvent.Kind<?> kind = event.kind();
                        System.out.println(kind.name());
                        System.out.println(event.context());
                    }
                    key.reset(); // if not resetted, would finish at the first item
                }
            }catch(Exception e){
                e.printStackTrace();
            }
       
        
        
    }
    
    public static void matching (){
        Path p1 = Paths.get("/files/file1/t1ny.log");
        Path p2 = Paths.get("aile.res");
        Path p3 = Paths.get("ab/a/ile.res");
        PathMatcher pm = FileSystems.getDefault().getPathMatcher("glob:{/*/**.???}");
        System.out.println(pm.matches(p1));
        System.out.println(pm.matches(p2));
        System.out.println(pm.matches(p3));
    }
    
    public static void directoryWalk (){
        Path path = Paths.get("c://opt/java/ch09io/files");
        try{
            DirectoryStream<Path> ds = Files.newDirectoryStream(path);
            for(Path pa : ds){
                System.out.println(pa.getFileName());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void fileWalk (){
        VisitFiles vf = new VisitFiles();
        Path path = Paths.get("c://opt/java/ch09io/files");
        try{
           Files.walkFileTree(path,vf); 
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

class VisitFiles extends SimpleFileVisitor<Path>{
    public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes bfa){
        System.out.print(file.getParent() + " ::: " +file.getFileName()+ "[pre]");
        if(file.getFileName().toString().endsWith("2")){
            System.out.print(" terminate");
            System.out.println();
            return FileVisitResult.TERMINATE;
        }
        if(file.getFileName().toString().endsWith("1")){
            System.out.print(" skipping subtree");
            System.out.println();
            return FileVisitResult.SKIP_SUBTREE;
        }
        
        System.out.println();
        return FileVisitResult.CONTINUE;
    }
    public FileVisitResult visitFile(Path file, BasicFileAttributes bfa){
        System.out.println(file.getParent() + " ::: " +file.getFileName());
        return FileVisitResult.CONTINUE;
    }
    public FileVisitResult visitFileFailed(Path file, IOException ioe){
        System.out.println(file.getParent() + " ::: " +file.getFileName() + "[failed]");
        return FileVisitResult.CONTINUE;
    }
    public FileVisitResult postVisitDirectory(Path file, IOException ioe){
        System.out.print(file.getParent() + " ::: " +file.getFileName()+ "[post]");
        if(file.getFileName().toString().endsWith("4")){
            System.out.print(" skipping siblings");
            System.out.println();
            return FileVisitResult.SKIP_SIBLINGS;
        }
        System.out.println();
        return FileVisitResult.CONTINUE;
    }
=======
package org.java.sample;

import java.nio.file.PathMatcher;
import java.nio.file.WatchKey;
import java.nio.file.WatchEvent;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.DirectoryStream;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

public class FilePath {
    
    public static void main (String args[]){
       directoryWalk();
        System.out.println();
       fileWalk(); 
        System.out.println();
        matching();
        watchout();
    }
    
    public static void watchout(){
        
        
       
            try{
                Path p1 = Paths.get("files/");

                 WatchService ws = FileSystems.getDefault().newWatchService();
                p1.register(ws,StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE);

                while(true){
                    WatchKey key = //ws.poll(60,TimeUnit.SECONDS);
                        ws.take();

                    for(WatchEvent<?> event : key.pollEvents()){
                        WatchEvent.Kind<?> kind = event.kind();
                        System.out.println(kind.name());
                        System.out.println(event.context());
                    }
                    key.reset(); // if not resetted, would finish at the first item
                }
            }catch(Exception e){
                e.printStackTrace();
            }
       
        
        
    }
    
    public static void matching (){
        Path p1 = Paths.get("/files/file1/t1ny.log");
        Path p2 = Paths.get("aile.res");
        Path p3 = Paths.get("ab/a/ile.res");
        PathMatcher pm = FileSystems.getDefault().getPathMatcher("glob:{/*/**.???}");
        System.out.println(pm.matches(p1));
        System.out.println(pm.matches(p2));
        System.out.println(pm.matches(p3));
    }
    
    public static void directoryWalk (){
        Path path = Paths.get("c://opt/java/ch09io/files");
        try{
            DirectoryStream<Path> ds = Files.newDirectoryStream(path);
            for(Path pa : ds){
                System.out.println(pa.getFileName());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void fileWalk (){
        VisitFiles vf = new VisitFiles();
        Path path = Paths.get("c://opt/java/ch09io/files");
        try{
           Files.walkFileTree(path,vf); 
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

class VisitFiles extends SimpleFileVisitor<Path>{
    public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes bfa){
        System.out.print(file.getParent() + " ::: " +file.getFileName()+ "[pre]");
        if(file.getFileName().toString().endsWith("2")){
            System.out.print(" terminate");
            System.out.println();
            return FileVisitResult.TERMINATE;
        }
        if(file.getFileName().toString().endsWith("1")){
            System.out.print(" skipping subtree");
            System.out.println();
            return FileVisitResult.SKIP_SUBTREE;
        }
        
        System.out.println();
        return FileVisitResult.CONTINUE;
    }
    public FileVisitResult visitFile(Path file, BasicFileAttributes bfa){
        System.out.println(file.getParent() + " ::: " +file.getFileName());
        return FileVisitResult.CONTINUE;
    }
    public FileVisitResult visitFileFailed(Path file, IOException ioe){
        System.out.println(file.getParent() + " ::: " +file.getFileName() + "[failed]");
        return FileVisitResult.CONTINUE;
    }
    public FileVisitResult postVisitDirectory(Path file, IOException ioe){
        System.out.print(file.getParent() + " ::: " +file.getFileName()+ "[post]");
        if(file.getFileName().toString().endsWith("4")){
            System.out.print(" skipping siblings");
            System.out.println();
            return FileVisitResult.SKIP_SIBLINGS;
        }
        System.out.println();
        return FileVisitResult.CONTINUE;
    }
>>>>>>> origin/master
}
package com.example.ws;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class AnnotatedApplication extends Application {
    
    public AnnotatedApplication() {
        System.out.println("instantiating resources");
    }

}

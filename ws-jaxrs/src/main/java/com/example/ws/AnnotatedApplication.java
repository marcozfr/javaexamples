package com.example.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.example.ws.resource.FeaturesResource;

@ApplicationPath("resources")
public class AnnotatedApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(FeaturesResource.class);
        return classes;
    }
}

package com.example.web.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.example.web.resource.CurrenciesResource;

@ApplicationPath("/s")
public class CoreApp extends Application {

//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> classes = new HashSet<>();
//        classes.add(CurrenciesResource.class);
//        return classes;
//    }
}

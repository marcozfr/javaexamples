package com.example.ws.model;

import java.net.URL;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;

public class CustomerBean {
    
    @HeaderParam("backendSystem")
    private String backendSystem;
    
    @HeaderParam("Referer")
    private URL referer;
    
    @FormParam("firstName")
    private String firstName;
    
    @FormParam("lastName")
    private String lastName;

    public String getBackendSystem() {
        return backendSystem;
    }

    public void setBackendSystem(String backendSystem) {
        this.backendSystem = backendSystem;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

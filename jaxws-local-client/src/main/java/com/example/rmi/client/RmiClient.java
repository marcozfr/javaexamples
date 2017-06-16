package com.example.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.example.rmi.RmiServerInterface;

public class RmiClient {
    
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        RmiServerInterface stub = (RmiServerInterface)Naming.lookup("//localhost/RmiServer");
        String response = stub.getMessage("Hello everyone");
        System.out.println(response);
    }

}

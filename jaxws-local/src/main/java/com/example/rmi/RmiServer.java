package com.example.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import com.example.rmi.RmiServerInterface;

public class RmiServer extends UnicastRemoteObject implements RmiServerInterface {

    protected RmiServer() throws RemoteException {
        super(0);
    }
    
    @Override
    public String getMessage(String name) throws RemoteException {
        return "String : " + name ;
    }
    
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        
        RmiServer server = new RmiServer();
        
        Naming.rebind("//localhost/RmiServer", server);
        System.out.println("Server bound in registry");
        
        
    }

}

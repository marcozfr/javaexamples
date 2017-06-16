package com.example.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServerInterface extends Remote {

    public String getMessage(String name) throws RemoteException;
    
}

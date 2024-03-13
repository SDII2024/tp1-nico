package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PotenciadorRemoto extends Remote {
    public Long square(int a) throws RemoteException;
    public Long pow(int a, int b) throws RemoteException;
}

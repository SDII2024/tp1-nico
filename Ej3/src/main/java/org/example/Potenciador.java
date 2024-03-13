package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Potenciador extends UnicastRemoteObject implements PotenciadorRemoto {
    Potenciador() throws RemoteException{};

    @Override
    public Long square(int a) throws RemoteException{
        return (long) Math.sqrt(a);
    }

    @Override
    public Long pow(int a, int b) throws RemoteException{
        return (long) Math.pow(a,b);
    }
}

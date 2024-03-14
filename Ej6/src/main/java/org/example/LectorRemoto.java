package org.example;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface LectorRemoto extends Remote{

    String consultar (int codigo) throws RemoteException;
}

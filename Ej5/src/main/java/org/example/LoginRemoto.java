package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginRemoto extends Remote {

    boolean validar (String usuario,String password) throws RemoteException;
}

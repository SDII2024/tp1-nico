package org.example;

import java.rmi.RemoteException;

public interface LoginRemoto {

    boolean validar (String usuario,String password) throws RemoteException;
}

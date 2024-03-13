package org.example;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalendarioRemoto extends Remote {
    public String consultarFechayHora() throws RemoteException;
}

package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraRemoto extends Remote {
    public Long sumar(long a, long b) throws RemoteException;
    public Long restar(long a, long b) throws RemoteException;
    public Long multiplicar(long a, long b) throws RemoteException;
    public Long dividir(long a, long b) throws RemoteException;
}

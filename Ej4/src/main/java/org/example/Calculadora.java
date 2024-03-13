package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculadora extends UnicastRemoteObject implements CalculadoraRemoto {

    Calculadora() throws RemoteException{
        System.out.println("Calculadora RMI\n");
    }

    @Override
    public Long sumar(long a, long b) throws RemoteException {
        return a+b;
    }
    @Override
    public Long restar(long a, long b) throws RemoteException {
        return a-b;
    }
    @Override
    public Long multiplicar(long a, long b) throws RemoteException {
        return a*b;
    }
    @Override
    public Long dividir(long a, long b) throws RemoteException {
        if(b!=0){
            return a/b;
        }
        return null;
    }
}

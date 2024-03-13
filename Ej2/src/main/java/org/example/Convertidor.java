package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Convertidor extends UnicastRemoteObject implements ConvertidorRemoto{
    Convertidor() throws RemoteException {};

    @Override
    public long PesoDolar (long importe) throws RemoteException {
       return (importe/990);
    }

    @Override
    public long DolarPeso (long importe) throws RemoteException{
        return (importe*990);
    }

}
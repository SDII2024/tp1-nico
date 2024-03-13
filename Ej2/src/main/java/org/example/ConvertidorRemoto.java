package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConvertidorRemoto extends Remote {
    long PesoDolar (long importe) throws RemoteException;

    long DolarPeso (long importe) throws RemoteException;
}

package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Cliente {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        CalendarioRemoto calendario =
                (CalendarioRemoto) Naming.lookup("rmi://localhost:1099/hora-fecha");

        System.out.println ("La fecha y hora actual es: " + calendario.consultarFechayHora());
    }
}

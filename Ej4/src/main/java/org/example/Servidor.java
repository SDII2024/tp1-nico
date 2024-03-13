package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) throws RemoteException
    {
        Registry registro = LocateRegistry.createRegistry(1099);
        Calculadora calculadora = new Calculadora();
        try {
            Naming.rebind ("rmi://localhost:1099/calculadora", calculadora);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        System.out.println("Listo el registro");

    }
}

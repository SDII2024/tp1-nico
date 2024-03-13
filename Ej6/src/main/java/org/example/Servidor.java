package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor {
    static Logger logger = Logger.getLogger(Servidor.class.getName());

    public static void main(String[] args) throws RemoteException {
        LocateRegistry.createRegistry(1099);
        Lector lectorRemoto = new Lector();
        try {
            Naming.rebind("//localhost/LectorRemoto", lectorRemoto);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        logger.info("Listo el registro");
    }

}
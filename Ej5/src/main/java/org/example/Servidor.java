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
        Login loginRemoto = new Login();
        try {
            Naming.rebind("//localhost/LoginRemoto", loginRemoto);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        logger.info("Listo el registro");
    }

}
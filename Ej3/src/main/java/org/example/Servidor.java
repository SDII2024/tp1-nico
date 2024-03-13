package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Servidor {
    public static void main(String[] args) throws RemoteException
    {
        Registry registro = LocateRegistry.createRegistry(1099);
        Potenciador potenciador = new Potenciador();
        try {
            Naming.rebind ("rmi://localhost:1099/potenciador", potenciador);
        } catch (MalformedURLException ex) {

            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        System.out.println("Listo el registro");
    }
}
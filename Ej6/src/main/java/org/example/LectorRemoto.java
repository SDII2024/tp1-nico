package org.example;

import java.rmi.RemoteException;
import java.util.logging.Logger;

public interface LectorRemoto {

    String consultar (int codigo) throws RemoteException;
}

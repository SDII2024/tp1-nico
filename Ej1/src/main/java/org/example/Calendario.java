package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendario extends UnicastRemoteObject implements CalendarioRemoto {
    Calendario() throws RemoteException {}

    @Override
    public String consultarFechayHora() throws RemoteException {
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentDateTime = dateFormat.format(currentDate);

        return currentDateTime;
    }
}

package org.example;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        Scanner sc = new Scanner(System.in);
        ConvertidorRemoto convertidor =
                (ConvertidorRemoto) Naming.lookup("rmi://localhost:1099/convertidor");

        while(true){
            String menu = JOptionPane.showInputDialog("     Convertidor RMI \n\n"
                    + "Ingrese (1).. Peso a Dolar\n"
                    + "Ingrese (2).. Dolar a Peso\n"

                    + "Presione el boton cancelar para salir"); //(char)162=ó

            switch(menu){
                case "1":{
                    Long saldo = Long.parseLong(JOptionPane.showInputDialog("Ingrese el saldo a convertir a Dolares")); //(char)163=ú
                    Long res = convertidor.PesoDolar(saldo);
                    JOptionPane.showMessageDialog(null,"La contidad de dolares es: U$$"+res);
                    break;
                }
                case "2":{
                    Long saldo = Long.parseLong(JOptionPane.showInputDialog("Ingrese el saldo a convertir a Pesos")); //(char)163=ú
                    Long res = convertidor.DolarPeso(saldo);
                    JOptionPane.showMessageDialog(null,"La contidad de pesos es: $"+res);
                    break;
                }
            }
        }
    }
}

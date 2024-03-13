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
        PotenciadorRemoto potenciador =
                (PotenciadorRemoto) Naming.lookup("rmi://localhost:1099/potenciador");

        while (true) {
            String menu = JOptionPane.showInputDialog("     Potenciador RMI \n\n"
                    + "Ingrese (1)..RAIZ CUADRADA\n"
                    + "Ingrese (2)..POTENCIA\n"
                    + "Presione el bot" + (char) 162 + "n cancelar para salir"); //(char)162=ó

            switch (menu) {
                case "1": {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n" + (char) 163 + "mero")); //(char)163=ú
                    Long res = potenciador.square(a);
                    JOptionPane.showMessageDialog(null, "La raiz es: " + res);
                    break;
                }
                case "2": {
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer n" + (char) 163 + "mero")); //(char)163=ú
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo n" + (char) 163 + "mero")); //(char)163=ú
                    Long res = potenciador.pow(a, b);
                    JOptionPane.showMessageDialog(null, "La potencia es: " + res);
                    break;
                }
            }
        }
    }
}

package org.example;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Cliente {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        Scanner sc = new Scanner(System.in);
        CalculadoraRemoto calculadora =
                (CalculadoraRemoto) Naming.lookup("rmi://localhost:1099/calculadora");

        while(true){
            String menu = JOptionPane.showInputDialog("     Calculadora RMI \n\n"
                    + "Ingrese (1)..SUMAR\n"
                    + "Ingrese (2)..RESTAR\n"
                    + "Ingrese (3)..MULTIPLICAR\n"
                    + "Ingrese (4)..DIVIDIR\n"
                    + "Presione el bot"+(char)162+"n cancelar para salir"); //(char)162=ó

            switch(menu){
                case "1":{
                    Long a = Long.parseLong(JOptionPane.showInputDialog("Ingrese el primer n"+(char)163+"mero")); //(char)163=ú
                    Long b = Long.parseLong(JOptionPane.showInputDialog("Ingrese el segundo n"+(char)163+"mero")); //(char)163=ú
                    Long res = calculadora.sumar(a,b);
                    JOptionPane.showMessageDialog(null,"La suma es: "+res);
                    break;
                }
                case "2":{
                    Long a = Long.parseLong(JOptionPane.showInputDialog("Ingrese el primer n"+(char)163+"mero")); //(char)163=ú
                    Long b = Long.parseLong(JOptionPane.showInputDialog("Ingrese el segundo n"+(char)163+"mero")); //(char)163=ú
                    Long res = calculadora.restar(a,b);
                    JOptionPane.showMessageDialog(null,"La resta es: "+res);
                    break;
                }
                case "3":{
                    Long a = Long.parseLong(JOptionPane.showInputDialog("Ingrese el primer n"+(char)163+"mero")); //(char)163=ú
                    Long b = Long.parseLong(JOptionPane.showInputDialog("Ingrese el segundo n"+(char)163+"mero")); //(char)163=ú
                    Long res = calculadora.multiplicar(a,b);
                    JOptionPane.showMessageDialog(null,"El producto es: "+res);
                    break;
                }
                case "4":{
                    Long a = Long.parseLong(JOptionPane.showInputDialog("Ingrese el primer n"+(char)163+"mero")); //(char)163=ú
                    Long b = Long.parseLong(JOptionPane.showInputDialog("Ingrese el segundo n"+(char)163+"mero")); //(char)163=ú
                    Long res = calculadora.dividir(a,b);
                    if(res!=null){
                        JOptionPane.showMessageDialog(null,"La divici"+(char)162+"n es: "+res); //(char)162=ó
                    }else{
                        JOptionPane.showMessageDialog(null,"El segundo n"+(char)163+"mero no puede ser 0"); //(char)163=ú
                    }
                    break;
                }
            }
        }
    }
}
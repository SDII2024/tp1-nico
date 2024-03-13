package org.example;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Cliente {
    private static JTextField codeField;
    private static JButton submitButton;
    private static JLabel statusLabel;

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        crearVentana();
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Lector");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        iniciarComponentes(frame);
        frame.setSize(250, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void iniciarComponentes(JFrame frame) {
        JLabel codeLabel = new JLabel("Código:");
        codeField = new JTextField(20);
        submitButton = new JButton("Ingresar");
        statusLabel = new JLabel("  ");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(codeLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(codeField)))
                .addComponent(submitButton, GroupLayout.Alignment.CENTER)
                .addComponent(statusLabel, GroupLayout.Alignment.CENTER));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(codeLabel)
                        .addComponent(codeField))
                .addComponent(submitButton)
                .addComponent(statusLabel));

        frame.add(panel);
        setListener();
    }

    private static void setListener() {
        submitButton.addActionListener(e -> {
            int nro = Integer.parseInt(codeField.getText());

            try {
                LectorRemoto loginRemoto =
                        (LectorRemoto) Naming.lookup("//localhost/LectorRemoto");
                String res = loginRemoto.consultar(nro);
                if (res!=null) {
                    statusLabel.setText(res); //res tienen que se el producto y precio relacionado al codigo
                } else {
                    statusLabel.setText("El codigo es incorrecto");
                }
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
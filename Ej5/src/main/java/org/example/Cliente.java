package org.example;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Cliente {
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JButton submitButton;
    private static JLabel statusLabel;

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        crearVentana();
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        iniciarComponentes(frame);
        frame.setSize(250, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void iniciarComponentes(JFrame frame) {
        JLabel usernameLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Clave:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
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
                                .addComponent(usernameLabel)
                                .addComponent(passwordLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(usernameField)
                                .addComponent(passwordField)))
                .addComponent(submitButton, GroupLayout.Alignment.CENTER)
                .addComponent(statusLabel, GroupLayout.Alignment.CENTER));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameLabel)
                        .addComponent(usernameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordLabel)
                        .addComponent(passwordField))
                .addComponent(submitButton)
                .addComponent(statusLabel));

        frame.add(panel);
        setListener();
    }

    private static void setListener() {
        submitButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                LoginRemoto loginRemoto =
                        (LoginRemoto) Naming.lookup("//localhost/LoginRemoto");
                boolean validado = loginRemoto.validar(username,password);
                if (validado) {
                    statusLabel.setText("Inicio de sesion exitoso");
                } else {
                    statusLabel.setText("Nombre de usuario o contraseña incorrectos");
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

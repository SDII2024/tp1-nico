package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.logging.Logger;

public class Login extends UnicastRemoteObject implements LoginRemoto{
    String url = "jdbc:sqlite:login.db";
    static Logger logger = Logger.getLogger(org.example.Login.class.getName());
    Login() throws RemoteException { }

    /**
     * "usuario1", "contrasena1"
     * "usuario2", "contrasena2"
     * "usuario3", "contrasena3"
     */

    @Override
    public boolean validar (String usuario,String password) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?")) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }

        return false;
    }

/*
     public static void main(String[] args) throws RemoteException {
         Login login = new Login();
         login.crearTablaBD();
         login.insertarUsuario("usuario1", "contrasena1");
         login.insertarUsuario("usuario2", "contrasena2");
         login.insertarUsuario("usuario3", "contrasena3");
         login.validar("usuario1", "contrasena1");
     }



     public void crearTablaBD(){
         String createTableSQL = "CREATE TABLE IF NOT EXISTS usuarios ("
         + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
         + "nombre TEXT NOT NULL,"
         + "contrasena TEXT NOT NULL"
         + ");";

         try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

             stmt.execute(createTableSQL);
             logger.info("Tabla usuarios creada exitosamente");
         } catch (SQLException e) {
             logger.info(e.getMessage());
         }
     }



     public void insertarUsuario(String nombre, String contrasena) {
         String insertUserSQL = "INSERT INTO usuarios (nombre, contrasena) VALUES (?, ?)";

         try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertUserSQL)) {

             // Insertar usuario y contraseña en la base de datos
             pstmt.setString(1, nombre);
             pstmt.setString(2, contrasena);
             pstmt.executeUpdate();
             logger.info("Usuario insertado correctamente");
         } catch (SQLException e) {
             logger.info(e.getMessage());
         }
     }
*/

}

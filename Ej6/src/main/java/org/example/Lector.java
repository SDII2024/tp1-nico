package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.logging.Logger;

public class Lector extends UnicastRemoteObject implements LectorRemoto {

    String url = "jdbc:sqlite:codigo.db";
    static Logger logger = Logger.getLogger(org.example.Lector.class.getName());
    Lector() throws RemoteException { }

    @Override
    public String consultar (int codigo) {
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("SELECT prod,precio FROM productos WHERE nro = ?")) {
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.wasNull()) {
                return "El producto es: "+ rs.getString("prod") +" y su precio es: "+ rs.getInt("precio");
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) throws RemoteException {
        Lector login = new Lector();
        login.crearTablaBD();
        login.insertarProducto(111111111,"Carne",3000);
        login.insertarProducto(123456789,"Agua",1500);
        login.insertarProducto(987654321,"Pan",1000);
    }


    public void crearTablaBD(){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS productos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nro INT NOT NULL,"
                + "prod TEXT NOT NULL,"
                + "precio INT NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);
            logger.info("Tabla usuarios creada exitosamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    public void insertarProducto(int nro,String prod,int precio) {
        String insertUserSQL = "INSERT INTO productos (nro, prod, precio) VALUES (?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertUserSQL)) {

            // Insertar código en la base de datos
            pstmt.setInt(1, nro);
            pstmt.setString(2, prod);
            pstmt.setInt(3, precio);
            pstmt.executeUpdate();
            logger.info("Codigo insertado correctamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

}






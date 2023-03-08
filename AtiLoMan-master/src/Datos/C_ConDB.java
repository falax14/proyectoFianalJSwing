package Datos;

import javax.swing.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class C_ConDB implements Serializable {
    Connection conexion;

    public Connection conexion() {
        try {
            String[] data;
            C_emDB encryptionManager = new C_emDB();
            data = encryptionManager.readData();

            String servidorDB = data[0];
            String DB = data[1];
            String usuarioDB = data[2];
            String passwordDB = data[3];

            String conector = "com.mysql.cj.jdbc.Driver";
            String jdbc = "jdbc";
            String tipoDB = "mysql";
            String rutaDB = servidorDB + "/" + DB;

            Class.forName(conector);
            conexion = DriverManager.getConnection(jdbc + ":" + tipoDB + "://" + rutaDB + "?allowMultiQueries=true", usuarioDB, passwordDB);

            //System.out.println("Conexion con MySQL establecida\n");
            //JOptionPane.showMessageDialog(null, "Se ha conectado a la DB", "Conexion", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en Base de datos\n\n" + e.getMessage(), "Conexion", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos\n\n" + e.getMessage(), "Datos", JOptionPane.ERROR_MESSAGE);

            throw new RuntimeException(e);
        }
        return conexion;
    }
}

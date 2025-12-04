package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionUsuarios {

    private static final String URL =
        "jdbc:sqlite:Interfaces del proyecto/usuarios.db";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos de usuarios.");
            e.printStackTrace();
            return null;
        }
    }
}

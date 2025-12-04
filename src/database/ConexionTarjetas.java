package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionTarjetas {

    private static final String URL = "jdbc:sqlite:Interfaces del proyecto/tarjetas.db";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

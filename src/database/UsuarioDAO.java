package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public static boolean validarLogin(String id, String password) {
        String sql = "SELECT * FROM usuarios WHERE id = ? AND password = ?";

        try (Connection conn = ConexionUsuarios.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] obtenerDatosUsuario(String id) {
        String sql = "SELECT nombre, apellido, edad, genero FROM usuarios WHERE id = ?";

        try (Connection conn = ConexionUsuarios.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new String[]{
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("edad"),
                        rs.getString("genero")
                };
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

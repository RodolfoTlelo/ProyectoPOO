package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TarjetaDAO {

    public static boolean guardarTarjeta(String idUsuario, String numero,
                                         String expiracion, String cvc) {

        String sql = "INSERT INTO tarjetas(id_usuario, numero, expiracion, cvc) VALUES(?,?,?,?)";

        try (Connection conn = ConexionTarjetas.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idUsuario);
            stmt.setString(2, numero);
            stmt.setString(3, expiracion);
            stmt.setString(4, cvc);

            stmt.executeUpdate();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

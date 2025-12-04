public class TransporteValidator {

    public static boolean validarRuta(String ruta) {
        return ruta != null &&
               (ruta.equals("Puebla") ||
                ruta.equals("Circuito") ||
                ruta.equals("CAPU") ||
                ruta.equals("Prolongacion Reforma")
                ||ruta.equals("Paseo Bravo"));
    }
}

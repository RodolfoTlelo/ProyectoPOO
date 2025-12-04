import java.util.List;

public class MenuComedorValidator {

    public static boolean validarMenu(String sopa, String platoFuerte,
                                      List<String> guarniciones, String postre) {

        if (sopa == null || sopa.isEmpty()) return false;
        if (platoFuerte == null || platoFuerte.isEmpty()) return false;
        if (postre == null || postre.isEmpty()) return false;

        if (guarniciones == null) return false;
        if (guarniciones.size() == 0 || guarniciones.size() > 2) return false;

        return true;
    }
}

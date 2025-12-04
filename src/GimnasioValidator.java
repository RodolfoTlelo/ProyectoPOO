import java.util.Date;

public class GimnasioValidator {

    public static boolean fechaValida(Date fecha) {
        return fecha != null && !fecha.before(new Date());
    }

    public static boolean horaValida(String hora) {
        return hora != null && hora.matches("\\d{2}:\\d{2}");
    }
}

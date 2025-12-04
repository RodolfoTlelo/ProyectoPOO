public class PagoValidator {

    public static boolean validarTarjeta(String numero, String exp, String cvc) {

        if (numero == null || exp == null || cvc == null) return false;

        if (numero.length() != 16) return false;
        if (!exp.matches("\\d{2}/\\d{2}")) return false;
        if (cvc.length() != 3) return false;

        return true;
    }
}

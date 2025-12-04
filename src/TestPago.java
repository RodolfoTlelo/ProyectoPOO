import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestPago {

    @Test
    public void testTarjetaValida() {
        assertTrue(PagoValidator.validarTarjeta("1234567812345678", "12/25", "123"));
    }

    @Test
    public void testTarjetaInvalidaPorLongitud() {
        assertFalse(PagoValidator.validarTarjeta("1234", "12/25", "123"));
    }

    @Test
    public void testExpiracionInvalida() {
        assertFalse(PagoValidator.validarTarjeta("1234567812345678", "1225", "123"));
    }

    @Test
    public void testCvcInvalido() {
        assertFalse(PagoValidator.validarTarjeta("1234567812345678", "12/25", "12"));
    }
}

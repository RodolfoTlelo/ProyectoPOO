import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestTransporte {

    @Test
    public void testRutaCorrecta() {
        assertTrue(TransporteValidator.validarRuta("CAPU"));
    }

    @Test
    public void testRutaIncorrecta() {
        assertFalse(TransporteValidator.validarRuta("Ruta 10"));
    }

    @Test
    public void testRutaNull() {
        assertFalse(TransporteValidator.validarRuta(null));
    }
}

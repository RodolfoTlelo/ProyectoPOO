import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.util.Calendar;

public class TestGimnasio {

    @Test
    public void testFechaFuturaValida() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1); // mañana
        assertTrue(GimnasioValidator.fechaValida(cal.getTime()));
    }

    @Test
    public void testFechaPasadaInvalida() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -2);
        assertFalse(GimnasioValidator.fechaValida(cal.getTime()));
    }

    @Test
    public void testHoraValida() {
        assertTrue(GimnasioValidator.horaValida("14:30"));
    }

    @Test
    public void testHoraInvalida() {
        assertFalse(GimnasioValidator.horaValida("1430"));
    }
}

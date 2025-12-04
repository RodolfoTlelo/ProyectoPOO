import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.util.Arrays;

public class TestMenuComedor {

    @Test
    public void testMenuCorrecto() {
        boolean valido = MenuComedorValidator.validarMenu(
                "Sopa de fideo",
                "Pollo asado",
                Arrays.asList("Arroz", "Ensalada"),
                "Flan"
        );
        assertTrue(valido);
    }

    @Test
    public void testFaltanGuarniciones() {
        boolean valido = MenuComedorValidator.validarMenu(
                "Sopa de fideo",
                "Pollo asado",
                Arrays.asList(),
                "Flan"
        );
        assertFalse(valido);
    }

    @Test
    public void testDemasiadasGuarniciones() {
        boolean valido = MenuComedorValidator.validarMenu(
                "Sopa de fideo",
                "Pollo asado",
                Arrays.asList("Arroz", "Ensalada", "Frijoles"),
                "Flan"
        );
        assertFalse(valido);
    }

    @Test
    public void testFaltaPostre() {
        boolean valido = MenuComedorValidator.validarMenu(
                "Sopa de fideo",
                "Pollo asado",
                Arrays.asList("Arroz", "Ensalada"),
                null
        );
        assertFalse(valido);
    }
}

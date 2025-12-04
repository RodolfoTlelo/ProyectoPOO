import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class PruebaLista extends JFrame {
    private JList<String> listaColores;
    private Container contenedor;

    private final String[] nombresColores = { "Negro", "Azul", "Cian",
        "Gris Oscuro", "Gris", "Verde", "Gris Claro", "Magenta",
        "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo" };

    private final Color[] colores = { Color.BLACK, Color.BLUE, Color.CYAN,
        Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
        Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
        Color.YELLOW };

    public PruebaLista() {
        super("Prueba de JList");

        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        listaColores = new JList<>(nombresColores);
        listaColores.setVisibleRowCount(5);
        listaColores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        contenedor.add(new JScrollPane(listaColores));

        listaColores.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evento) {
                contenedor.setBackground(colores[listaColores.getSelectedIndex()]);
            }
        });

        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PruebaLista();
    }
}
import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    public static CardLayout cardLayout = new CardLayout();
    public static JPanel mainPanel = new JPanel(cardLayout);

    public static String usuarioTipo = "INTERNO";
    public static String usuarioLoggeado = "";

    public static String menuSeleccionado = "";
    public static String rutaSeleccionada = "";
    public static String metodoPagoSeleccionado = "";
    public static String contextoPago = ""; // COMEDOR o TRANSPORTE

    public static MenuPanel menuPanel = new MenuPanel();
    public static MetodoPagoPanel metodoPagoPanel = new MetodoPagoPanel();

    public AppFrame() {

        mainPanel.add(new StartPanel(),              "Start");
        mainPanel.add(new LoginPanel(),              "Login");
        mainPanel.add(menuPanel,                     "Menu");
        mainPanel.add(new ComedorPanel(),            "Comedor");
        mainPanel.add(new SeleccionarComidaPanel(),  "SeleccionarComida");
        mainPanel.add(new TransportePanel(),         "Transporte");
        mainPanel.add(new SeleccionarRutaPanel(),    "SeleccionarRuta");
        mainPanel.add(new GimnasioPanel(),           "Gimnasio");
        mainPanel.add(new PagosPanel(),              "Pagos");
        mainPanel.add(new BiometricosPanel(),        "Biometricos");
        mainPanel.add(metodoPagoPanel,               "MetodoPago");
        mainPanel.add(new RegistroTarjetaPanel(),    "RegistroTarjeta");

        add(mainPanel);

        setTitle("UDLAP App");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        cardLayout.show(mainPanel, "Start");
    }

    public static void irMenu() {
        menuPanel.refreshMenu();
        cardLayout.show(mainPanel, "Menu");
    }

    public static void irMetodoPago() {
        metodoPagoPanel.refresh();
        cardLayout.show(mainPanel, "MetodoPago");
    }
}

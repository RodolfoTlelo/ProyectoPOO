import javax.swing.*;
import java.awt.*;

public class MetodoPagoPanel extends JPanel {

    private JLabel infoLabel;

    public MetodoPagoPanel() {
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel("Método de pago", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        infoLabel = new JLabel("", SwingConstants.CENTER);

        JButton efectivo = new JButton("Pagar con efectivo");
        JButton tarjeta  = new JButton("Pagar con tarjeta");
        JButton back     = new JButton("Regresar");

        efectivo.addActionListener(e -> {
            AppFrame.metodoPagoSeleccionado = "Efectivo";

            String detalle = "";
            if (AppFrame.contextoPago.equals("COMEDOR")) {
                detalle = "Menú: " + AppFrame.menuSeleccionado;
            } else if (AppFrame.contextoPago.equals("TRANSPORTE")) {
                detalle = "Ruta: " + AppFrame.rutaSeleccionada;
            }

            JOptionPane.showMessageDialog(this,
                    "Pago en efectivo registrado.\n" + detalle);

            AppFrame.irMenu();
        });

        tarjeta.addActionListener(e -> {
            AppFrame.metodoPagoSeleccionado = "Tarjeta";
            AppFrame.cardLayout.show(AppFrame.mainPanel, "RegistroTarjeta");
        });

        back.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Menu"));

        add(title);
        add(infoLabel);
        add(efectivo);
        add(tarjeta);
        add(back);
    }

    public void refresh() {
        String texto = "";
        if (AppFrame.contextoPago.equals("COMEDOR")) {
            texto = "<html><center>Vas a pagar comida<br>" +
                    AppFrame.menuSeleccionado + "</center></html>";
        } else if (AppFrame.contextoPago.equals("TRANSPORTE")) {
            texto = "<html><center>Vas a pagar transporte<br>" +
                    "Ruta seleccionada: " + AppFrame.rutaSeleccionada + "</center></html>";
        }
        infoLabel.setText(texto);
    }
}

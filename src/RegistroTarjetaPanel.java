import javax.swing.*;
import java.awt.*;
import database.TarjetaDAO;

public class RegistroTarjetaPanel extends JPanel {

    public RegistroTarjetaPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        JLabel title = new JLabel("Registrar Tarjeta");
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel numLabel = new JLabel("Número de tarjeta:");
        JTextField numField = new JTextField(16);

        JLabel expLabel = new JLabel("Expiración (MM/AA):");
        JTextField expField = new JTextField(5);

        JLabel cvcLabel = new JLabel("CVC:");
        JTextField cvcField = new JTextField(3);

        JButton registrar = new JButton("Registrar y pagar");
        JButton back      = new JButton("Regresar");

        registrar.addActionListener(e -> {

            String numero = numField.getText().trim();
            String exp    = expField.getText().trim();
            String cvc    = cvcField.getText().trim();

            if (!PagoValidator.validarTarjeta(numero, exp, cvc)) {
                JOptionPane.showMessageDialog(this,
                        "Datos de tarjeta inválidos.",
                        "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean guardado = TarjetaDAO.guardarTarjeta(
                    AppFrame.usuarioLoggeado,
                    numero, exp, cvc
            );

            String detalle = "";
            if (AppFrame.contextoPago.equals("COMEDOR")) {
                detalle = "Menú: " + AppFrame.menuSeleccionado;
            } else if (AppFrame.contextoPago.equals("TRANSPORTE")) {
                detalle = "Ruta: " + AppFrame.rutaSeleccionada;
            }

            if (guardado) {
                JOptionPane.showMessageDialog(this,
                        "Tarjeta guardada y pago realizado.\n" + detalle);
                AppFrame.irMenu();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al guardar la tarjeta.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        back.addActionListener(e ->
                AppFrame.irMetodoPago());

        c.gridx = 0; c.gridy = 0; add(title, c);
        c.gridy = 1; add(numLabel, c);
        c.gridy = 2; add(numField, c);
        c.gridy = 3; add(expLabel, c);
        c.gridy = 4; add(expField, c);
        c.gridy = 5; add(cvcLabel, c);
        c.gridy = 6; add(cvcField, c);
        c.gridy = 7; add(registrar, c);
        c.gridy = 8; add(back, c);
    }
}

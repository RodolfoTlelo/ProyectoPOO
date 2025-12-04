import javax.swing.*;
import java.awt.*;

public class SeleccionarRutaPanel extends JPanel {

    public SeleccionarRutaPanel() {

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5,5,5,5);

        JLabel title = new JLabel("Selecciona la ruta");
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JRadioButton r1 = new JRadioButton("Puebla");
        JRadioButton r2 = new JRadioButton("Circuito");
        JRadioButton r3 = new JRadioButton("CAPU");
        JRadioButton r4 = new JRadioButton("Prolongacion Reforma");
        JRadioButton r5 = new JRadioButton("Paseo Bravo");

        ButtonGroup grupoRutas = new ButtonGroup();
        grupoRutas.add(r1); grupoRutas.add(r2);
        grupoRutas.add(r3); grupoRutas.add(r4);
        grupoRutas.add(r5);

        JButton continuar = new JButton("Continuar a pago");
        JButton back      = new JButton("Regresar");

        continuar.addActionListener(e -> {
            String rutaSel = null;
            if (r1.isSelected()) rutaSel = r1.getText();
            if (r2.isSelected()) rutaSel = r2.getText();
            if (r3.isSelected()) rutaSel = r3.getText();
            if (r4.isSelected()) rutaSel = r4.getText();
            if (r5.isSelected()) rutaSel = r5.getText();

            if (!TransporteValidator.validarRuta(rutaSel)) {
                JOptionPane.showMessageDialog(this,
                        "Debes seleccionar una ruta válida.",
                        "Sin ruta", JOptionPane.WARNING_MESSAGE);
                return;
            }

            AppFrame.rutaSeleccionada = rutaSel;
            AppFrame.irMetodoPago();
        });

        back.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Transporte"));

        int row = 0;
        c.gridx = 0; c.gridy = row++; add(title, c);
        c.gridy = row++; add(r1, c);
        c.gridy = row++; add(r2, c);
        c.gridy = row++; add(r3, c);
        c.gridy = row++; add(r4, c);
        c.gridy = row++; add(r5, c);
        c.gridy = row++; add(continuar, c);
        c.gridy = row;   add(back, c);
    }
}

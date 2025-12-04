import javax.swing.*;
import java.awt.*;

public class TransportePanel extends JPanel {

    public TransportePanel() {
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel("Transporte UDLAP", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton rutas   = new JButton("Ver rutas");
        JButton horarios = new JButton("Horarios");
        JButton comprar = new JButton("Comprar boleto");
        JButton back    = new JButton("Regresar");

        rutas.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Rutas disponibles:\nPuebla\nCircuito\nCAPU\nProlongacion Reforma\nPaseo Bravo"));

        horarios.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Salidas de la Univesidad:\n 6:00\n 7:30\n 14:15\n17:40\n20:00"));

        comprar.addActionListener(e -> {
            AppFrame.contextoPago = "TRANSPORTE";
            AppFrame.cardLayout.show(AppFrame.mainPanel, "SeleccionarRuta");
        });

        back.addActionListener(e ->
                AppFrame.irMenu());

        add(title);
        add(rutas);
        add(horarios);
        add(comprar);
        add(back);
    }
}

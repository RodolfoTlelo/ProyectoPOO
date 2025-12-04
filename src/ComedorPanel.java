import javax.swing.*;
import java.awt.*;

public class ComedorPanel extends JPanel {

    public ComedorPanel() {

        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel("Comedor UDLAP", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton horarios = new JButton("Horarios");
        JButton menu     = new JButton("Menú");
        JButton comprar  = new JButton("Comprar comida");
        JButton back     = new JButton("Regresar");

        horarios.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Horarios del comedor\n Lunes a Viernes: 12:00 a 17:00"));

        menu.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Menú de hoy:\n" +
                        "- Sopa de fideo / Sopa de verduras\n" +
                        "- Pollo asado / Bistec a la mexicana\n" +
                        "- Guarniciones: Ensalada, Arroz, Frijoles\n" +
                        "- Postres: Gelatina, Flan"));

        comprar.addActionListener(e -> {
            AppFrame.contextoPago = "COMEDOR";
            AppFrame.cardLayout.show(AppFrame.mainPanel, "SeleccionarComida");
        });

        back.addActionListener(e ->
                AppFrame.irMenu());

        add(title);
        add(horarios);
        add(menu);
        add(comprar);
        add(back);
    }
}

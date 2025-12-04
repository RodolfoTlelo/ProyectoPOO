import javax.swing.*;
import java.awt.*;

public class ServiciosPanel extends JPanel {

    public ServiciosPanel() {
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel("Servicios", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton comedor = new JButton("Comedor");
        JButton gym = new JButton("Gimnasio");
        JButton transporte = new JButton("Transporte");
        JButton back = new JButton("Regresar");

        comedor.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Comedor"));

        transporte.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Transporte"));

        back.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Menu"));

        add(title);
        add(comedor);
        add(gym);
        add(transporte);
        add(back);
    }
}

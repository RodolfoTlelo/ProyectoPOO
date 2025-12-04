import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        setLayout(new GridLayout(7, 1, 10, 10));
        refreshMenu();
    }

    public void refreshMenu() {
        removeAll();
        setLayout(new GridLayout(7, 1, 10, 10));

        JLabel title = new JLabel("Menú Principal", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton comedor    = new JButton("Comedor");
        JButton transporte = new JButton("Transporte");
        JButton gimnasio   = new JButton("Gimnasio");
        JButton pagos      = new JButton("Pagos");
        JButton bio        = new JButton("Datos Biométricos");
        JButton logout     = new JButton("Cerrar Sesión");

        comedor.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Comedor"));

        transporte.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Transporte"));

        gimnasio.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Gimnasio"));

        pagos.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Pagos"));

        bio.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Biometricos"));

        logout.addActionListener(e -> {
            AppFrame.usuarioTipo = "INTERNO";
            AppFrame.usuarioLoggeado = "";
            AppFrame.cardLayout.show(AppFrame.mainPanel, "Start");
        });

        add(title);
        add(comedor);

        if (AppFrame.usuarioTipo.equals("INTERNO")) {
            add(transporte);
            add(gimnasio);
            add(pagos);
            add(bio);
        }

        add(logout);

        revalidate();
        repaint();
    }
}

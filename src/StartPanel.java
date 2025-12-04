import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {

    public StartPanel() {
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel("Selecciona tu tipo de usuario", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton estudiante = new JButton("Estudiante");
        JButton profesor   = new JButton("Profesor");
        JButton trabajador = new JButton("Trabajador");
        JButton externo    = new JButton("Externo");

        estudiante.addActionListener(e -> {
            AppFrame.usuarioTipo = "INTERNO";
            AppFrame.cardLayout.show(AppFrame.mainPanel, "Login");
        });

        profesor.addActionListener(e -> {
            AppFrame.usuarioTipo = "INTERNO";
            AppFrame.cardLayout.show(AppFrame.mainPanel, "Login");
        });

        trabajador.addActionListener(e -> {
            AppFrame.usuarioTipo = "INTERNO";
            AppFrame.cardLayout.show(AppFrame.mainPanel, "Login");
        });

        externo.addActionListener(e -> {
            AppFrame.usuarioTipo = "EXTERNO";
            AppFrame.irMenu();
        });

        add(title);
        add(estudiante);
        add(profesor);
        add(trabajador);
        add(externo);
    }
}

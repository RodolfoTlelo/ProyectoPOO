import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class GimnasioPanel extends JPanel {

    public GimnasioPanel() {

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        JLabel title = new JLabel("Acceso al Gimnasio");
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel fechaLabel = new JLabel("Fecha (DD/MM/AAAA):");
        JTextField fechaField = new JTextField(10);

        JLabel horaLabel = new JLabel("Hora (HH:MM):");
        JTextField horaField = new JTextField(10);

        JButton agendar = new JButton("Agendar");
        JButton back     = new JButton("Regresar");

        agendar.addActionListener(e -> {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = sdf.parse(fechaField.getText());
                if (!GimnasioValidator.fechaValida(fecha)) {
                    JOptionPane.showMessageDialog(this,
                            "La fecha debe ser hoy o una fecha futura.",
                            "Fecha inválida", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Formato de fecha inválido.",
                        "Fecha inválida", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!GimnasioValidator.horaValida(horaField.getText())) {
                JOptionPane.showMessageDialog(this,
                        "La hora debe tener formato HH:MM.",
                        "Hora inválida", JOptionPane.WARNING_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Acceso agendado:\nFecha: " + fechaField.getText()
                            + "\nHora: " + horaField.getText()
            );

            AppFrame.irMenu();
        });

        back.addActionListener(e -> AppFrame.irMenu());

        int row = 0;
        c.gridy = row++; add(title, c);
        c.gridy = row++; add(fechaLabel, c);
        c.gridy = row++; add(fechaField, c);
        c.gridy = row++; add(horaLabel, c);
        c.gridy = row++; add(horaField, c);
        c.gridy = row++; add(agendar, c);
        c.gridy = row;   add(back, c);
    }
}

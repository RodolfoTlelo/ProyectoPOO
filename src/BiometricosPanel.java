import javax.swing.*;
import java.awt.*;

public class BiometricosPanel extends JPanel {

    public BiometricosPanel() {
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel title = new JLabel("Datos Biométricos", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton registrar = new JButton("Registrar Huella / Foto");
        JButton back      = new JButton("Regresar");

        registrar.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Aquí iría el registro biométrico."));

        back.addActionListener(e ->
                AppFrame.irMenu());

        add(title);
        add(registrar);
        add(back);
    }
}

import javax.swing.*;
import java.awt.*;

public class PagosPanel extends JPanel {

    public PagosPanel() {
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("Pagos UDLAP", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton edoCuenta = new JButton("Estado de Cuenta");
        JButton adeudos   = new JButton("Adeudos");
        JButton back      = new JButton("Regresar");

        edoCuenta.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Estado de cuenta..."));

        adeudos.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Adeudos..."));

        back.addActionListener(e ->
                AppFrame.irMenu());

        add(title);
        add(edoCuenta);
        add(adeudos);
        add(back);
    }
}

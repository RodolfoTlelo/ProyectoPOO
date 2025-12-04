import javax.swing.*;
import java.awt.*;
import database.UsuarioDAO;

public class LoginPanel extends JPanel {

    public LoginPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        JLabel title = new JLabel("Login UDLAP");
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);

        JButton loginBtn = new JButton("Ingresar");

        loginBtn.addActionListener(e -> {
            String id = idField.getText();
            String pass = new String(passField.getPassword());

            if (UsuarioDAO.validarLogin(id, pass)) {
                JOptionPane.showMessageDialog(this, "Acceso concedido");
                AppFrame.usuarioLoggeado = id;
                AppFrame.irMenu();
            } else {
                JOptionPane.showMessageDialog(this, "ID o contraseña incorrectos");
            }
        });

        c.gridy = 0; add(title, c);
        c.gridy = 1; add(idLabel, c);
        c.gridy = 2; add(idField, c);
        c.gridy = 3; add(passLabel, c);
        c.gridy = 4; add(passField, c);
        c.gridy = 5; add(loginBtn, c);
    }
}

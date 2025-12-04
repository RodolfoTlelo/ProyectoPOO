import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeleccionarComidaPanel extends JPanel {

    public SeleccionarComidaPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5,5,5,5);

        JLabel title = new JLabel("Selecciona tu menú");
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel sopaLabel = new JLabel("Sopa (elige 1):");
        JRadioButton sopa1 = new JRadioButton("Sopa de fideo");
        JRadioButton sopa2 = new JRadioButton("Sopa de verduras");
        ButtonGroup grupoSopa = new ButtonGroup();
        grupoSopa.add(sopa1); grupoSopa.add(sopa2);

        JLabel platoLabel = new JLabel("Plato fuerte (elige 1):");
        JRadioButton plato1 = new JRadioButton("Pollo asado");
        JRadioButton plato2 = new JRadioButton("Bistec a la mexicana");
        ButtonGroup grupoPlato = new ButtonGroup();
        grupoPlato.add(plato1); grupoPlato.add(plato2);

        JLabel guarLabel = new JLabel("Guarniciones (máx. 2):");
        JCheckBox g1 = new JCheckBox("Ensalada");
        JCheckBox g2 = new JCheckBox("Arroz");
        JCheckBox g3 = new JCheckBox("Frijoles");

        JLabel postreLabel = new JLabel("Postre (elige 1):");
        JRadioButton p1 = new JRadioButton("Gelatina");
        JRadioButton p2 = new JRadioButton("Flan");
        ButtonGroup grupoPostre = new ButtonGroup();
        grupoPostre.add(p1); grupoPostre.add(p2);

        JButton btnContinuar = new JButton("Continuar a pago");
        JButton btnBack      = new JButton("Regresar");

        btnContinuar.addActionListener(e -> {

            String sopaSel = sopa1.isSelected() ? sopa1.getText() :
                             sopa2.isSelected() ? sopa2.getText() : null;

            String platoSel = plato1.isSelected() ? plato1.getText() :
                              plato2.isSelected() ? plato2.getText() : null;

            ArrayList<String> guarn = new ArrayList<>();
            if (g1.isSelected()) guarn.add(g1.getText());
            if (g2.isSelected()) guarn.add(g2.getText());
            if (g3.isSelected()) guarn.add(g3.getText());

            String postreSel = p1.isSelected() ? p1.getText() :
                               p2.isSelected() ? p2.getText() : null;

            if (!MenuComedorValidator.validarMenu(
                    sopaSel, platoSel, guarn, postreSel)) {

                JOptionPane.showMessageDialog(this,
                        "Debes elegir 1 sopa, 1 plato fuerte, 1 postre y 1 o 2 guarniciones.",
                        "Selección inválida", JOptionPane.WARNING_MESSAGE);
                return;
            }

            AppFrame.menuSeleccionado =
                    "Sopa: " + sopaSel +
                    ", Plato: " + platoSel +
                    ", Guarniciones: " + String.join(", ", guarn) +
                    ", Postre: " + postreSel;

            AppFrame.irMetodoPago();
        });

        btnBack.addActionListener(e ->
                AppFrame.cardLayout.show(AppFrame.mainPanel, "Comedor"));

        int row = 0;
        c.gridx = 0; c.gridy = row++; add(title, c);

        c.gridy = row++; add(sopaLabel, c);
        c.gridy = row++; add(sopa1, c);
        c.gridy = row++; add(sopa2, c);

        c.gridy = row++; add(platoLabel, c);
        c.gridy = row++; add(plato1, c);
        c.gridy = row++; add(plato2, c);

        c.gridy = row++; add(guarLabel, c);
        c.gridy = row++; add(g1, c);
        c.gridy = row++; add(g2, c);
        c.gridy = row++; add(g3, c);

        c.gridy = row++; add(postreLabel, c);
        c.gridy = row++; add(p1, c);
        c.gridy = row++; add(p2, c);

        c.gridy = row++; add(btnContinuar, c);
        c.gridy = row;   add(btnBack, c);
    }
}

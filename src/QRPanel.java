import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class QRPanel {

    public static void mostrarQR(String texto, String titulo) {
        try {
            int size = 300;

            BitMatrix matrix = new MultiFormatWriter().encode(
                    texto,
                    BarcodeFormat.QR_CODE,
                    size, size
            );

            BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);

            ImageIcon icon = new ImageIcon(image);

            JLabel label = new JLabel(icon);

            JOptionPane.showMessageDialog(
                    null,
                    label,
                    titulo,
                    JOptionPane.PLAIN_MESSAGE
            );

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error generando QR: " + e.getMessage());
        }
    }
}

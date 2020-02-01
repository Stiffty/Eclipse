package tuermeVonHanoi;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 10, 10);
    }
}

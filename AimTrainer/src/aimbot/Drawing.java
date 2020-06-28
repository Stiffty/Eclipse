package aimbot;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Drawing() {
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.85f));
        //g2d.setColor(getBackground());
        g2d.setColor(new Color(0,0,255,255));
        g2d.fillRect(x1-5,y1-25,10,10);
        g2d.setColor(new Color(0,255,0,255));
        g2d.fillRect(x2-5,y2-25,10,10);
        //System.out.printf("x1: %s y1: %s ; x2: %s y2: %s%n",x1,y1,x2,y2);
    }
}

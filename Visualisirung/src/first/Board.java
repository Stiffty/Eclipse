package first;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class Board extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawDonut(g);
    }

    private void drawDonut(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();
        
        Line2D[] lines = new Line2D[255];
        
        for (int i = 0; i < lines.length; i++) {

        	Line2D e = new Line2D.Double(0, 0, 0, i);
        	lines[i] = e;
		}
        
        //g2d.draw(e);
        for (double deg = 0; deg < lines.length; deg ++) {
        	
            g2d.setStroke(new BasicStroke(1));
            //Color color = new Color((int) Math.sin(deg), 2, (int) Math.cos(deg));
            g2d.setColor(Color.CYAN);
            
            AffineTransform at
                    = AffineTransform.getTranslateInstance(deg,lines.length -deg);
            //at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(lines[(int) deg]));
        }
    }
}

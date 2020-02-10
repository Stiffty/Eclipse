package koordinatenSys3D;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {

    private int nullPosX = 200;
    private int nullPosY = 200;

    private int xwitdh = 100;
    private int ywidth = 100;
    private int zwidth = 100;

    private int width = 4;

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillPolygon(new int[]{120, 80,100,120,100,60}, new int[]{120, 120,80,55,55,60},6);

        g.setColor(Color.GREEN);
        g.fillRect( 80,80,10,10);
        /*Z-Achse*/
        g.setColor(Color.GREEN);
        for (int i = 0; i < zwidth; i++) {
            g.fillRect( ((nullPosX+(nullPosX/4))-i),(nullPosY-(nullPosY/4))+i,width,width);
        }

        /*X-Achse*/
        g.setColor(Color.RED);
        g.fillRect(nullPosX/2,nullPosY,xwitdh*2,width);

        /*Y-Achse Malen*/
        g.setColor(Color.BLUE);
        g.fillRect(nullPosX,nullPosY/2,width,ywidth*2);

        g.setColor(Color.BLACK);
        g.fillRect(nullPosX,nullPosY,width,width);
    }
}

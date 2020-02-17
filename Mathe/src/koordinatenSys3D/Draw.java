package koordinatenSys3D;

import javafx.geometry.Point3D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Draw extends JPanel {

    private Graphics g;

    private int nullPosX = 200;
    private int nullPosY = 200;

    private int xwitdh = 100;
    private int ywidth = 100;
    private int zwidth = 100;

    private int width = 4;


    private Math m = new Math();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;

        init();

        drawAchses(g);
        m.drawBox(50, 50, 50, 100);
//        m.rotateAllX(0.001);
//        m.rotateAllY(0.001);
//        m.rotatePointXY(0.001,7);

//        m.drawBox(-200, 20, 20, 40);
//        m.drawBox(200, 200, 20, 40);
//        m.drawBox(-200, -200, 20, 40);
       //m.addPoint(30,40,50);
        m.getConnectPoints();

        m.setInitDone(true);
        //addPoint(-30,20,10);
    }


    private void drawAchses(Graphics g) {
        /*X-Achse*/

        g.setColor(Color.GREEN);
        for (int i = 0; i < zwidth; i++) {
            g.fillRect(calculatePosforXx(i), calculatePosforXy(i), width, width);
        }

        g.setColor(Color.BLACK);
        g.drawString("X -", calculatePosforXx(0), calculatePosforXy(0));
        g.drawString("X +", calculatePosforXx(zwidth + 10), calculatePosforXy(zwidth + 10));

        /*Y-Achse*/
        g.setColor(Color.RED);
        g.fillRect(nullPosX / 2, nullPosY, xwitdh * 2, width);

        g.drawString("Y-", nullPosX / 2, nullPosY);
        g.drawString("Y+", (nullPosX / 2) + xwitdh * 2, nullPosY);

        /*Z-Achse*/
        g.setColor(Color.BLUE);
        g.fillRect(nullPosX, nullPosY / 2, width, ywidth * 2);

        g.setColor(Color.BLACK);
        g.drawString("Z-", nullPosX, nullPosY / 2);
        g.drawString("Z+", nullPosX + width, (nullPosY / 2) + ywidth * 2);

        g.setColor(Color.BLACK);
        g.fillRect(nullPosX, nullPosY, width, width);
    }

    private void init() {
        if (getWidth() > getHeight()) {
            this.setBounds(getX(), getY(), getWidth(), getWidth());
        } else {
            this.setBounds(getX(), getY(), getHeight(), getHeight());
        }

        nullPosX = this.getWidth() / 2;
        nullPosY = this.getHeight() / 2;

        xwitdh = nullPosX / 2;
        ywidth = nullPosY / 2;
        zwidth = nullPosX / 2;

        m.setG(g);
        m.setNullPosX(nullPosX);
        m.setNullPosY(nullPosY);
    }


    private int calculatePosforXy(int i) {
        return (nullPosY - (nullPosY / 4)) + i;
    }

    private int calculatePosforXx(int i) {
        return (nullPosX + (nullPosX / 4)) - i;
    }
}
//        addPoint(60, 0, 0);
//        addPoint(60, 60, 0);
//        addPoint(0, 60, 0);
//        addPoint(0, 0, 0);
//
//        addPoint(60, 60, 60);
//        addPoint(60, 0, 60);
//        addPoint(0, 0, 60);
//        addPoint(0, 60, 60);
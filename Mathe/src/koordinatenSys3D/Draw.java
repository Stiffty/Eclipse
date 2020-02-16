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

    private int pointcounter = 0;
    private List<Point> points = new ArrayList<>();

    private final boolean showPointInfo = false;
    private boolean initDone = false;
    private int anzahlpunkte = -1;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.g = g;

        init();

        drawAchses(g);

//        addPoint(60, 0, 0);
//        addPoint(60, 60, 0);
//        addPoint(0, 60, 0);
//        addPoint(0, 0, 0);
//
//        addPoint(60, 60, 60);
//        addPoint(60, 0, 60);
//        addPoint(0, 0, 60);
//        addPoint(0, 60, 60);
        drawBox(60,40,80,60);
        initDone = true;
        //addPoint(-30,20,10);



        System.out.println(pointcounter);
    }

    public void drawBox(int x, int y,int z, int height){

        addPoint(x+height, y, z);
        addPoint(x+height, y+height, z);
        addPoint(x, y+height, z);
        addPoint(x, y, z);

        addPoint(x+height, y+height, z+height);
        addPoint(x+height, y, z+height);
        addPoint(x, y, z+height);
        addPoint(x, y+height, z+height);

        drawFläche(points.get(0), points.get(1), points.get(2), points.get(3));
        g.setColor(Color.BLUE);
        drawFläche(points.get(4), points.get(5), points.get(6), points.get(7));
        g.setColor(Color.RED);
        drawFläche(points.get(0), points.get(1), points.get(4), points.get(5));
        g.setColor(Color.CYAN);
        drawFläche(points.get(1), points.get(2), points.get(7), points.get(6));
        g.setColor(Color.GREEN);
        drawFläche(points.get(3), points.get(2), points.get(7), points.get(6));
        g.setColor(Color.MAGENTA);
        drawFläche(points.get(0), points.get(3), points.get(6), points.get(5));
    }

    public void drawFläche(Point... p) {
        int[] y = new int[p.length];
        int[] z = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            y[i] = (int) p[i].getX();
            z[i] = (int) p[i].getY();
        }

        g.fillPolygon(y, z, p.length);
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
    }

    public void addPoint(int x, int y, int z) {

        double zP = nullPosX + (x / 2D);
        double yP = nullPosY - (x / 2D);

        yP += y;
        zP += z;
        System.out.printf("yP: %s zP: %s%n", yP, zP);

        if (showPointInfo) {
            g.fillRect((int) yP, (int) zP, 10, 10);
            g.drawString("P" + pointcounter + "(" + x + "/" + y + "/" + z + "/" + ")", (int) yP, (int) zP);
        }

        if (!initDone) {
            points.add(new Point(yP, zP));
            pointcounter++;
        } else {
            if(anzahlpunkte == -1){
                anzahlpunkte = pointcounter;
            }
            if(pointcounter == anzahlpunkte){
                pointcounter = 0;
            }
            Point p = points.get(pointcounter);

            p.setX(yP);
            p.setY(zP);
            pointcounter++;
        }
    }

    private int calculatePosforXy(int i) {
        return (nullPosY - (nullPosY / 4)) + i;
    }

    private int calculatePosforXx(int i) {
        return (nullPosX + (nullPosX / 4)) - i;
    }

}

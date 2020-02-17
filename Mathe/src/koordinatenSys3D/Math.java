package koordinatenSys3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Math {

    private int nullPosX = 200;
    private int nullPosY = 200;

    private int pointcounter = 0;
    private List<Point> points = new ArrayList<>();

    private final boolean showPointInfo = true;
    private final boolean showFläche = true;
    //Do not touch!!
    private boolean initDone = false;
    private int anzahlpunkte = -1;

    private Graphics g;

    public Math() {

    }

    public void rotateAllY(double angle) {
        if (initDone) {
            for (Point p : points
            ) {
                double z = p.getzO();
                double x = p.getxO();

                p.setxO((x * java.lang.Math.cos(angle) - (z * java.lang.Math.sin(angle))));
                p.setzO((z * java.lang.Math.cos(angle) + (x * java.lang.Math.sin(angle))));

            }
        }
    }

    public void rotateAllX(double angle) {
        if (initDone) {
            for (Point p : points
            ) {
                double z = p.getzO();
                double y = p.getyO();

                p.setyO((y * java.lang.Math.cos(angle) - (z * java.lang.Math.sin(angle))));
                p.setzO((z * java.lang.Math.cos(angle) + (y * java.lang.Math.sin(angle))));

            }
        }
    }

    public void rotatePointXY(double angle, int pointIndex) {

        Point p = points.get(pointIndex);

        double z = p.getzO();
        double x = p.getxO();
        double y = p.getyO();
        for (int i = 0; i < 5000; i++) {
            x = (x * java.lang.Math.cos(angle) - (z * java.lang.Math.sin(angle)));
            z = (z * java.lang.Math.cos(angle) + (x * java.lang.Math.sin(angle)));

            y = ((y * java.lang.Math.cos(angle) - (z * java.lang.Math.sin(angle))));
            z = ((z * java.lang.Math.cos(angle) + (y * java.lang.Math.sin(angle))));

            double zP = nullPosX + (x / 2D);
            double yP = nullPosY - (x / 2D);

            yP += y;
            zP += z;

            g.fillRect((int) yP, (int) zP, 1, 1);
        }
//                double y = p.getyO();
//
//                p.setyO((y * java.lang.Math.cos(angle) - (z * java.lang.Math.sin(angle))));
//                p.setzO((z * java.lang.Math.cos(angle) + (y * java.lang.Math.sin(angle))));
    }

    public void drawBox(int x, int y, int z, int height) {

        g.setColor(Color.RED);
        addPoint(x + height, y, z);
        g.setColor(Color.PINK);
        addPoint(x + height, y + height, z);
        g.setColor(Color.ORANGE);
        addPoint(x, y + height, z);
        g.setColor(Color.YELLOW);
        addPoint(x, y, z);

        g.setColor(Color.BLACK);
        addPoint(x + height, y + height, z + height);
        g.setColor(Color.GRAY);
        addPoint(x + height, y, z + height);
        g.setColor(Color.GREEN);
        addPoint(x, y, z + height);
        g.setColor(Color.BLUE);
        addPoint(x, y + height, z + height);

        if (showFläche) {
            drawFläche(points.get(pointcounter - 8), points.get(pointcounter - 7), points.get(pointcounter - 6), points.get(pointcounter - 5));
            g.setColor(Color.BLUE);
            drawFläche(points.get(pointcounter - 4), points.get(pointcounter - 3), points.get(pointcounter - 2), points.get(pointcounter - 1));
            g.setColor(Color.RED);
            drawFläche(points.get(pointcounter - 8), points.get(pointcounter - 7), points.get(pointcounter - 4), points.get(pointcounter - 3));
            g.setColor(Color.CYAN);
            drawFläche(points.get(pointcounter - 7), points.get(pointcounter - 6), points.get(pointcounter - 1), points.get(pointcounter - 2));
            g.setColor(Color.GREEN);
            drawFläche(points.get(pointcounter - 5), points.get(pointcounter - 6), points.get(pointcounter - 1), points.get(pointcounter - 2));
            g.setColor(Color.MAGENTA);
            drawFläche(points.get(pointcounter - 8), points.get(pointcounter - 5), points.get(pointcounter - 2), points.get(pointcounter - 3));
        }else{
            drawFläche(points.get(pointcounter - 8), points.get(pointcounter - 7), points.get(pointcounter - 6), points.get(pointcounter - 5));
        }
    }

    public void getConnectPoints(){
        int[][] connections = new int[6][4];

        int x1 = 0;
        int x2 = 0;

        int y1 = 0;
        int y2 = 0;

        int z1 = 0;
        int z2 = 0;

        for (Point p :
                points) {
           if(p.getxO() == x1){
               x1 = (int) p.getxO();
           }else if(p.getxO() != x1){
               x2 = (int) p.getxO();
           }

        }
    }

//    public void getConnectPoints(){
//        int [][][] connections = new int[6][4][2];
//
//        for (int i = 0; i < connections.length; i++) {
//            for (int j = 0; j < connections[0].length; j++) {
//                for (int k = 0; k < connections[0][0].length; k++) {
//                    connections[i][j][k] = -1;
//                }
//            }
//        }
//
//        for (int i = 0; i < points.size(); i++) {
//            Point p = points.get(i);
//
//            for (int j = 0; j < connections.length; j++) {
//                for (int k = 0; k < connections[0].length; k++) {
//                    for (int l = 0; l < 1; l++) {
//                        if(connections[j][k][l] == -1){
//                            connections[j][k][l] = i;
//                            connections[j][k][l+1] = (int) p.getxO();
//                            break;
//                        }else{
//
//                        }
//                    }
//                }
//            }
//        }
//    }

    public void drawFläche(Point... p) {
        int[] y = new int[p.length];
        int[] z = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            y[i] = (int) p[i].getX();
            z[i] = (int) p[i].getY();
        }

        g.fillPolygon(y, z, p.length);
    }

    public void addPoint(int x, int y, int z) {

        if (initDone) {
            Point point = points.get(pointcounter - 1);
            x = (int) point.getxO();
            y = (int) point.getyO();
            z = (int) point.getzO();
        }
        double zP = nullPosX + (x / 2D);
        double yP = nullPosY - (x / 2D);

        yP += y;
        zP += z;
        //System.out.printf("yP: %s zP: %s%n", yP, zP);

        if (showPointInfo) {
            g.fillRect((int) yP, (int) zP, 10, 10);
            g.drawString("P" + pointcounter + "(" + x + "/" + y + "/" + z + "/" + ")", (int) yP, (int) zP);
            g.drawLine(nullPosX, nullPosY, (int) yP, (int) zP);
        }

        if (!initDone) {
            points.add(new Point(yP, zP, x, y, z));
            pointcounter++;
        } else {
            if (anzahlpunkte == -1) {
                anzahlpunkte = pointcounter;
            }
            if (pointcounter == anzahlpunkte) {
                pointcounter = 0;
            }
            Point p = points.get(pointcounter);

            p.setX(yP);
            p.setY(zP);
            pointcounter++;
        }
    }

    public int getNullPosX() {
        return nullPosX;
    }

    public void setNullPosX(int nullPosX) {
        this.nullPosX = nullPosX;
    }

    public int getNullPosY() {
        return nullPosY;
    }

    public void setNullPosY(int nullPosY) {
        this.nullPosY = nullPosY;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public boolean isInitDone() {
        return initDone;
    }

    public void setInitDone(boolean initDone) {
        this.initDone = initDone;
    }
}

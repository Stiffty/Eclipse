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
    private int boxanzahl = anzahlpunkte / 8;

    Integer[][] connections = null;

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

        if (connections == null) {
            getConnectPoints();
//            sortpoints();
        }

        if (showFläche) {
            countxByPoints();
            g.setColor(Color.ORANGE);
            drawFläche(points.get(connections[0][0]), points.get(connections[0][1]), points.get(connections[0][2]), points.get(connections[0][3]));
//            g.setColor(Color.BLUE);
//            drawFläche(points.get(connections[1][0]), points.get(connections[1][1]), points.get(connections[1][2]), points.get(connections[1][3]));
//            g.setColor(Color.RED);
//            drawFläche(points.get(connections[2][0]), points.get(connections[2][1]), points.get(connections[2][2]), points.get(connections[2][3]));
//            g.setColor(Color.CYAN);
//            drawFläche(points.get(connections[3][0]), points.get(connections[3][1]), points.get(connections[3][2]), points.get(connections[3][3]));
//            g.setColor(Color.GREEN);
//            drawFläche(points.get(connections[4][0]), points.get(connections[4][1]), points.get(connections[4][2]), points.get(connections[4][3]));
//            g.setColor(Color.MAGENTA);
//            drawFläche(points.get(connections[5][0]), points.get(connections[5][1]), points.get(connections[5][2]), points.get(connections[5][3]));
        }
    }

    private void countxByPoints(){
        for (int i = 0; i < connections.length; i++) {
            int counter = 0;
            for (int j = 0; j < connections[0].length-1; j++) {
                counter += points.get(connections[i][j]).getxO();
            }
            connections[i][4] = counter;
        }
    }

    public void sortpoints() {
        for (int i = 0; i < connections.length; i++) {
            if (!comparePoints(i, 1,  2)) {
                Point p = points.get(connections[i][3]);
                points.set(connections[i][3],points.get(connections[i][2]));
                points.set(connections[i][2],p);
            }

        }
    }

    private boolean comparePoints(int generalIndex, int index1, int index2) {
        Point p1 = points.get(connections[generalIndex][index1]);
        Point p2 = points.get(connections[generalIndex][index2]);

        switch (generalIndex) {
            case 0:
            case 1:
                if (p1.getzO() == p2.getzO() || p1.getyO() == p2.getyO()) {
                    return true;
                }
                break;

            case 2:
            case 3:
                if (p1.getzO() == p2.getzO() || p1.getxO() == p2.getxO()) {
                    return true;
                }
                break;

            case 4:
            case 5:
                if (p1.getyO() == p2.getyO() || p1.getxO() == p2.getxO()) {
                    return true;
                }
                break;
        }
        return false;
    }

    public void getConnectPoints() {
        connections = new Integer[6][5];

        boolean finished1 = false;
        boolean finished2 = false;
        boolean finished3 = false;
        boolean finished4 = false;
        boolean finished5 = false;
        boolean finished6 = false;

        int x1 = 0;
        int x2 = 0;

        int y1 = 0;
        int y2 = 0;

        int z1 = 0;
        int z2 = 0;

        for (Point p :
                points) {
            if (p.getxO() != x1 && !finished1) {
                x1 = (int) p.getxO();
                finished1 = true;
            } else if ((p.getxO() != x2 && !finished2) || x1 == x2) {
                x2 = (int) p.getxO();
                finished2 = true;
            }

            if (p.getyO() != y1 && !finished3) {
                y1 = (int) p.getyO();
                finished3 = true;
            } else if ((p.getyO() != y2 && !finished4) || y1 == y2) {
                y2 = (int) p.getyO();
                finished4 = true;
            }

            if (p.getzO() != z1 && !finished5) {
                z1 = (int) p.getzO();
                finished5 = true;
            } else if ((p.getzO() != z2 && !finished6) || z1 == z2) {
                z2 = (int) p.getzO();
                finished6 = true;
            }
        }

        //For 1 Box also
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);

            if (p.getxO() == x1) {
                connections[0][getFirstEmptyIndex(connections, 0)] = i;
            } else if (p.getxO() == x2) {
                connections[1][getFirstEmptyIndex(connections, 1)] = i;
            }

            if (p.getyO() == y1) {
                connections[2][getFirstEmptyIndex(connections, 2)] = i;
            } else if (p.getyO() == y2) {
                connections[3][getFirstEmptyIndex(connections, 3)] = i;
            }

            if (p.getzO() == z1) {
                connections[4][getFirstEmptyIndex(connections, 4)] = i;
            } else if (p.getzO() == z2) {
                connections[5][getFirstEmptyIndex(connections, 5)] = i;
            }
        }

    }

    private int getFirstEmptyIndex(Integer con[][], int index) {
        for (int i = 0; i < con[index].length; i++) {
            if (con[index][i] == null) {
                return i;
            }
        }
        return -1;
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
            if (anzahlpunkte == -1) {
                anzahlpunkte = pointcounter;
            }
            if (pointcounter == anzahlpunkte) {
                pointcounter = 0;
            }

            Point point = points.get(pointcounter);
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

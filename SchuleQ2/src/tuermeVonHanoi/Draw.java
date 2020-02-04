package tuermeVonHanoi;

import stack.Node;
import stack.Stack;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Draw extends JPanel {

    private List<Stack<Disk>> sticks = new ArrayList<>();

    /*Base Generation*/
    private int baseX = 10;
    private int baseY = 400;
    private int baseWidth = 480;
    private int baseHeight = 30;

    private int stickAmount = 3;
    private int[] stickPos = new int[stickAmount];
    private int[] stickPosY = new int[stickAmount];
    private int[] stickHeight = new int[stickAmount];
    private int[] stickWidth = new int[stickAmount];

    private int diskAmount = 8;
    private int diskOffset = 20;

    /*-----Animation------*/
    private double x = -20;
    private double xMin = -80;
    private double xMax = 90;

    private double stretch = 40;
    private double c;
    private double a;
    private double moveOffset = 0.01;
    private int objectSizeWidth = 30;
    private int objectSizeHeight = 30;

    private double xOffset = 100;
    private double yOffset = 400;

    private boolean finished = false;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (sticks.size() == 0)
            generatePlayGround(g);

        drawBase(g);

        drawDisks(g);

        debugMove(g);

        //testCalculation(-1,1,3,-1,5,7);
        //testCalculation(-4/3, -7/3, 4/3, 3, 2,1);

    }

    private void debugMove(Graphics g) {
        Random rand = new Random();

        int r = rand.nextInt(sticks.size());
        if (!sticks.get(r).isEmpty()) {
            int r2 = rand.nextInt(sticks.size() );
            if (r2 != r) {
                Disk d = sticks.get(r).peek();

                xOffset = ((stickPos[r] + stickPos[r2]) / 2) + (stickWidth[0] / 2);
                yOffset = ((baseY / 2) + (d.getHeight() * calculateDiskHeight(0)));

                Disk d2 = d;

                d.setX(calculateDiskX(r2, d));
                d.setY(calculateDiskY(r2, sticks.get(r2).length()));

                double[] poses = calculatePosX(r,r2);
                animation(g,poses[0],calculatePosY(calculateDiskY(r, sticks.get(r).length())),poses[1],calculatePosY(calculateDiskY(r2, sticks.get(r2).length())),0,-400);
               //animation(g,d.getX(),d.getY(),d2.getX(),d2.getY(),10,10);

                sticks.get(r).pop();


                System.out.printf("(Debug) x1 = %s y1 = %s x2 = %s y2 = %s x3 = %s x4= %s %n",poses[0],calculatePosY(calculateDiskY(r, sticks.get(r).length())),poses[1],calculatePosY(calculateDiskY(r2, sticks.get(r2).length())),xOffset,yOffset);

                sticks.get(r2).push(d);

                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void drawBase(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(baseX, baseY, baseWidth, baseHeight);

        for (int i = 0; i < stickAmount; i++) {
            g.fillRect((baseWidth / stickAmount) * (i + 1) - (baseWidth / (stickAmount * 2)), baseY, baseWidth / (stickAmount * 10), baseHeight * -5);
        }
    }

    private void drawDisks(Graphics g) {
        for (Stack<Disk> stack : sticks
        ) {
            if (!stack.isEmpty()) {
                Node<Disk> n = stack.getTOP();
                for (int i = 0; i < stack.length(); i++) {
                    Disk d = n.getData();
                    g.setColor((d.getColor()));
                    g.fillRect(d.getX(), d.getY(), d.getWidth(), d.getHeight());
                    n = n.getNext();
                }
            }
        }
    }

    private int calculateDiskX(int index, Disk d) {
        return (stickPos[index] - (((baseWidth / stickAmount) - (diskOffset * d.getSize())) / 2)) + (stickWidth[index] / 2);
    }

    private int calculateDiskY(int stick, int height) {
        return baseY + ((stickHeight[stick] / diskAmount) * (height));
    }

    private int calculateDiskWidth(Disk d) {
        return (baseWidth / stickAmount) - (diskOffset * d.getSize());
    }

    private int calculateDiskHeight(int index) {
        return stickHeight[index] / diskAmount;
    }

    private void generatePlayGround(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(baseX, baseY, baseWidth, baseHeight);

        for (int i = 0; i < stickAmount; i++) {
            g.fillRect((baseWidth / stickAmount) * (i + 1) - (baseWidth / (stickAmount * 2)), baseY, baseWidth / (stickAmount * 10), baseHeight * -5);

            stickPos[i] = (baseWidth / stickAmount) * (i + 1) - (baseWidth / (stickAmount * 2));
            stickHeight[i] = baseHeight * -5;
            stickWidth[i] = baseWidth / (stickAmount * 10);

            sticks.add(new Stack<Disk>());
        }


        for (int i = 0; i < diskAmount; i++) {

            Disk d = new Disk(new Color(
                    (int) ((Math.sin(i) + 1) / 2 * 255),
                    (int) ((Math.cos(i) + 1) / 2 * 255),
                    (int) ((-Math.sin(i) + 1) / 2 * 255)
            ), (stickPos[0] - (((baseWidth / stickAmount) - (diskOffset * i)) / 2)) + (stickWidth[0] / 2), baseY + ((stickHeight[0] / diskAmount) * (i)), (baseWidth / stickAmount) - (diskOffset * i), stickHeight[0] / diskAmount, i);

            sticks.get(0).push(d);

//            g.setColor(new Color(
//                    (int)((Math.sin(i)+1)/2*255),
//                    (int)((Math.cos(i)+1)/2*255),
//                    (int)((-Math.sin(i)+1)/2*255)
//            ));
//            g.fillRect((((baseWidth/stickAmount)*(1)-(baseWidth/(stickAmount*2)))-((baseWidth/stickAmount)-(diskOffset*(i+1)))/2)-2,baseY-((diskOffset)*(i+1)),(baseWidth/stickAmount)-(diskOffset*i), (int) (diskAmount*2.5));
        }
    }

    private void testCalculation(double x1, double y1, double x2, double y2, double x3 ,double y3) {
        double b1 = 1;
        double b2 = 1;
        double b3 = 1;

        double b4 = 1;
        double b5= 1;

        double a1 = 1;
        double a2 = 1;
        double a3 = 1;

        double a4 = 1;
        double a5 = 1;

        double bf = 0;
        double cf = 0;
        double af = 0;
        double yf = 0;

        b1 = b1 * x1;
        a1 = Math.pow(x1, 2);

        b2 = b2 * x2;
        a2 = Math.pow(x2, 2);

        b3 = b3 * x3;
        a3 = Math.pow(x3, 2);

        a4 = a2-a1;
        b4 = b2-b1;
        y1 = y2-y1;

        a5 = a3-a2;
        b5 = b3-b2;
        y2 = y3-y2;

        a5 = a5*-(b4/b5);
        y2 = y2*-(b4/b5);
        b5 = b5*-(b4/b5);

        af = (y1+y2)/(a4+a5);

        bf = (y1-(a4*af))/b4;

        cf = y3-((af*a3)+(bf*x3));


//        y1 = y1 - x1;
//        y2 = y2 - x2;
//
//
//        bf = b2 - b1;
//        yf = y2 - y1;
//
//        bf = yf / bf;
//
//        if ((b1 * bf) > 0) {
//            cf = y1 - (b1 * bf);
//        } else {
//            cf = y1 + (b1 * bf);
//        }

        stretch = bf;
        c = cf;
        a = af;
        System.out.printf("(Debug) 1: b1 = %s x1 = %s y1 = %s a1 = %s 2: b2 = %s x2 = %s y2 = %s a2 = %s 3: b3 = %s x3 = %s y3 = %s a3 = %s Final: b = %s y = %s c = %s a = %s%n", b1, x1, y1,a1, b2, x2, y2,a2,b3, x3, y3,a3, bf, yf, cf,af);
        System.out.printf("(Debug) 4: b4 = %s a4 = %s 5: b5 = %s a5 = %s%n",b4,a4,b5,a5);
    }

    private double[] calculatePosX(int stick,int stick1){
        double mid = (stickPos[stick] + stickPos[stick1]) / 2;
        double[] poses = new double[2];
        poses[0] = stickPos[stick]-mid;
        poses[1] = stickPos[stick1]-mid;
        return  poses;
    }

    private double calculatePosY(int y){
        System.out.println(y);
        return  (baseY+stickHeight[0])-y;
    }

    private void animation(Graphics g, double x1, double y1, double x2, double y2,double x3, double y3) {

        if (xMin == 0 && xMax == 0) {
            //xMin = stickPos[0]-stickPos[1];
            //xMax = stickPos[1]-stickPos[0];
            //x = stickPos[0]-stickPos[1];

        }

        testCalculation(x1,y1,x2,y2,x3,y3);

//        xOffset = ((stickPos[stick1] + stickPos[stick2]) / 2) + (stickWidth[0] / 2);
//        yOffset = (baseY / 2) + (height * calculateDiskHeight(0));

        System.out.printf("(Debug) Min: %s Max: %s Pos: %s%n", x1, x2, x);

        if (x > xMax) {
            finished = true;
        } else if (x < xMin) {
            finished = false;
        }

        int y = (int) (Math.pow(x, 2) / stretch);

        debugAnimationPath(g,x1,x2);

        g.setColor(Color.BLACK);
        //g.fillRect((int) (Double.sum(xOffset, x) - (objectSizeWidth / 2)), (int) (y + yOffset), objectSizeWidth, objectSizeHeight);

        if (!finished) {
            x += 0.1;
        } else {
            x -= 0.1;
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void debugAnimationPath(Graphics g,double x1,double x2) {
        g.setColor(Color.RED);
        double y;

        if (x1 > x2) {
            double t = x1;
            x1 = x2;
            x2 = t;
            System.out.println("switched");
        }

        for (double i = x1; i < x2; i += moveOffset) {
            y = (a*Math.pow(i,2))+(i*stretch)+c;
           // y*=-1;
           // g.fillRect((int) Double.sum(xOffset, i), (int) Double.sum((Math.pow(i, 2) / stretch), yOffset), 2, 2);
            g.fillRect((int) Double.sum(xOffset, i),(int) Double.sum(y,yOffset),2,2);

        }
    }
}

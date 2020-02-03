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

    private int diskAmount = 10;
    private int diskOffset = 20;

    /*-----Animation------*/
    private double x = -10;
    private double xMin = -10;
    private double xMax = 20;

    private double stretch = 3;
    private double moveOffset = 0.01;
    private int objectSizeWidth = 30;
    private int objectSizeHeight = 30;

    private double xOffset = 100;
    private double yOffset = 200;

    private boolean finished = false;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (sticks.size() == 0)
            generatePlayGround(g);

        drawBase(g);

        drawDisks(g);

        Random rand = new Random();

        int r = rand.nextInt(sticks.size());
        if (!sticks.get(r).isEmpty()) {
            Disk d = sticks.get(r).peek();
            sticks.get(r).pop();

            int r2 = rand.nextInt(sticks.size());
            System.out.println(r2+1);
            d.setX(calculateDiskX(r2+1,d));
            sticks.get(r2).push(d);
        }

        animation(g);
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

    private int calculateDiskX(int index,Disk d) {
            return ((((baseWidth / stickAmount) * (index) - (baseWidth / (stickAmount * 2))) - ((baseWidth / stickAmount) - (diskOffset * (d.getSize() + 1))) / 2) - 2);
    }

    private void generatePlayGround(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(baseX, baseY, baseWidth, baseHeight);

        for (int i = 0; i < stickAmount; i++) {
            g.fillRect((baseWidth / stickAmount) * (i + 1) - (baseWidth / (stickAmount * 2)), baseY, baseWidth / (stickAmount * 10), baseHeight * -5);
            sticks.add(new Stack<Disk>());
        }


        for (int i = 0; i < diskAmount; i++) {

            Disk d = new Disk(new Color(
                    (int) ((Math.sin(i) + 1) / 2 * 255),
                    (int) ((Math.cos(i) + 1) / 2 * 255),
                    (int) ((-Math.sin(i) + 1) / 2 * 255)
            ), (((baseWidth / stickAmount) * (1) - (baseWidth / (stickAmount * 2))) - ((baseWidth / stickAmount) - (diskOffset * (i + 1))) / 2) - 2, baseY - ((diskOffset) * (i + 1)), (baseWidth / stickAmount) - (diskOffset * i), (int) (diskAmount * 2.5),i);

            sticks.get(0).push(d);

//            g.setColor(new Color(
//                    (int)((Math.sin(i)+1)/2*255),
//                    (int)((Math.cos(i)+1)/2*255),
//                    (int)((-Math.sin(i)+1)/2*255)
//            ));
//            g.fillRect((((baseWidth/stickAmount)*(1)-(baseWidth/(stickAmount*2)))-((baseWidth/stickAmount)-(diskOffset*(i+1)))/2)-2,baseY-((diskOffset)*(i+1)),(baseWidth/stickAmount)-(diskOffset*i), (int) (diskAmount*2.5));
        }
    }

    private void animation(Graphics g) {

        if (x > xMax) {
            finished = true;
        } else if (x < xMin) {
            finished = false;
        }

        int y = (int) (Math.pow(x, 2) / stretch);

        debugAnimationPath(g);

        g.setColor(Color.BLACK);
        g.fillRect((int) (Double.sum(xOffset, x) - (objectSizeWidth / 2)), (int) (y + yOffset), objectSizeWidth, objectSizeHeight);

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

    private void debugAnimationPath(Graphics g) {
        g.setColor(Color.RED);
        for (double i = xMin; i <= xMax; i += moveOffset) {
            g.fillRect((int) Double.sum(xOffset, i), (int) Double.sum((Math.pow(i, 2) / stretch), yOffset), 2, 2);
        }
    }
}

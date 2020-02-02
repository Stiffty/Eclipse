package tuermeVonHanoi;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {

    private int baseX = 10;
    private int baseY = 400;
    private int baseWidth = 480;
    private int baseHeight = 30;

    private int stickAmount = 3;

    private int diskAmount = 6;
    private int diskOffset = 10;
    /*-----Animation------*/
    private double x = -10;
    private double xMin = -10;
    private double xMax = 10;

    private double stretch = 1;
    private double moveOffset = 0.01;
    private int objectSizeWidth = 30;
    private  int objectSizeHeight = 30;

    private double xOffset = 100;
    private double yOffset = 200;

    private boolean finished =false;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        generatePlayGround(g);

        animation(g);
    }

    private void generatePlayGround(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(baseX,baseY,baseWidth,baseHeight);

        for (int i = 0; i < stickAmount; i++) {
            g.fillRect((baseWidth/stickAmount)*(i+1)-(baseWidth/(stickAmount*2)),baseY,baseWidth/(stickAmount*10),baseHeight*-5);
        }

        for (int i = 0; i < diskAmount; i++) {
            g.fillRect(((baseWidth/stickAmount)-(baseWidth/(stickAmount*2)))-((baseWidth/stickAmount)-(diskOffset*(i+1)))/2,baseY-((diskOffset)*(i+1)),(baseWidth/stickAmount)-(diskOffset*i),diskOffset);
        }
    }

    private void animation(Graphics g) {

        if (x > xMax){
            finished = true;
        }else if(x < xMin){
            finished = false;
        }

        int y = (int) (Math.pow(x,2)/stretch);

        debugAnimationPath(g);

        g.setColor(Color.BLACK);
        g.fillRect( (int) (Double.sum(xOffset,x)-(objectSizeWidth/2)), (int) (y+yOffset), objectSizeWidth, objectSizeHeight);

        if(!finished){
            x+=0.1;
        }else {
            x-=0.1;
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void debugAnimationPath(Graphics g) {
        g.setColor(Color.RED);
        for (double i = xMin; i <= xMax; i+=moveOffset) {
            g.fillRect( (int) Double.sum(xOffset,i), (int) Double.sum((Math.pow(i,2)/stretch),yOffset), 2, 2);
        }
    }
}

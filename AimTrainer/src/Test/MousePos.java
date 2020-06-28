package Test;

import java.awt.*;

public class MousePos {
    public static void main(String[] args) {
        try {
            Robot robo = new Robot();
            while (true){
                Point p = MouseInfo.getPointerInfo().getLocation();
                System.out.printf("Pos: x: %s y: %s%n",p.x,p.y);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}

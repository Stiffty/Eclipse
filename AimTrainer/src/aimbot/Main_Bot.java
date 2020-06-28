package aimbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Main_Bot extends JFrame implements KeyListener {
    Drawing draw = new Drawing();

    public Main_Bot() {


        Scanner sc = new Scanner(System.in);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        new Thread(() -> {
            while (true) {
                draw.repaint();
            }
        }).start();

        this.setBounds(0, 0, width, height);
        //this.setOpacity(0);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setAlwaysOnTop(true);
        this.setContentPane(draw);
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);

        new Thread(()->{
            Robot robo = null;
            try {
                robo = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            BufferedImage image;
            Color color = null;
            while (true){
                image = robo.createScreenCapture(new Rectangle(width, height));
                color = new Color(image.getRGB(width/2, height/2));
                if (color.getRed() > 140 && color.getGreen() < 50 && color.getBlue() < 50) {
                    robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 500; i++) {

                    //sc.nextLine();
                    //setMousePos(width/2, height/2);
                    findImage(height, width);
//                draw.x1 = 200;
//                draw.y1 = 500;
//                draw.x2 = 1000;
//                draw.y2 = 1000;


            }
        }).start();

    }


    public void findImage(int height, int with) {
        Robot robo = null;
        try {
            robo = new Robot();
            //robo.mouseMove(10,10);
            //robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            BufferedImage image = robo.createScreenCapture(new Rectangle(with, height));
            Color color = null;
            loop:
            for (int y = 0; y < height; y+=10) {
                for (int x = 0; x < with; x+=10) {
                    color = new Color(image.getRGB(x, y));
                    if (color.getRed() > 140 && color.getGreen() < 50 && color.getBlue() < 50) {
                        Point a = new Point(with/2,height/2);
                        Point b = new Point(x,y);
                        Point c = new Point((int)((b.x-a.x)),(int)((b.y-a.y)));
                        //int length = (int) Math.pow((Math.pow(c.x,2)+Math.pow(c.y,2)), 1f/2f);
                        Point p = MouseInfo.getPointerInfo().getLocation();
                        //System.out.println("P1: " +p);
                        p.setLocation(p.getX()+c.getX(), p.getY()+c.getY());
//                        System.out.println("A: " +a);
//                        System.out.println("B: " +b);
//                        System.out.println("C: " +c);
//                        System.out.println("P: " +p);

                        draw.x1 = x;
                        draw.y1 = y;
                        setMousePos((int) p.getX(), (int) p.getY(),(int)a.getX(),(int)a.getY());
                        //setMousePos(x, y);
                        break loop;
                    }
                }
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void setMousePos(int x, int y,int xMid,int yMid) {
        try {
            Robot robo = new Robot();
            //BufferedImage image = robo.createScreenCapture(new Rectangle(100,100));

            draw.x2 = x;
            draw.y2 = y;
            //Thread.sleep(1000);
           robo.mouseMove(x, y);
//            Color color = robo.getPixelColor(xMid,yMid);
//           if(color.getRed() > 140 && color.getGreen() < 50 && color.getBlue() < 50){
//               robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//           }
           // robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Press");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                //setMousePos(500, 500);
                System.out.println("Mouse Set.");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main_Bot().setVisible(true);
            }
        });
    }


}

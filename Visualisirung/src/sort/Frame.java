package sort;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Frame extends JFrame {
    
	private Sort sort;
	public Draw draw;
    public Frame() {

        initUI();
        new Thread(()->{ 
        	sort = new Sort(this);
        } ).start();
    }

    private void initUI() {
    	
    	draw = new Draw();
        add(draw);

        setSize(250, 200);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            Frame ex = new Frame();
            ex.setVisible(true);
        });
    }
}
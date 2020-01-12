package langtons_Ant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	
	public static Draw draw;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Frame() {
		draw = new Draw();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				System.out.println("Dragged: x:" + arg0.getX()+" y: "+arg0.getY());
				
			}
		});
		contentPane.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int direction = arg0.getWheelRotation();
				
				System.out.println(direction);
				if((Draw.viewSize+direction)>=1) {
					Draw.viewSize+=direction;
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().add(draw);
		this.setVisible(true);
		System.out.println(draw.isOptimizedDrawingEnabled());
		
		new Thread(()->{ 
			while(true) {
				draw.repaint();
				//draw.repaint(Ant.xp, Ant.yp, 1, 1);
			}
			
		}).start();
		
		
	}

}

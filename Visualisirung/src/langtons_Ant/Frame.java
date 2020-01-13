package langtons_Ant;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Position;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Frame extends JFrame {

	private JPanel contentPane;

	public static Draw draw;

	public static int mouseOffsetX = 0;
	public static int mouseOffsetY = 0;
	public static Point newPos = new Point();
	private Point lastMouse = new Point();

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
			public void mouseDragged(MouseEvent e) {

				mouseOffsetX = ((lastMouse.x - e.getX()) * -1);
				mouseOffsetY = ((lastMouse.y - e.getY()) * -1);

				System.out.println(mouseOffsetX + " Y: " + mouseOffsetY);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lastMouse.x = e.getX();
				lastMouse.y = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(mouseOffsetX + " 33Y: " + mouseOffsetY);
				newPos.x += mouseOffsetX;
				newPos.y += mouseOffsetY;
				mouseOffsetX = 0;
				mouseOffsetY = 0;
			}
		});

		contentPane.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int direction = arg0.getWheelRotation();

				System.out.println(direction);
				if ((Draw.viewSize + direction) >= 1) {
					Draw.viewSize += direction;
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		getContentPane().add(draw);
		this.setVisible(true);
		System.out.println(draw.isOptimizedDrawingEnabled());

		new Thread(() -> {
			while (true) {
				draw.repaint();
				// draw.repaint(Ant.xp, Ant.yp, 1, 1);
			}

		}).start();

	}

}

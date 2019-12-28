package sort2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private static int[] feld = new int[1000];
	private JPanel contentPane;
	private static Draw draw = new Draw(feld);
	private static Sort sort = new Sort(draw);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					
					frame.add(draw);
					frame.setVisible(true);
					//draw.repaint();
					action();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, feld.length+30, (int)(feld.length/2)+50);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		
		sort.füllen(feld);
	}
	
	static void action() {
		new Thread(()->{ 
			while(true) {
			sort.mischen(feld);
			sleep();
			sort.bubblesort(feld);
			sleep();
			sort.mischen(feld);
			sleep();
			sort.insertionSort(feld);
			sleep();
			sort.mischen(feld);
			sleep();
			sort.quickSort(feld, 0, feld.length-1);
			sleep();
			sort.mischen(feld);
			sleep();
			sort.LSD_sort(feld);
			sleep();
			sort.mischen(feld);
			sleep();
			sort.cycleSort(feld, feld.length);
			sleep();
			sort.mischen(feld);
			sleep();
			sort.mergeSort(feld, 0, feld.length-1);
			sleep();
			}
		} ).start();
	}
	static void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

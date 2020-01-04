package sort2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.math.BigInteger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private static int[] feld = new int[1000];
	private JPanel contentPane;
	
	private static Draw draw = new Draw(feld);
	private static Sort sort = new Sort(draw);
	
	static long counter = 0;
	static long waittime = 0;
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
					new Thread(()->{ 
						while(true) {
							draw.repaint();
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}).start();
					action();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, (feld.length/(feld.length/1000)*2)+30, (int)(feld.length/(feld.length/300)*2)+50);
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
			sleep();
			sort.bubblesort(feld);
			sort.reverse(feld);
			sort.bubblesort(feld);
			
			sleep();
			sort.insertionSort(feld);
			sort.reverse(feld);
			sort.insertionSort(feld);
			
			sleep();
			sort.quickSort(feld, 0, feld.length-1);
			sort.reverse(feld);
			sort.quickSort(feld, 0, feld.length-1);
			sleep();
			
			sort.LSD_sort(feld);
			sort.reverse(feld);
			sort.LSD_sort(feld);
			sleep();
			
			sort.cycleSort(feld, feld.length);
			sort.reverse(feld);
			sort.cycleSort(feld, feld.length);
			sleep();
			
			sort.mergeSort(feld, 0, feld.length-1);
			sort.reverse(feld);
			sort.mergeSort(feld, 0, feld.length-1);
			sleep();
		
			sort.heapsort(feld);
			sort.reverse(feld);
			sort.heapsort(feld);
			sleep();
			
			sort.Selectionsort(feld);
			sort.reverse(feld);
			sort.Selectionsort(feld);
			sleep();
			
			sort.radixsort(feld,feld.length-1);
			sort.reverse(feld);
			sort.radixsort(feld,feld.length-1);
			sleep();
			
			sort.Shellsort(feld);
			sort.reverse(feld);
			sort.Shellsort(feld);
			sleep();
			
			sort.sortbio(feld);
			sort.Selectionsort(feld);
			sort.reverse(feld);
			sort.sortbio(feld);
			sort.Selectionsort(feld);
			sleep();
			
			sort.Combsort(feld);;
			sort.reverse(feld);
		    sort.Combsort(feld);
			sleep();
			
			sort.pigeonhole_sort(feld, feld.length-1);
			sort.reverse(feld);
			sort.pigeonhole_sort(feld, feld.length-1);
			sleep();
			
			sort.cocktailSort(feld);
			sort.reverse(feld);
			sort.cocktailSort(feld);
			sleep();
			
			sort.pancakeSort(feld, feld.length-1);
			sort.reverse(feld);
			sort.pancakeSort(feld, feld.length-1);
			sleep();
			
			sort.binarysort(feld);
			sort.reverse(feld);
			sort.binarysort(feld);
			sleep();
			
			sort.oddEvenSort(feld, feld.length-1);
			sort.reverse(feld);
			sort.oddEvenSort(feld, feld.length-1);
			sleep();
			
			//sort.tunnel(feld);	
			}
		} ).start();
	}
	static void sleep() {
		counter = (long) 0;
		waittime = 0;
		try {
			Thread.sleep(1000);
			sort.mischen(feld);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

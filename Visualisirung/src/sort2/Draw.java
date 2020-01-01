package sort2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Draw extends JPanel{

	private int[] feld;
	static int coloroffset = 0;
	private int frameWait = 1;
	private static int framecounter = 0;
	private int fps;
	
	private boolean[] besetzt ;
	public Draw(int[] feld) {
		this.feld = feld;
		besetzt =new boolean[feld.length];
		new Thread(()->{ 
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fps = framecounter;
				framecounter = 0;
			}
		}).start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		framecounter++;
		
		
		besetzt =new boolean[(0+feld.length)/(feld.length/1000)];
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, super.getWidth(), super.getHeight());
		
		g.setColor(Color.WHITE);
		g.drawString("Array accesses: " + Frame.counter, this.getWidth()/2, 10);
		g.drawString("Sleep Time: " + (1000000000/feld.length) + " ns",this.getWidth()/2,25);
		g.drawString("FPS: " + fps,this.getWidth()/2,40);
		
		if(coloroffset ==feld.length) {
			coloroffset = 0;
		}else {
			coloroffset-=4;
		}
		
		
		int x = feld.length;
		
		for (int i = 0; i < feld.length; i+=1) {
			if(besetzt[(0+i)/(feld.length/1000)] != true) {
			try {
				double ifinal = (((feld[i]+coloroffset)*(1D/feld.length)*Math.PI*2));
				
				g.setColor(new Color(
						(int)((Math.sin(ifinal)+1)/2*255),
						(int)((Math.cos(ifinal)+1)/2*255),
						(int)((-Math.sin(ifinal)+1)/2*255)
						));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(i);
			}
			//g.setColor(Color.BLACK);
			int y = feld.length/(feld.length/300)-(feld[i]/(feld.length/300));
			int higth = ((feld[i])/(feld.length/300)*2);
			int with = 1;
			
			
				g.fillRect((x+i)/(feld.length/1_000), y, with , higth);
				g.fillRect((x-i)/(feld.length/1000), y, with , higth);
				besetzt[((0+i)/(feld.length/1000))] = true;
			
		}
		}
		
		try {
			Thread.sleep(frameWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rePaint() {
		this.repaint();
	}
}

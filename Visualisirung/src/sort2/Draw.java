package sort2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Draw extends JPanel{

	private int[] feld;
	public Draw(int[] feld) {
		this.feld = feld;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, super.getWidth(), super.getHeight());
		
		g.setColor(Color.WHITE);
		g.drawString("Array accesses: " + Frame.counter, feld.length, 10);
		g.drawString("Sleep Time: " + (1000000000/feld.length) + " ns",feld.length,25);
		int x = feld.length;
		for (int i = 0; i < feld.length; i+=1) {
			
			try {
				double ifinal = ((feld[i]*(1D/feld.length)*Math.PI*2));
				
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
			g.fillRect((x+i)/(feld.length/1000), y, with , higth);
			g.fillRect((x-i)/(feld.length/1000), y, with , higth);
		
		}
	}
	public void rePaint() {
		this.repaint();
	}
}

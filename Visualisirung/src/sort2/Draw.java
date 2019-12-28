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
		int x = 0;
		int y = 10;
		for (int i = 0; i < feld.length; i+=5) {
			
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
			g.fillRect((x+i), feld.length/2-(feld[i]/2), 5, feld[i]/2);
		}
	}
	public void rePaint() {
		this.repaint();
	}
}

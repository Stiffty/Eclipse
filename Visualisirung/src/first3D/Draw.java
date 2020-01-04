package first3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Draw extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int xPos = 100;
		int heigth = 400;
		int length = 500;

		int[] x = { xPos, (xPos+length), 175, 125 };
		int[] y = { heigth, heigth, 75, 75 };
		
		x[2] = (int) (x[0]+(x[0]+length))+(GUI.offset);
		x[3] = (int) (x[0]+(x[0]))+GUI.offset;
		
		
		y[2] = (int) (y[0]-(y[0]*0.25))+GUI.offset;
		y[3] = (int) (y[0]-(y[0]*0.25))+GUI.offset;
		
		if(GUI.offset == xPos*2) {
			GUI.return_o = true;
		}
		
		if(GUI.return_o == true) {
			System.out.println(GUI.offset);
			x[2] = (int) (x[0]+(x[0]+length))+(GUI.offset);
			x[3] = (int) (x[0]+(x[0]))+GUI.offset;
			
			
			y[2] = (int) (y[0]-(y[0]*0.25))-GUI.offset;
			y[3] = (int) (y[0]-(y[0]*0.25))-GUI.offset;
		}

		g.setColor(Color.RED);
		g.fillRect(x[0]-5, y[0], 5, 5);
		g.drawString("P1: x: "+x[0]+" y: "+y[0], x[0]-5, y[0]);
		
		g.fillRect(x[1], y[1], 5, 5);
		g.drawString("P2: x: "+x[1]+" y: "+y[1], x[1], y[1]);
		
		g.fillRect(x[2], y[2]-5, 5, 5);
		g.drawString("P3: x: "+x[2]+" y: "+y[2], x[2], y[2]-5);
		
		g.fillRect(x[3] - 5, y[2]-5, 5, 5);
		g.drawString("P4: x: "+x[3]+" y: "+y[3], x[3] - 5, y[2]-5);

		g.setColor(Color.BLACK);
		//g.drawPolygon(new Polygon(x, y, 3));

		Graphics g3d = g;
		
		
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
		
		g2d.drawPolygon(x, y, x.length);
	}

}

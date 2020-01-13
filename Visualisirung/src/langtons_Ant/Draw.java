package langtons_Ant;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Draw extends JPanel {

	private Ant ant;

	public static int viewSize = 1;

	// private ArrayList<ArrayList<Integer>> feld = ant.;

	public Draw() {
		// TODO Auto-generated constructor stub
		ant = new Ant();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int heigth = super.getHeight();
		int width = super.getWidth();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, heigth);

		int xr;
		int yr;
		for (int x = Ant.xMin+1; x < Ant.xMax; x += viewSize) {
			xr = x + Frame.newPos.x + Frame.mouseOffsetX;
			for (int y = Ant.yMin+1; y < Ant.yMax; y += viewSize) {
				yr = y + Frame.newPos.y + Frame.mouseOffsetY;
				
				if (ant.feld1[x][y] == 1) {
					g.setColor(Color.RED);
					g.fillRect(xr, yr, viewSize, viewSize);
				} else if (ant.feld1[x][y] == 2) {
					g.setColor(Color.WHITE);
					g.fillRect(xr, yr, viewSize, viewSize);
				} else if (ant.feld1[x][y] == 3) {
					g.setColor(Color.GREEN);
					g.fillRect(xr, yr, viewSize, viewSize);
				} else if (ant.feld1[x][y] == 4) {
					g.setColor(Color.YELLOW);
					g.fillRect(xr, yr, viewSize, viewSize);
				} else if (ant.feld1[x][y] == 5) {
					g.setColor(Color.BLUE);
					g.fillRect(xr, yr, viewSize, viewSize);
				} else if (ant.feld1[x][y] == 6) {
					g.setColor(Color.CYAN);
					g.fillRect(xr, yr, viewSize, viewSize);
				} else if (ant.feld1[x][y] == 7) {
					g.setColor(Color.PINK);
					g.fillRect(xr, yr, viewSize, viewSize);
				} else if (ant.feld1[x][y] == 8) {
					g.setColor(Color.MAGENTA);
					g.fillRect(xr, yr, viewSize, viewSize);
				}
				if(xr>width||yr>heigth) {
					break;
				}
			}
			if(xr>width) {
				break;
			}
		}
	}
}

package langtons_Ant;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Draw extends JPanel {

	private Ant ant;

	private boolean viewNet = false;
	private boolean scale = false;

	public static boolean wait = false;

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

		if (viewNet) {
			for (int x = 0; x < heigth; x++) {
				for (int y = 0; y < width; y++) {
					if (y % viewSize == 0 || x % viewSize == 0) {
						g.setColor(Color.GRAY);
						g.fillRect(x, y, viewSize, viewSize);
						g.setColor(Color.BLACK);
						g.drawRect(x, y, 1, 1);
					}
				}

			}
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, heigth);
		}

		g.setColor(Color.BLUE);

		if (scale) {
			for (int x = 0; x < ant.feld1.length; x++) {
				for (int y = 0; y < ant.feld1.length; y++) {
					if (ant.feld1[x][y] == 1) {
						g.setColor(Color.RED);
						g.fillRect((((x / 500)) + (width / 2)) * x / 500, (((y / 500)) + (heigth / 2)) * y / 500,
								viewSize, viewSize);
					} else if (ant.feld1[x][y] == 2) {
						g.setColor(Color.WHITE);
						g.fillRect((((x / 500)) + (width / 2)) * x / 500, (((y / 500)) + (heigth / 2)) * y / 500,
								viewSize, viewSize);
					} else if (ant.feld1[x][y] == 3) {
						g.setColor(Color.GREEN);
						g.fillRect((((x / 500)) + (width / 2)) * x / 500, (((y / 500)) + (heigth / 2)) * y / 500,
								viewSize, viewSize);
					} else if (ant.feld1[x][y] == 4) {
						g.setColor(Color.YELLOW);
						g.fillRect((((x / 500)) + (width / 2)) * x / 500, (((y / 500)) + (heigth / 2)) * y / 500,
								viewSize, viewSize);
					}
				}
			}
		} else {
			int xd = Ant.xp;
			int yd = Ant.yp;
			for (int x = 0; x < ant.xMax; x += viewSize) {
				for (int y = 0; y < ant.yMax; y += viewSize) {
					if (ant.feld1[x][y] == 1) {
						g.setColor(Color.RED);
						g.fillRect(x, y, viewSize, viewSize);
					} else if (ant.feld1[x][y] == 2) {
						g.setColor(Color.WHITE);
						g.fillRect(x, y, viewSize, viewSize);
					} else if (ant.feld1[x][y] == 3) {
						g.setColor(Color.GREEN);
						g.fillRect(x, y, viewSize, viewSize);
					} else if (ant.feld1[x][y] == 4) {
						g.setColor(Color.YELLOW);
						g.fillRect(x, y, viewSize, viewSize);
					} else if (ant.feld1[x][y] == 5) {
						g.setColor(Color.BLUE);
						g.fillRect(x, y, viewSize, viewSize);
					} else if (ant.feld1[x][y] == 6) {
						g.setColor(Color.CYAN);
						g.fillRect(x, y, viewSize, viewSize);
					} else if (ant.feld1[x][y] == 7) {
						g.setColor(Color.PINK);
						g.fillRect(x, y, viewSize, viewSize);
					} else if (ant.feld1[x][y] == 8) {
						g.setColor(Color.MAGENTA);
						g.fillRect(x, y, viewSize, viewSize);
					}
				}
			}
		}

		wait = false;
	}
}

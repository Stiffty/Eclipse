package langtons_Ant;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Draw extends JPanel {

	private Ant ant = new Ant();;
	
	private boolean viewNet = false;
	
	//private ArrayList<ArrayList<Integer>> feld = ant.;

	public Draw() {
		// TODO Auto-generated constructor stub
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int heigth = super.getHeight();
		int width = super.getWidth();

		if (viewNet) {
			for (int x = 0; x < heigth; x++) {
				for (int y = 0; y < width; y++) {
					if (y % ant.size == 0 || x % ant.size == 0) {
						g.setColor(Color.GRAY);
						g.fillRect(x,y,ant.size,ant.size);
						g.setColor(Color.BLACK);
						g.drawRect(x, y, 1, 1);
					}
				}

			}
		}else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, heigth);
		}

		g.setColor(Color.BLUE);
		
		
		
		for (int x = 0; x < ant.feld.size(); x++) {
			for (int y = 0; y < ant.feld.get(x).size(); y++) {
				if(ant.feld.get(x).get(y)[2] == 1) {
					g.setColor(Color.RED);
					g.fillRect(ant.feld.get(x).get(y)[0], ant.feld.get(x).get(y)[1], ant.size, ant.size);
				}else
				if(ant.feld.get(x).get(y)[2] == 2) {
					g.setColor(Color.WHITE);
					g.fillRect(ant.feld.get(x).get(y)[0], ant.feld.get(x).get(y)[1], ant.size, ant.size);
				}else
				if(ant.feld.get(x).get(y)[2] == 3) {
					g.setColor(Color.GREEN);
					g.fillRect(ant.feld.get(x).get(y)[0], ant.feld.get(x).get(y)[1], ant.size, ant.size);
				}else
					if(ant.feld.get(x).get(y)[2] == 4) {
						g.setColor(Color.YELLOW);
						g.fillRect(ant.feld.get(x).get(y)[0], ant.feld.get(x).get(y)[1], ant.size, ant.size);
					}
			}
		}
	
	}
}

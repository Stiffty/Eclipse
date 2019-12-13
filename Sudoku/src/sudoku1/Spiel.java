package sudoku1;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.ToolTipManager;

public class Spiel {

	private JButton buttons[][];
	
	private Random rnd = new Random();
	
	private boolean[] check = new boolean[9];
	
	public Spiel(JButton button[][]) {
		// TODO Auto-generated constructor stub
		buttons = button;
	}
	
	public void Füllen() {
		int counterab = 0;
		
		for (int x = 0; x < buttons.length; x++) {
			for (int y = 0; y < buttons.length; y++) {
				int r = rnd.nextInt(9)+1;
				check[r-1] = true;
				if(test_line(Integer.parseInt(buttons[x][y].getToolTipText().split(":")[0]),Integer.parseInt(buttons[x][y].getToolTipText().split(":")[1]),r) == true&&test_square(Integer.parseInt(buttons[x][y].getToolTipText().split(":")[0]),Integer.parseInt(buttons[x][y].getToolTipText().split(":")[1]),r) == true) {
					buttons[x][y].setText(Integer.toString(r));
					buttons[x][y].setBackground(Color.ORANGE);
					}else {
					y--;
					counterab++;
					
					if(counterab == 400) {
						//System.out.println("test");
						//counterab = 0;
						return;
					}
				}
			}
		}
		for(JButton[] x: buttons) {
			for(JButton y: x) {
				y.setToolTipText(y.getToolTipText().split(":")[0] +":" + y.getToolTipText().split(":")[1] + ":"+ y.getText());
				
			}
			}
		ToolTipManager.sharedInstance().setEnabled(false);
	}
	
	boolean test_square(int x, int y,int p) {
		
		int xs = x-(x%3);
		int ys = y-(y%3);
		
		int counter = 0;
		
		for (int xc = xs; xc < xs+3; xc++) {
			for (int yc = ys; yc < ys+3; yc++) {
				if(buttons[xc][yc].getText()!= "") {
				if(Integer.parseInt(buttons[xc][yc].getText()) == p ) {
					counter++;
				}
				}
			}
				
			
		}
		if(counter>0) {
			return false;
		}else {
			return true;
		}
	}
	
	boolean test_line(int x,int y,int p) {
		int counterx = 0;
		int countery = 0;
		for (int i = 0; i < 9; i++) {
			if(buttons[x][i].getText() != "") {
				if(Integer.parseInt(buttons[x][i].getText()) == p ) {
					counterx++;
				}
			}
			if(buttons[i][y].getText() != "") {
				
				if(Integer.parseInt(buttons[i][y].getText()) == p ) {
					countery++;
				}
			}
		
		}
	
		if(counterx <= 0&&countery <= 0) {
			//System.out.println(counterx + " "+ countery);
			return true;
		}else {
			return false;
		}
	}
	
	boolean test_check() {
		for (int i = 0; i < check.length; i++) {
			if(check[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	public void entfernen() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				int r = rnd.nextInt(5);
				if(r == 0) {
					buttons[i][j].setText("");
				}
			}
		}
	}
	
}

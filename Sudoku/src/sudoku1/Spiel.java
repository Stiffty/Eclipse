package sudoku1;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

public class Spiel {

	private JButton buttons[][];
	
	private Random rnd = new Random();
	
	public Spiel(JButton button[][]) {
		// TODO Auto-generated constructor stub
		buttons = button;
	}
	
	public void Füllen() {
		for (int x = 0; x < buttons.length-5; x++) {
			for (int y = 0; y < buttons.length; y++) {
				int r = rnd.nextInt(9)+1;
				if(test_line(Integer.parseInt(buttons[x][y].getToolTipText().split(":")[0]),Integer.parseInt(buttons[x][y].getToolTipText().split(":")[1]),r) == true) {
					buttons[x][y].setText(Integer.toString(r));
					buttons[x][y].setBackground(Color.ORANGE);
				}else {
					y--;
				}
			}
		}
	}
	
	void test_square() {
		
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
			System.out.println(counterx + " "+ countery);
			return true;
		}else {
			return false;
		}
	}
}

package game_Battle;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Controller {

	private static Gui gui;
	private static Game game;
	private static Game_Data data = new Game_Data();
	private JButton pl1;
	
	public Controller(Gui gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
		feld_erstellen(10, 10, 10);
		//start_game();
	}


	public void feld_erstellen(int start_x,int start_y,int size) {
		for (int x = 0; x < data.getFeldgroesse_x(); x++) {
			for (int y = 0; y < data.getFeldgroesse_y(); y++) {
				if(y == 0||y == data.getFeldgroesse_y()-1||x == 0||x == data.getFeldgroesse_x()-1) {
					JButton btnNewButton = new JButton();
					btnNewButton.setBounds((x+start_x)+x*size-1, (y+start_y)+y*size-1, size, size);
					btnNewButton.setBackground(Color.RED);
					btnNewButton.setEnabled(false);
					gui.getContentPane().add(btnNewButton);
				}
			}
		}
		gui.setBounds(100, 100, (data.getFeldgroesse_x()+start_x)+data.getFeldgroesse_x()*size+50, (data.getFeldgroesse_y()+start_y)+data.getFeldgroesse_y()*size+50);
		pl1= new JButton();
		pl1.setBounds(start_x+20, start_y+20, size, size);
		pl1.setBackground(Color.BLUE);
		pl1.setEnabled(true);
		
		
		gui.getContentPane().add(pl1);
		
	}
	
	 void start_game() {
		new Thread(() ->{
			//game = new Game(pl1);
		} ).start();
	}
}

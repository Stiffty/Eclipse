package game_Battle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class Game {

	Game_Data data = new Game_Data();
	
	
	
	private JButton p1;
	private JButton p2;
	public Game(JButton p1,JButton p2) {
		// TODO Auto-generated constructor stub
		this.p1 = p1;
		this.p2 = p2;
		
		move_p1();
	}
	
	void move_p1() {
		
	}
	
	public void feld_erstellen() {
		
	}

	public Game_Data getData() {
		return data;
	}

	public void setData(Game_Data data) {
		this.data = data;
	}

	
}

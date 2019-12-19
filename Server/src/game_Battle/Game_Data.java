package game_Battle;

import java.io.Serializable;

public class Game_Data implements Serializable{

	private int feldgroesse_x = 50;
	private int feldgroesse_y = 25;
	
	private int p1_x = 20;
	private int p1_y = 20;
	
	private int p2_x;
	private int p2_y;
	public Game_Data() {
		// TODO Auto-generated constructor stub
	}
	
	public int getFeldgroesse_x() {
		return feldgroesse_x;
	}
	public void setFeldgroesse_x(int feldgroesse_x) {
		this.feldgroesse_x = feldgroesse_x;
	}
	public int getFeldgroesse_y() {
		return feldgroesse_y;
	}
	public void setFeldgroesse_y(int feldgroesse_y) {
		this.feldgroesse_y = feldgroesse_y;
	}

	public int getP1_x() {
		return p1_x;
	}

	public void setP1_x(int p1_x) {
		this.p1_x = p1_x;
	}

	public int getP1_y() {
		return p1_y;
	}

	public void setP1_y(int p1_y) {
		this.p1_y = p1_y;
	}
	
}

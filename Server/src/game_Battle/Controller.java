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
	private JButton pl2;
	
	public Controller(Gui gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
		feld_erstellen(10, 10, 10);
		//start_game();
	}


	public void feld_erstellen(int start_x,int start_y,int size) {
		//felderstellen
		for (int x = 0; x < data.getFeldgroesse_x(); x++) {
			for (int y = 0; y < data.getFeldgroesse_y(); y++) {
				if(y == 0||y == data.getFeldgroesse_y()-1||x == 0||x == data.getFeldgroesse_x()-1) {
					JButton btnNewButton = new JButton();
					btnNewButton.setBounds((x+start_x)+x*size-1, (y+start_y)+y*size-1, size, size);
					btnNewButton.setBackground(Color.RED);
					btnNewButton.setEnabled(false);
					gui.getContentPane().add(btnNewButton);
					System.out.println("test");
				}
			}
		}
		//Spieler1 spawn
		gui.setBounds(100, 100, (data.getFeldgroesse_x()+start_x)+data.getFeldgroesse_x()*size+50, (data.getFeldgroesse_y()+start_y)+data.getFeldgroesse_y()*size+50);
		pl1= new JButton();
		pl1.setBounds(start_x+20, start_y+20, size, size);
		pl1.setBackground(Color.BLUE);
		pl1.setEnabled(true);
		
		gui.getContentPane().add(pl1);
		
		//Spieler2
		gui.setBounds(100, 100, (data.getFeldgroesse_x()+start_x)+data.getFeldgroesse_x()*size+50, (data.getFeldgroesse_y()+start_y)+data.getFeldgroesse_y()*size+50);
		pl2= new JButton();
		pl2.setBounds(start_x+300, start_y+20, size, size);
		pl2.setBackground(Color.GREEN);
		pl2.setEnabled(true);
		
		gui.getContentPane().add(pl2);
		start_client();
		//Movment
		gui.addKeyListener(new KeyAdapter() {
			private boolean run;
			private Thread move;
			@Override
			public void keyPressed(KeyEvent arg0) {
				char key = arg0.getKeyChar();
				if(	run == false) {
					run = true;
					move(key);
				}
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				run = false;
				move.stop();
			}
			void move(char direction) {
				switch (direction) {
				case 'd':
					move = new Thread(() ->{
						//game = new Game(pl1);
						while(run == true) {
							pl1.setBounds(data.getP1_x()+1, data.getP1_y(), size, size);
							data.setP1_x(pl1.getX()+1);
							data.setP1_y(pl1.getY());
							gui.invalidate();
							try {
								move.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					} );
					move.start();
					break;
				case 'a':
					move = new Thread(() ->{
						//game = new Game(pl1);
						while(run == true) {
							pl1.setBounds(pl1.getX()-1, pl1.getY(), size, size);
							gui.invalidate();
							try {
								move.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					} );
					move.start();
					break;
				case 's':
					move = new Thread(() ->{
						//game = new Game(pl1);
						while(run == true) {
							pl1.setBounds(pl1.getX(), pl1.getY()+1, size, size);
							gui.invalidate();
							try {
								move.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					} );
					move.start();
					break;
				case 'w':
					move = new Thread(() ->{
						//game = new Game(pl1);
						while(run == true) {
							pl1.setBounds(pl1.getX(), pl1.getY()-1, size, size);
							gui.invalidate();
							try {
								move.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					} );
					move.start();
					break;
					
				default:
					break;
				}
			}
		});
	}
	
	 void start_client() {
		new Thread(() ->{
			new Client(this,"localhost",333);
		} ).start();
	}


	public  Game_Data getData() {
		return data;
	}


	public void setData(Game_Data data) {
		Controller.data = data;
	}
	 
}

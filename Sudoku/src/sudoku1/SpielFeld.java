package sudoku1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.plaf.ColorUIResource;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;;

public class SpielFeld {

	private JButton[][] buttons_grid = new JButton[9][9];
	private JButton[] buttons_control = new JButton[9];
	
	private int entrie = -1;
	
	private Spiel spiel;
	private JLabel la;
	
	public SpielFeld() {
		// TODO Auto-generated constructor stub
	}

	public void erstellen(JPanel contentpane,Spiel spiel,JSpinner s,JCheckBox b,JLabel la ) {
		this.spiel =  spiel;
		this.la = la;
		
		int xs = 10;
		int ys = 11;
		
		int xg = 45;
		int yg = 45;		
		
		int cx = 0;
		int cy = 0;
		
		int tx = 0;
		int ty = 0;
		
		for (int x = xs; x < xg*9; x+=xg,tx++) {
				
			for (int y = ys; y < yg*9; y+=yg,ty++) {
				JButton btnNewButton = new JButton();
				btnNewButton.setToolTipText(tx + ":" + ty);
				buttons_grid[tx][ty] = btnNewButton; 
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						buttonAction_grid(btnNewButton,b);
					}
				});
				btnNewButton.setBounds(x, y, xg, yg);
				contentpane.add(btnNewButton);
				cy++;
				if(cy == 3) {
					y+=10;
					cy = 0;
				}
			}
			ty = 0;
			cx++;
			if(cx == 3) {
				x+=10;
				cx = 0;
			}

		}
		
		for (int i = 0; i < 12; i++) {
			
			if(i == 9 ) {
				JButton btnNewButton = new JButton("Reset");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for(JButton[] a: buttons_grid) {
							for(JButton b: a) {
								b.setBackground(new Color(238,238,238));
								b.setText("");
							}
						}
						while(test_leer() == false) {
							buttonAction_reset(btnNewButton);
							System.gc();
						}
						spiel.entfernen(s);
						timer();
					}
				});
				btnNewButton.setBounds((xg*i)+10, (yg+5)*9, xg+50, yg);
				contentpane.add(btnNewButton);
			}else if(i == 10){
				JButton btnNewButton = new JButton("Mark");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						entrie = -2;
					}
				});
				btnNewButton.setBounds((xg-1*i), (yg+12)*9, xg+50, yg);
				contentpane.add(btnNewButton);
			}else if(i == 11){
				JButton btnNewButton = new JButton("Solve");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for(JButton[] x: buttons_grid) {
							for(JButton y: x) {
								y.setText(y.getToolTipText().split(":")[2]);
							}
							}
					}
				});
				btnNewButton.setBounds((xg*i)-78, (yg+12)*9, xg+50, yg);
				contentpane.add(btnNewButton);
			}else {
			
			
				JButton btnNewButton = new JButton(Integer.toString(i+1));
				btnNewButton.setToolTipText(Integer.toString(i));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						buttonAction_control(btnNewButton);
					}
				});
				btnNewButton.setBounds((xg*i)+10, (yg+5)*9, xg, yg);
				buttons_control[i] = btnNewButton; 
				contentpane.add(btnNewButton);
			}
			
		}
		 
	}
	
	public void buttonAction_grid(JButton b,JCheckBox s ) {
		if(s.isSelected() == true) {
			b.setText(Integer.toString(entrie));
			b.setBackground(Color.PINK);
		}else {
			if(entrie > 0&&spiel.test_line(Integer.parseInt(b.getToolTipText().split(":")[0]),Integer.parseInt(b.getToolTipText().split(":")[1]),entrie) == true&&spiel.test_square(Integer.parseInt(b.getToolTipText().split(":")[0]),Integer.parseInt(b.getToolTipText().split(":")[1]),entrie) == true) {
				b.setText(Integer.toString(entrie));
				b.setBackground(Color.PINK);
			}
		}
		if(b.getBackground() == Color.GREEN&&entrie == -2) {
			b.setBackground(Color.ORANGE);
		}else if(entrie == -2){
			b.setBackground(Color.GREEN);
		}
		 check_win();
	}
	
	public void buttonAction_control(JButton b) {
		for(JButton i: buttons_control) {
			i.setBackground(new ColorUIResource(238,238,238));
		}
		b.setBackground(Color.PINK);
		entrie = Integer.parseInt(b.getText());
	}
	
	public void buttonAction_reset(JButton b) {
		for(JButton[] x: buttons_grid) {
			for(JButton y: x) {
				y.setText("");
			}
			}
		
			spiel.Füllen();
			la.setText("0");
	}
	boolean test_leer() {
		for(JButton[] a: buttons_grid) {
			for(JButton b: a) {
				if(b.getText() == "" ) {
					return false;
				}
			}
		}
		return true;
	}
	
	void check_win() {
		for(JButton[] a: buttons_grid) {
			for(JButton b: a) {
				if(b.getText() == "" ) {
					return;
				}
			}
		}
		new Win_Gui();
	}
	void timer() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				//aufgabe
				la.setText(Integer.toString(Integer.parseInt(la.getText())+1));
			}
		},1000,1000);
	}

	
	
	
	
	
	
	
	public JButton[][] getButtons_grid() {
		return buttons_grid;
	}

	public void setButtons_grid(JButton[][] buttons_grid) {
		this.buttons_grid = buttons_grid;
	}

	public JButton[] getButtons_control() {
		return buttons_control;
	}

	public void setButtons_control(JButton[] buttons_control) {
		this.buttons_control = buttons_control;
	}

	public int getEntrie() {
		return entrie;
	}

	public void setEntrie(int entrie) {
		this.entrie = entrie;
	}
}

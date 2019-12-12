package sudoku1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

public class SpielFeld {

	private JButton[][] buttons_grid = new JButton[9][9];
	private JButton[] buttons_control = new JButton[9];
	
	private int entrie = -1;
	
	public SpielFeld() {
		// TODO Auto-generated constructor stub
	}

	public void erstellen(JPanel contentpane ) {
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
						buttonAction_grid(btnNewButton);
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
		
		for (int i = 0; i < 9; i++) {
			
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
	
	public void buttonAction_grid(JButton b) {
		if(entrie != -1) {
			b.setText(Integer.toString(entrie));
		}
	}
	
	public void buttonAction_control(JButton b) {
		for(JButton i: buttons_control) {
			i.setBackground(new ColorUIResource(238,238,238));
		}
		b.setBackground(Color.RED);
		entrie = Integer.parseInt(b.getText());
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

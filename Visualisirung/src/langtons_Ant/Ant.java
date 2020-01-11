package langtons_Ant;

import java.util.ArrayList;

public class Ant {

	public int size = 10;

	public ArrayList<ArrayList<int[]>> feld = new ArrayList<ArrayList<int[]>>();

	public Ant() {
		// TODO Auto-generated constructor stub
		new Thread(()->{ 
			run();
		}).start();
//		for (int x = 0; x < size0; x++) {
//			for (int y = 0; y < size0; y++) {
//				if (x % size == 0 && y % size == 0 && x % (size * 2) == 0) {
//					ArrayList<int[]> t = new ArrayList<int[]>();
//					feld.add(t);
//					int[] data = { x, y, 1 };
//					feld.get(feld.indexOf(t)).add(data);
//				}
//			}
//		}
	}

	public void run() {
		int xp = 500;
		int yp = 500;
		int direction = 1;
		int[] same = new int[2];
		addFeld(xp, yp, 2);
		while (true) {
			boolean there = false;
			
			for (int x = 0; x < feld.size(); x++) {
				for (int y = 0; y < feld.get(x).size(); y++) {
					if (feld.get(x).get(y)[0] == xp ) {
						if(feld.get(x).get(y)[1] == yp) {
							there = true;
							same[0] = x;
							same[1] = y;
						}
					
					}
				}
			}
			if(there == false||feld.get(same[0]).get(same[1])[2] == 2) {
				addFeld(xp, yp, 1);
				
				switch (direction) {
				case 1:
					xp-=size;
					direction = 2;
					break;

				case 2:
					yp+=size;
					direction = 3;
					break;
				case 3:
					xp+=size;
					direction = 4;
					break;
				case 4:
					yp-=size;
					direction = 1;
					break;
				default:
					break;
				}
				//System.out.println("0: "+direction);
			}else if(feld.get(same[0]).get(same[1])[2] == 1) {
				feld.get(same[0]).get(same[1])[2] = 3;
				
				switch (direction) {
				case 1:
					xp+=size;
					direction = 4;
					break;

				case 2:
					yp-=size;
					direction = 1;
					break;
				case 3:
					xp-=size;
					direction = 2;
					break;
				case 4:
					yp+=size;
					direction = 3;
					break;
				default:
					break;
				}
				//System.out.println("1: "+direction);
			}else if(feld.get(same[0]).get(same[1])[2] == 3) {
				feld.get(same[0]).get(same[1])[2] = 4;
				
				switch (direction) {
				case 1:
					xp+=size;
					direction = 4;
					break;

				case 2:
					yp-=size;
					direction = 1;
					break;
				case 3:
					xp-=size;
					direction = 2;
					break;
				case 4:
					yp+=size;
					direction = 3;
					break;
				default:
					break;
				}
			}else if(feld.get(same[0]).get(same[1])[2] == 4) {
				feld.get(same[0]).get(same[1])[2] = 2;
				
				switch (direction) {
				case 1:
					xp+=size;
					direction = 4;
					break;

				case 2:
					yp-=size;
					direction = 1;
					break;
				case 3:
					xp-=size;
					direction = 2;
					break;
				case 4:
					yp+=size;
					direction = 3;
					break;
				default:
					break;
				}
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}

	public void add(int x, int y, int color) {
		addFeld(x, y, color);
	}
	
	public void addFeld(int x, int y, int color) {
		ArrayList<int[]> t = new ArrayList<int[]>();
		feld.add(t);
		int[] data = { x, y, color };
		feld.get(feld.indexOf(t)).add(data);
	}
}

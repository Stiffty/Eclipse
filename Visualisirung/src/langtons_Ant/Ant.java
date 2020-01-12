package langtons_Ant;

import java.util.ArrayList;
import java.util.Random;

public class Ant {

	private  int size = 1;

	public ArrayList<ArrayList<int[]>> feld = new ArrayList<ArrayList<int[]>>();
	public byte[][] feld1 = new byte[10000][10000];

	private  int[] b = new int[8];
	
	public static int xp = 500;
	public static int yp = 500;
	
	public static int xMax = 500;
	public static int yMax = 500;
	
	public Ant() {
		// TODO Auto-generated constructor stub

		new Thread(() -> {
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
		
		int direction = 1;
		int[] same = new int[2];
		boolean there = true;
		// addFeld(xp, yp, 2);
		Random rd = new Random();
		
		for (int i = 0; i < b.length; i++) {
			b[i] = rd.nextInt(2);
		}
		
		while (true) {
			if(xp-size <0) {
				xp = 0;
			}
			if(yp-size<0){
				yp = 0;
			}
			if(xp+size >feld1.length) {
				xp = feld1.length-1;
			}
			if(yp+size >feld1.length) {
				yp = feld1.length-1;
			}		
			
//			for (int x = 0; x < feld.size(); x++) {
//				for (int y = 0; y < feld.get(x).size(); y++) {
//					if (feld.get(x).get(y)[0] == xp ) {
//						if(feld.get(x).get(y)[1] == yp) {
//							there = true;
//							same[0] = x;
//							same[1] = y;
//						}
//					
//					}
//				}
//			}
			if (feld1[xp][yp] == 2) {
				// addFeld(xp, yp, 1);
				feld1[xp][yp] = 1;

				if(b[0] == 1) {
					same = leftturn(direction, xp, yp);
				}else {
					same = rigthturn(direction, xp, yp);
				}

			} else if (feld1[xp][yp] == 1) {
				feld1[xp][yp] = 3;

				if(b[1] == 1) {
					same = leftturn(direction, xp, yp);
				}else {
					same = rigthturn(direction, xp, yp);
				}

			} else if (feld1[xp][yp] == 3) {
				feld1[xp][yp] = 4;

				if(b[2] == 1) {
					same = leftturn(direction, xp, yp);
				}else {
					same = rigthturn(direction, xp, yp);
				}

			} else if (feld1[xp][yp] == 4) {
				feld1[xp][yp] = 5;

				if(b[3] == 1) {
					same = leftturn(direction, xp, yp);
				}else {
					same = rigthturn(direction, xp, yp);
				}

			} else if (feld1[xp][yp] == 5) {
				feld1[xp][yp] = 6;

				if(b[4] == 1) {
					same = leftturn(direction, xp, yp);
				}else {
					same = rigthturn(direction, xp, yp);
				}
			} else if (feld1[xp][yp] == 6) {
				feld1[xp][yp] = 7;

				if(b[5] == 1) {
					same = leftturn(direction, xp, yp);
				}else {
					same = rigthturn(direction, xp, yp);
				}
			} else if (feld1[xp][yp] == 7) {
				feld1[xp][yp] = 8;

				if(b[6] == 1) {
					same = leftturn(direction, xp, yp);
				}else {
					same = rigthturn(direction, xp, yp);
				}
			}else if (feld1[xp][yp] == 8) {
				feld1[xp][yp] = 2;

				if(b[7] == 1) {
					same = leftturn(direction, xp, yp);
				}else {
					same = rigthturn(direction, xp, yp);
				}
			}else {
				// addFeld(xp, yp, 1);
				feld1[xp][yp] = 1;

				same = leftturn(direction, xp, yp);

			}

			xp = same[0];
			yp = same[1];
			direction = same[2];
			
			if(xp>xMax) {
				xMax = xp;
			}
			if(yp>yMax) {
				yMax = yp;
			}
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	int[] rigthturn(int direction, int xp, int yp) {
		switch (direction) {
		case 1:
			xp += size;
			direction = 4;
			break;

		case 2:
			yp -= size;
			direction = 1;
			break;
		case 3:
			xp -= size;
			direction = 2;
			break;
		case 4:
			yp += size;
			direction = 3;
			break;
		default:
			break;
		}
		int[] data = { xp, yp, direction };
		return data;
	}

	int[] leftturn(int direction, int xp, int yp) {
		switch (direction) {
		case 1:
			xp -= size;
			direction = 2;
			break;

		case 2:
			yp += size;
			direction = 3;
			break;
		case 3:
			xp += size;
			direction = 4;
			break;
		case 4:
			yp -= size;
			direction = 1;
			break;
		default:
			break;
		}
		int[] data = { xp, yp, direction };
		return data;
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

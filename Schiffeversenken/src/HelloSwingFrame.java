import javax.swing.JFrame;

public class HelloSwingFrame {
	public static void main(String[] args) {
		JFrame f = new JFrame("Das Fenster zur Welt!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 200);
		f.setVisible(true);
	}
}
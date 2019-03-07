
// Import-Anweisungen
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class JMenu_Beispiel {
	public static void main(String[] args) {
		/* Erzeugung eines neuen Dialoges */
		JDialog meinJDialog = new JDialog();
		meinJDialog.setTitle("JMenuBar für unser Java Tutorial Beispiel.");
		// Wir setzen die Breite auf 450 und die Höhe 300 Pixel
		meinJDialog.setSize(450, 300);
		// Zur Veranschaulichung erstellen wir hier eine Border
		Border bo = new LineBorder(Color.yellow);
		// Erstellung einer Menüleiste
		JMenuBar bar = new JMenuBar();
		// Wir setzen unsere Umrandung für unsere JMenuBar
		bar.setBorder(bo);
		// Erzeugung eines Objektes der Klasse JMenu
		JMenu menu = new JMenu("Ich bin ein JMenu");
		// Menü wird der Menüleiste hinzugefügt
		bar.add(menu);
		// Menüleiste wird für den Dialog gesetzt
		meinJDialog.setJMenuBar(bar);
		// Wir lassen unseren Dialog anzeigen
		meinJDialog.setVisible(true);
	}
}
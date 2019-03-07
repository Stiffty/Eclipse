
// Import-Anweisungen
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

public class JMenuBar_Beispiel {
	public JMenuBar_Beispiel() {
		// Erzeugung eines neuen Dialoges
		JDialog meinJDialog = new JDialog();
		meinJDialog.setTitle("JMenuBar für unser Java Tutorial Beispiel.");
		meinJDialog.setSize(450, 300);
		// Zur Veranschaulichung erstellen wir eine gelbe Umrandung
		Border bo = new LineBorder(Color.yellow);
		// Erstellen einer Menüleiste
		JMenuBar bar = new JMenuBar();
		// Wir setzen die erstellte Umrandung für unsere Menüleiste
		bar.setBorder(bo);
		// Menüleiste wird für den Dialog gesetzt
		meinJDialog.setJMenuBar(bar);
		// Wir lassen unseren Dialog anzeigen
		meinJDialog.setVisible(true);
	}

	public static void main(String[] args) {
		new JMenuBar_Beispiel();

	}
}
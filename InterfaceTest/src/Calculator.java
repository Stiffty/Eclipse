import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
	public static void main(String[] args) {
		CalculatorFrame frame = new CalculatorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame sichtbar machen
		frame.setVisible(true);
		frame.setSize(600, 600);//größe
	}
}

/**
 * Leeren Frame ohne Größe erzeugen.
 */
class CalculatorFrame extends JFrame {
	public CalculatorFrame() {
		setTitle("Calculator"); // Name der Titelleiste
		CalculatorPanel panel = new CalculatorPanel();// panel wird erstellt (content panel)
		add(panel);
	}
}

class CalculatorPanel extends JPanel {
	public CalculatorPanel() {
		setLayout(new BorderLayout()); // Layout-Manager festlegen
		result = 0;
		lastCommand = "=";
		start = true;
		
		// Display hinzufügen
		display = new JButton("0");
		display.setEnabled(false);
		
		// Display oben positionieren
		add(display, BorderLayout.NORTH);
		display.setBounds(80, 80, 80, 80);
		
		// ActionListener insert erzeugen
		ActionListener insert = new InsertAction();
		
		// ActionListener command erzeugen
		ActionListener command = new CommandAction();
		panel = new JPanel();
		
		// Angabe der Anzahl von Spalten und Zeilen im Konstruktor
		panel.setLayout(new GridLayout(4, 4));

		// Generierung der numerischen Taschenrechner-Tasten
		// Die Aktion insert als zweiten Parameter hinzufügen
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);

		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);

		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);

		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);

		// Panel Komponenten im Centerblock platzieren
		add(panel, BorderLayout.CENTER);
	}

	/**
	 * @param label    Beschriftung der Taste
	 * @param listener der Ereignisempfänger für die Taste
	 */
	private void addButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		
		// Ereignisempfänger für die Schaltfläche
		button.addActionListener(listener);
		panel.add(button);
	}

	/**
	 * Diese Aktion fügt den String der Tastenaktion an das Ende des Anzeigetextes
	 * an.
	 */
	private class InsertAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String input = event.getActionCommand();
			
			// Beim Start keinen Text anzeigen
			// Das Start Flag anschließend auf false setzen
			if (start) {
				display.setText("");
				start = false;
			}
			// Text anzeigen
			display.setText(display.getText() + input);
		}
	}

	/**
	 * Diese Aktion führt den mit der Taste verbundenen Befehl aus.
	 */
	private class CommandAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String command = event.getActionCommand();

			// Füge den Präfix "-" an den String an wenn
			// es sich um den ersten Befehl handelt (negative Zahl)
			if (start) {
				if (command.equals("-")) {
					display.setText(command);
					start = false;
				} else
					lastCommand = command;
			} else {
				
				// Berechnung ausführen
				calculate(Double.parseDouble(display.getText()));
				lastCommand = command;
				start = true;
			}
		}
	}

	/**
	 * Führt die anstehenden Berechnungen aus.
	 * 
	 * @param x der mit dem vorherigen Ergebnis zu berechnende Wert
	 */
	public void calculate(double x) {
		if (lastCommand.equals("+"))
			result += x;
		else if (lastCommand.equals("-"))
			result -= x;
		else if (lastCommand.equals("*"))
			result *= x;
		else if (lastCommand.equals("/"))
			result /= x;
		else if (lastCommand.equals("="))
			result = x;
		display.setText("" + result);
	}

	private JButton display;
	private JPanel panel;
	private boolean start;
	private double result;
	private String lastCommand;
}

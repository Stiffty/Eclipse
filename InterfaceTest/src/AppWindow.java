
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;




public class AppWindow extends JFrame {

	JTextField 	textfield_dm;
	JTextField 	textfield_euro;

	JButton		button;


	public AppWindow() {
		this.getContentPane().setLayout(null);

		this.initWindow();

		this.addWindowListener(new WindowListener() {

			public void windowClosed(WindowEvent arg0) {


			}

			public void windowActivated(WindowEvent e) {


			}

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowDeactivated(WindowEvent e) {


			}

			public void windowDeiconified(WindowEvent e) {


			}

			public void windowIconified(WindowEvent e) {


			}

			public void windowOpened(WindowEvent e) {


			}



		});

	}

	protected void initWindow() 
	{
		// Instanzieren:
		textfield_dm = new JTextField();
		textfield_euro = new JTextField();

		button = new JButton("DM in Euro");

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				buttonBerechneClicked();
			}

		});

		// Positionen festlegen
		textfield_dm.setBounds(5,10,400,25);
		textfield_euro.setBounds(5,80,400,25);

		button.setBounds(300,110,100,30);

		// Elemente dem Fenster hinzufügen:
		this.getContentPane().add(textfield_dm);
		this.getContentPane().add(textfield_euro);
		this.getContentPane().add(button);


		this.pack();
	}

	public void buttonBerechneClicked()
	{
		// Hole Zahl aus Textfeld:
		double dm = 0;
		try {
			dm = Double.parseDouble(textfield_dm.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			dm = -1;
		}

		// Falls das n Okay ist:

		if (dm>=0) {
		// Rechne:
			double euro = this.dm2euro(dm);

			// Packe a in Ausgabefeld:
			NumberFormat nf = NumberFormat.getInstance();

			nf.setMaximumFractionDigits(2);

			String ausgabe = nf.format(euro);



			textfield_euro.setText(ausgabe);
		} else {
			textfield_euro.setText("Eingabe ist nicht in Ordnung.");
		}
	}

	public double dm2euro(double dm)
	{
		double euro = (dm / 1.95583);



		return euro;
	}
}

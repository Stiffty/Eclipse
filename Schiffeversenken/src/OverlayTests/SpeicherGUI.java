package OverlayTests;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SpeicherGUI extends JDialog {

	private int counter;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SpeicherGUI dialog = new SpeicherGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @throws IOException
	 */
	public SpeicherGUI() throws IOException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Speichern();
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					Lesen();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		setBounds(100, 100, 450, 82);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Lesen();
		JLabel lblNewLabel = new JLabel(String.valueOf(counter));
		lblNewLabel.setBounds(187, 15, 48, 14);
		contentPanel.add(lblNewLabel);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				lblNewLabel.setText(String.valueOf(counter));
			}
		});
		btnAdd.setBounds(335, 11, 89, 23);
		contentPanel.add(btnAdd);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter = 0;
				lblNewLabel.setText(String.valueOf(counter));
			}
		});
		btnReset.setBounds(10, 11, 89, 23);
		contentPanel.add(btnReset);
	}

	public void Speichern() {
		try {
			File file = new File("Counter.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(String.valueOf(counter));
			bw.flush();
			bw.close();
			// sc.next();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Lesen() throws IOException {
		try {
			String line;

			FileReader fr = new FileReader("Counter.txt");
			BufferedReader br = new BufferedReader(fr);

			counter = Integer.parseInt(br.readLine());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

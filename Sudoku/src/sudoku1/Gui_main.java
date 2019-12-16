package sudoku1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class Gui_main extends JFrame {

	private JPanel contentPane;
	private SpielFeld spielfeld = new SpielFeld();
	private Spiel spiel = new Spiel(spielfeld.getButtons_grid());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_main frame = new Gui_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 611);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmDifficulty = new JMenuItem("Difficulty");
		mntmDifficulty.setSelected(true);
		mntmDifficulty.setEnabled(false);
		mnOptions.add(mntmDifficulty);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(2, 2, 10, 1));
		mnOptions.add(spinner);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JCheckBox chckbxHardmode = new JCheckBox("Hardmode");
		mnOptions.add(chckbxHardmode);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(446, 165, 77, 14);
		contentPane.add(lblNewLabel);
		spielfeld.erstellen(contentPane,spiel,spinner,chckbxHardmode,lblNewLabel);
		
		
		
		//spiel.Füllen();
	}
}

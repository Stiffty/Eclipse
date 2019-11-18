package FrimenSoftware;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FirmaGUI extends JFrame {

	private JPanel contentPane;
	private firma Firma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirmaGUI frame = new FirmaGUI();
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
	public FirmaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTest = new JLabel("test");
		lblTest.setBounds(103, 34, 46, 14);
		contentPane.add(lblTest);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setToolTipText("test");
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.RED, 3));
		panel.setBounds(5, 196, 424, 60);
		contentPane.add(panel);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(41, 88, 268, 46);
		contentPane.add(splitPane);
		
		JSeparator separator = new JSeparator();
		splitPane.setLeftComponent(separator);
		
		JButton btnNewButton = new JButton("New button");
		splitPane.setRightComponent(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(335, 149, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}

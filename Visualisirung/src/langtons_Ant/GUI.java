package langtons_Ant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;

	private Frame f;
	
	private int[][] b = new int[8][2];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		btnCancel.setBounds(171, 288, 89, 23);
		contentPane.add(btnCancel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("0");
		chckbxNewCheckBox.setBounds(10, 7, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("1");
		checkBox.setBounds(10, 33, 97, 23);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("2");
		checkBox_1.setBounds(10, 59, 97, 23);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("3");
		checkBox_2.setBounds(10, 85, 97, 23);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("4");
		checkBox_3.setBounds(10, 111, 97, 23);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("5");
		checkBox_4.setBounds(10, 137, 97, 23);
		contentPane.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("6");
		checkBox_5.setBounds(10, 163, 97, 23);
		contentPane.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("7");
		checkBox_6.setBounds(10, 189, 97, 23);
		contentPane.add(checkBox_6);
		
		JCheckBox chckbxLeft = new JCheckBox("Left");
		chckbxLeft.setSelected(true);
		chckbxLeft.setBounds(117, 7, 97, 23);
		contentPane.add(chckbxLeft);
		
		JCheckBox chckbxRight = new JCheckBox("Right");
		chckbxRight.setBounds(212, 7, 97, 23);
		contentPane.add(chckbxRight);
		
		JCheckBox checkBox_7 = new JCheckBox("Left");
		checkBox_7.setSelected(true);
		checkBox_7.setBounds(117, 33, 97, 23);
		contentPane.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("Right");
		checkBox_8.setBounds(212, 33, 97, 23);
		contentPane.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("Left");
		checkBox_9.setSelected(true);
		checkBox_9.setBounds(117, 59, 97, 23);
		contentPane.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("Right");
		checkBox_10.setBounds(212, 59, 97, 23);
		contentPane.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("Left");
		checkBox_11.setSelected(true);
		checkBox_11.setBounds(117, 85, 97, 23);
		contentPane.add(checkBox_11);
		
		JCheckBox checkBox_12 = new JCheckBox("Right");
		checkBox_12.setBounds(212, 85, 97, 23);
		contentPane.add(checkBox_12);
		
		JCheckBox checkBox_13 = new JCheckBox("Left");
		checkBox_13.setSelected(true);
		checkBox_13.setBounds(117, 111, 97, 23);
		contentPane.add(checkBox_13);
		
		JCheckBox checkBox_14 = new JCheckBox("Right");
		checkBox_14.setBounds(212, 111, 97, 23);
		contentPane.add(checkBox_14);
		
		JCheckBox checkBox_15 = new JCheckBox("Left");
		checkBox_15.setSelected(true);
		checkBox_15.setBounds(117, 137, 97, 23);
		contentPane.add(checkBox_15);
		
		JCheckBox checkBox_16 = new JCheckBox("Right");
		checkBox_16.setBounds(212, 137, 97, 23);
		contentPane.add(checkBox_16);
		
		JCheckBox checkBox_17 = new JCheckBox("Left");
		checkBox_17.setSelected(true);
		checkBox_17.setBounds(117, 163, 97, 23);
		contentPane.add(checkBox_17);
		
		JCheckBox checkBox_18 = new JCheckBox("Right");
		checkBox_18.setBounds(212, 163, 97, 23);
		contentPane.add(checkBox_18);
		
		JCheckBox checkBox_19 = new JCheckBox("Left");
		checkBox_19.setSelected(true);
		checkBox_19.setBounds(117, 189, 97, 23);
		contentPane.add(checkBox_19);
		
		JCheckBox checkBox_20 = new JCheckBox("Right");
		checkBox_20.setBounds(212, 189, 97, 23);
		contentPane.add(checkBox_20);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxNewCheckBox.isSelected()) {
					if(chckbxLeft.isSelected()) {
						b[0][0] = 1;
					}else if(chckbxRight.isSelected()) {
						b[0][1] = 1;
					}
				}else {
					b[0][0] = -1;
				}
				
				if(checkBox_1.isSelected()) {
					if(checkBox_7.isSelected()) {
						b[1][0] = 1;
					}else if(checkBox_8.isSelected()) {
						b[1][1] = 1;
					}
				}else {
					b[1][0] = -1;
				}
				
				if(checkBox_2.isSelected()) {
					if(checkBox_9.isSelected()) {
						b[2][0] = 1;
					}else if(checkBox_10.isSelected()) {
						b[2][1] = 1;
					}
				}else {
					b[2][0] = -1;
				}
				
				if(checkBox_3.isSelected()) {
					if(checkBox_11.isSelected()) {
						b[3][0] = 1;
					}else if(checkBox_12.isSelected()) {
						b[3][1] = 1;
					}
				}else {
					b[3][0] = -1;
				}
				
				if(checkBox_4.isSelected()) {
					if(checkBox_13.isSelected()) {
						b[4][0] = 1;
					}else if(checkBox_14.isSelected()) {
						b[4][1] = 1;
					}
				}else {
					b[4][0] = -1;
				}
				
				if(checkBox_5.isSelected()) {
					if(checkBox_15.isSelected()) {
						b[5][0] = 1;
					}else if(checkBox_16.isSelected()) {
						b[5][1] = 1;
					}
				}else {
					b[5][0] = -1;
				}
				
				if(checkBox_6.isSelected()) {
					if(checkBox_17.isSelected()) {
						b[6][0] = 1;
					}else if(checkBox_18.isSelected()) {
						b[6][1] = 1;
					}
				}else {
					b[6][0] = -1;
				}
				
				if(checkBox_8.isSelected()) {
					if(checkBox_19.isSelected()) {
						b[7][0] = 1;
					}else if(checkBox_20.isSelected()) {
						b[7][1] = 1;
					}
				}else {
					b[7][0] = -1;
				}
				
				f = new Frame(b);
			}
		});
		btnStart.setBounds(10, 288, 89, 23);
		contentPane.add(btnStart);
	}
}

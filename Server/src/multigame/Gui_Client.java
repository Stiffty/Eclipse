package multigame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Gui_Client extends JFrame {

	private JPanel contentPane;
	private JTextField txtLocalhost;
	private JTextField txtPort;
	private JButton btnConnect;
	private JButton btnTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Client frame = new Gui_Client();
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
	public Gui_Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLocalhost = new JTextField();
		txtLocalhost.setText("localhost");
		txtLocalhost.setBounds(10, 11, 86, 20);
		contentPane.add(txtLocalhost);
		txtLocalhost.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setText("Port");
		txtPort.setBounds(106, 11, 86, 20);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		btnTest = new JButton("test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnTest.getBackground() == Color.BLUE) {
					btnTest.setBackground(Color.ORANGE);
				}else {
					btnTest.setBackground(Color.BLUE);
				}
				
			}
		});
		btnTest.setBounds(278, 10, 89, 23);
		contentPane.add(btnTest);
		
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(() ->{
					try {
						new Client(new Socket(txtLocalhost.getText(),Integer.parseInt(txtPort.getText())),btnTest);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();
				btnConnect.setEnabled(false);
			}
		});
		btnConnect.setBounds(106, 42, 89, 23);
		contentPane.add(btnConnect);
	}
}

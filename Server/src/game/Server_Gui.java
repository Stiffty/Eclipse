package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Server_Gui extends JFrame {

	private JPanel contentPane;
	private Server server;
	private JTextField txtIp;
	private JTextField txtPort;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_Gui frame = new Server_Gui();
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
	public Server_Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(64, 46, 57, 44);
		contentPane.add(list);
		
		JLabel lblClients = new JLabel("Clients:");
		lblClients.setBounds(64, 21, 46, 14);
		contentPane.add(lblClients);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnOpen.setBounds(256, 82, 89, 23);
		contentPane.add(btnOpen);
		
		txtIp = new JTextField();
		txtIp.setText("IP");
		txtIp.setBounds(204, 44, 86, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setText("Port");
		txtPort.setBounds(300, 44, 86, 20);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
	}
}

package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Client_Gui extends JFrame {

	private JPanel contentPane;
	private Client client;
	private JTextField txtIp;
	private JTextField txtPort;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Gui frame = new Client_Gui();
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
	public Client_Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIp = new JTextField();
		txtIp.setText("ip");
		txtIp.setBounds(25, 53, 86, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setText("port");
		txtPort.setBounds(121, 53, 86, 20);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(118, 97, 89, 23);
		contentPane.add(btnConnect);
		
		JLabel lblMassage = new JLabel("Massage:");
		lblMassage.setBounds(313, 56, 56, 14);
		contentPane.add(lblMassage);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(280, 97, 89, 23);
		contentPane.add(btnNewButton);
	}
}

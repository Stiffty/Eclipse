package multigame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;

public class Server_send extends Thread{

	private Socket client;
	private ObjectOutputStream out;
	
	private JButton b;
	
	public Server_send(Socket client) {
		// TODO Auto-generated constructor stub
		this.client = client;
		try {
			out = new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				out.writeObject(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public JButton getB() {
		return b;
	}

	public void setB(JButton b) {
		this.b = b;
	}

}

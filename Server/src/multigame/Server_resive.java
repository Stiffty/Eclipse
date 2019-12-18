package multigame;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JButton;

public class Server_resive extends Thread{
	
	private Socket client;
	private ObjectInputStream in;
	
	private JButton b;
	
	public Server_resive(Socket client)  {
		// TODO Auto-generated constructor stub
			this.client = client;
			try {
				in = new ObjectInputStream(client.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void run() {
		while(true) {
			try {
				this.b = (JButton) in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

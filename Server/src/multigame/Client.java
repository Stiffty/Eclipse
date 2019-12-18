package multigame;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Client {

	private JButton bu;
	public Client(Socket client,JButton b) {
		// TODO Auto-generated constructor stub
	
		try {
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			
			new Thread(()->{
				while(true) {
					try {
						if(in.readObject()!= b&&in.readObject()!= null) {
							b.setBackground(((JButton) in.readObject()).getBackground());
							//((JButton) in.readObject()).getBackground()
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
			
			while(true) {
				out.writeObject(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

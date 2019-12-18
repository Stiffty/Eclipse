package multigame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;

public class Game_server {

	private JButton c1 = new JButton();
	private JButton c2= new JButton();
	
	private Server_resive resive1;
	private Server_resive resive2;
	
	private Server_send send1;
	private Server_send send2;
	
	public Game_server(Socket client1,Socket client2) {
		// TODO Auto-generated constructor stub
//		resive1 = new Server_resive(client1);
//		send1 = new Server_send(client1);
//		
//		resive2 = new Server_resive(client2);
//		send2 = new Server_send(client2);
//		
//		resive1.start();
//		send1.start();
//		
//		resive2.start();
//		send2.start();
		try {
			ObjectInputStream in1 = new ObjectInputStream(client1.getInputStream());
			ObjectInputStream in2 = new ObjectInputStream(client2.getInputStream());
			
			ObjectOutputStream out1 = new ObjectOutputStream(client1.getOutputStream());
			ObjectOutputStream out2 = new ObjectOutputStream(client2.getOutputStream());
		
		while(true) {
			if(((JButton)in1.readObject()).getBackground()!= c1.getBackground()) {
				c1.setBackground(((JButton) in1.readObject()).getBackground());
				//send all
				out2.writeObject(c1);
			}
			if(in2.readObject()!= null&&((JButton)in2.readObject()).getBackground()!= c2.getBackground()) {
				c2.setBackground(((JButton) in2.readObject()).getBackground());
				//send all
				out1.writeObject(c2);
			}
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}

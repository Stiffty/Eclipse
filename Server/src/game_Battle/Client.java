package game_Battle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public Client(Controller ihost,String ip,int port) {
		// TODO Auto-generated constructor stub
		try {
			Socket client = new Socket(ip,port);
			
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			
			new Thread(()->{ 
				while(true) {
					try {
						out.writeObject(ihost.getData());
						Thread.sleep(100);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}).start();
			
			while(true) {
				while(true) {
					try {
						ihost.setData((Game_Data) in.readObject());
						Thread.sleep(100);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		}

}

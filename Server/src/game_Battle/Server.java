package game_Battle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {

	private List<Socket> clients = new LinkedList<Socket>();
	private Game_Data data = new Game_Data();
	public Server() {
		// TODO Auto-generated constructor stub
		try {
			ServerSocket server = new ServerSocket(333);
			while(clients.size()<2) {
				Socket client = server.accept();
				System.out.println("connected");
				clients.add(client);
			}
			new Thread(() ->{
				send(clients.get(0));
			} ).start();
			send(clients.get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void send(Socket client) {
		new Thread(() -> { 
			try {
				ObjectInputStream in = new ObjectInputStream(client.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
				
				new Thread(()->{ 
					while(true) {
						try {
							data = (Game_Data) in.readObject();
							Thread.sleep(100);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
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
					out.writeObject(data);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(data.getP1_x());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Server();
	}

}

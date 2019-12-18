package multigame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class Server {

	private ServerSocket server;
	private Game_server game;
	
	private List<Socket> clients = new ArrayList<Socket>();
	
	public Server(int port ) {
		// TODO Auto-generated constructor stub
		
		try {
			server = new ServerSocket(port);
			
			while(true) {
				Socket client = server.accept();
				System.out.println("Connected"+client.getInetAddress());
				clients.add(client);
				if(clients.size()%2 == 0) {
					
					new Thread(() -> {
						game = new Game_server(clients.get(clients.size()-1),clients.get(clients.size()-2));
					}).start();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

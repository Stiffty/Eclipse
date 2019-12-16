package game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mulithread_Message.Server_comunicator;

public class Server {

	private ServerSocket server;
	
	private List<Connection_Client> clients = new ArrayList<Connection_Client>();
	
	public Server(String ip,String port) {
		// TODO Auto-generated constructor stub
		try {
			server = new ServerSocket(Integer.parseInt(port));
			server.setSoTimeout(1000000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start() {
		// TODO Auto-generated constructor stub
		try {
			while(true) {
			Socket client = server.accept();
			
			clients.add(new Connection_Client());
			clients.get(clients.size()-1).start();
			System.out.println( client.getRemoteSocketAddress() + " Connected.");
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

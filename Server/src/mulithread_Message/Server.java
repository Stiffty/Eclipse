package mulithread_Message;
import java.awt.List;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Server {

	private ServerSocket server;
	private LinkedList<Server_comunicator> clients = new LinkedList<Server_comunicator>();
	private LinkedList<Thread> commuter = new LinkedList<Thread>();
	public Server(int port) {
		// TODO Auto-generated constructor stub
		try {
			server = new ServerSocket(port);
			server.setSoTimeout(1000000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void laufen() {
		while (true) {
			try {
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Waiting for Client on " + server.getLocalPort());
				
				while(true) {
				Socket client = server.accept();
				commuter.add( new Thread(() -> {
				    // your code here ...
					clients.add(new Server_comunicator(client));
					
				}));
				 commuter.get(commuter.size()-1).start();
				System.out.println( client.getRemoteSocketAddress() + " Connected.");
				
				
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Server s = new Server(1134);
		s.laufen();
	}

}
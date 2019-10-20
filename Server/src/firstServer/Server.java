package firstServer;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {

	private ServerSocket server;
	
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

	public void laufen () {
		while(true) {
			try {
				System.out.println("Waiting for Client on " + server.getLocalPort());
				Socket client = server.accept();
				
				DataInputStream in = new DataInputStream(client.getInputStream());
				System.out.println(in.readUTF());
				
				DataOutputStream out = new DataOutputStream(client.getOutputStream());
				out.writeUTF("Welcome on this Server!");
				
				client.close();
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

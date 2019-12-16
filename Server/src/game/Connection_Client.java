package game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection_Client extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	
	public Connection_Client(Socket client) {
		// TODO Auto-generated constructor stub
		try {
			in = new DataInputStream(client.getInputStream());
			System.out.println(in.readUTF());

			out = new DataOutputStream(client.getOutputStream());
			out.writeUTF("Welcome on this Server!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			while(true) {
				//out.writeUTF("Server: " + sc.next());
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

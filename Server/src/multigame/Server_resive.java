package multigame;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Server_resive extends Thread{
	
	private Socket client;
	private DataInputStream in;
	
	public Server_resive(Socket client)  {
		// TODO Auto-generated constructor stub
			this.client = client;
			try {
				in = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void run() {
		
	}

}

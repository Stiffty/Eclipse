package firstServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket client = new Socket("25.64.198.50", 1134);
			
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			out.writeUTF("Hello i am " + client.getRemoteSocketAddress() +"\n"+ client.getLocalAddress());
			
			DataInputStream in = new DataInputStream(client.getInputStream());
			System.out.println(in.readUTF());
			
			client.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

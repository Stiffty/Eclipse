package mulithread_Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Server_comunicator {

	public Server_comunicator(Socket client) {
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Test1");
		try {
			DataInputStream in = new DataInputStream(client.getInputStream());
			System.out.println(in.readUTF());

			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			out.writeUTF("Welcome on this Server!");
		
		
		Thread recive = new Thread(() -> {
		    // your code here ...
			try {
			while(true) {
				
				out.writeUTF("Server: " + sc.next());
				
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		recive.start();
		
		while (client.isConnected() == true) {

			String ein = in.readUTF();
			
			if (ein.equals("exit")) {
					client.close();
			} else {
					System.out.println(ein);
			}
			
		}
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	}

}

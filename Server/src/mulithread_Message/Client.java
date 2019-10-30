package mulithread_Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			
			Socket client = new Socket("10.18.6.2", 1134);
			
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			out.writeUTF("Hello i am " + Inet4Address.getLocalHost());
			
			DataInputStream in = new DataInputStream(client.getInputStream());
			System.out.println(in.readUTF());
			
			
			Thread send = new Thread(() -> {
			    // your code here ...
				try {
					while (true) {
				String ein = in.readUTF();
				
				if (ein.equals("exit")) {
						client.close();
				} else {
						System.out.println(ein);
				}
				}
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			send.start();
			
			while(true) {
				
				out.writeUTF("<" + Inet4Address.getLocalHost()  + "> " + (String) sc.next());
				//client.getLocalAddress()
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package serverClient;

import java.io.IOException;

public class ServerThreadChat extends Thread{

	Socket socket;
	public ServerThreadChat(Socket s) {
		// TODO Auto-generated constructor stub
	socket = s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("waiting...");
		while(true){
			try {
				String text = socket.readLine();
				System.out.println(text);
				MultiServer.messages.add(text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}

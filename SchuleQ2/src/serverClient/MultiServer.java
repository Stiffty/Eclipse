package serverClient;

import java.io.IOException;

public class MultiServer {
	private int port;
	private ServerSocket ss;
	private int sum;
	
	public MultiServer(int port) throws IOException {
		// TODO Auto-generated constructor stub
		this.port = port;
		ss = new ServerSocket(port);
		System.out.println("started");
		sum = 0;
		runServer();
	}
	
	public void runServer() throws IOException {
		// TODO Auto-generated method stub
		while(true){
			new ServerThread(ss.accept(), sum).start();
			sum++;
			System.out.println("Neuer Client angenommen. Anzahl der clients: " + sum);
		}
	}
}

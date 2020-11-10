package serverClient;

import java.io.IOException;

public class MyServer {
	private int port;
	private ServerSocket ss;
	
	public MyServer(int port) throws IOException {
		super();
		this.port = port;
		ss = new ServerSocket(port);
		System.out.println("started");
		runServer();
	}
	
	private void runServer() throws IOException{
		while(true){
			System.out.println("waiting..");
			Socket s = ss.accept();
			System.out.println("Client connected");
			int empfang;
			do {
				empfang = s.read();
				
				System.out.println((char)empfang);
				
				if(empfang ==(int)'a'){
					s.write("Hello\n");
				}
				
			} while (empfang != 'b');
			s.close();
		}
	}
	
	public void beendeServer() throws IOException{
		ss.close();
	}
	
}

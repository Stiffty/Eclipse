package serverClient;

import java.io.IOException;

public class UIServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UIServer();
	}

	public UIServer() {
		// TODO Auto-generated constructor stub
		try {
			MultiServer server = new MultiServer(4711);
			System.out.println("Started");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

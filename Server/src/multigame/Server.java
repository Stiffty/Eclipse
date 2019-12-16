package multigame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class Server {

	private ServerSocket server;
	
	List<Socket> clients = new ArrayList<Socket>();
	
	public Server(int port,JPanel contentPane ) {
		// TODO Auto-generated constructor stub
		
		try {
			server = new ServerSocket(port);
			
			while(true) {
				Socket client = server.accept();
				clients.add(client);
				JList list = new JList();
				list.setBounds(15, 81, 283, 174);
				contentPane.add(list);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

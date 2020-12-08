package serverClient;

import java.awt.List;
import java.io.IOException;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MultiServer {
	private int port;
	private ServerSocket ss;
	private int sum;
	
	public static Hashtable<String,Socket> clients = new Hashtable<>();
	public static Queue<String> messages = new LinkedList<>();
	
	public MultiServer(int port) throws IOException {
		// TODO Auto-generated constructor stub
		this.port = port;
		ss = new ServerSocket(port);
		System.out.println("started");
		sum = 0;
		shareData();
		runServer();
	}
	
	public void shareData(){
		new Thread(()->{
			while(true){
				if(messages.peek() != null){
					System.out.println(messages.peek());
					if(messages.peek().contains("@")){
					for (String string : clients.keySet()) {
						System.out.println(messages.peek() + "  " + string);
						if(messages.peek().contains(string)){
							try {
								clients.get(string).write(messages.poll()+"\n");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					}else{
//					for (Socket socket : clients.values()) {
//						try {
//							socket.write(messages.peek()+"\n");
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						}
//					messages.poll();
					}
				}
			}
		}).start();
	}
	
	public void runServer() throws IOException {
		// TODO Auto-generated method stub
		Socket client;
		while(true){
			client = ss.accept();
			new ServerThreadChat(client).start();
			sum++;
			String name = client.readLine();
			System.out.println("Neuer Client angenommen. Anzahl der clients: " + name);
			clients.put(name, client);
		}
	}
}

package serverClient;

import java.io.IOException;
import java.util.Scanner;

public class ClientChat {

	Socket s;
	String ip = "localhost";
	int port = 5000;
	String name = "Peter";
	
	public static void main(String[] args) {
		try {
			new ClientChat();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ClientChat() throws IOException, InterruptedException {
		// TODO Auto-generated constructor stub
		s = new Socket(ip,port);
		s.connect();
		s.write(name + "\n");
		startSender();
		startListener();
	}
	
	public void startListener() throws InterruptedException, IOException{
		while(true){
			String text = s.readLine();
			System.out.println(text.contains(name)?"":text);
		}
	}
	
	public void startSender(){
		new Thread(()->{
			String text;
			Scanner sc = new Scanner(System.in);
			while (true) {
				text = sc.nextLine();
				try {
					s.write(name+ ": " + text + "\n");
					System.out.println("Massage Send." + text);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
		
}

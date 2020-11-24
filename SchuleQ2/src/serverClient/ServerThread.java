package serverClient;

import java.io.IOException;

public class ServerThread extends Thread{

	private Socket cs;
	private int id;
	public ServerThread(Socket cs,int id) {
		// TODO Auto-generated constructor stub
		this.cs = cs;
		this.id = id;
	}

	private boolean executeCommand(String Command) throws IOException{
		System.out.println(id  + ". Kommando " + Command + " erhalten.");
		switch (Command.toLowerCase()) {
		case "exit":
			return false;
			
		case "print":
			System.out.println(id  + ". Hello World!!");
			break;
		case "givea":
			cs.write('a');
		default:
			break;
		}
		return true;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ClientThread " + id + " started.");
		while(true){
			try {
				while (cs.dataAvailable() <= 0) {
						Thread.sleep(10);
				}
				if(!executeCommand(cs.readLine())){
					break;
				}
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}

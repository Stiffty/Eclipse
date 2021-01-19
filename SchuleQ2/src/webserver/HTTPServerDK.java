package webserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.xml.ws.Response;

public class HTTPServerDK {

	private int localPort = 80;

	private Socket clientSocket;
	private ServerSocket serverSocket;

	public HTTPServerDK(int port) {
		// TODO Auto-generated constructor stub
		try {
			this.localPort = port;
			serverSocket = new ServerSocket(localPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void runServer() {
		while (true) {
			try {
				clientSocket = serverSocket.accept();
				String in;
				do{
					in = clientSocket.readLine();
					System.out.println(in);
				}while((!(in.length() == 0)));
				
				
				System.out.println("Fertig");
				clientSocket.write(execute(""));

				clientSocket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private String execute(String request) {
		try {
		
			File file = new File("C:\\Users\\achtniel\\Downloads\\HTML5 Test Page.htm");
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder response = new StringBuilder();

			 response.append( "HTTP/1.1 200 OK\r\n" + 
	                 "Server: HTTPServerDK: 1.0\r\n" + 
	                 "Connection: close\r\n" + "Content-Type: text/html\r\n"     +
	                 "\r\n" + 
	                 "Antwort von HTTPServerDK auf:\r\n\r\n" +
	                 request);
	      
	      Date d = new Date();
	      
	      response.append(response +
	                 "Information vom HTTP-Server-System:\n\n" +
	                 "Datum und Uhrzeit des Server-Systems: " + d.toString() + "\n");
			
			int r = 0;

			while ((r = br.read()) != -1) {

				response.append((char) r);
			}

			return response.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Fehler";
	}

	public void beendeServer() {

	}
}

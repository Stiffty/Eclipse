package webServerV2;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.xml.ws.Response;

public class HTTPServerDK {

	private int localPort;

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
			StringBuilder header = new StringBuilder();
			try {
				clientSocket = serverSocket.accept();
				String in;
				System.out.println("-------------Header---------------");
				do{
					in = clientSocket.readLine();
					System.out.println("| " + in);
					header.append(in);
				}while((!(in.length() == 0)));
				System.out.println("----------------------------------");
				
				System.out.println("Fertig");
				clientSocket.write(execute(header.toString()));
				clientSocket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private String execute(String request) {
		try {
			System.out.println("Request: " + request );
			String path =java.net.URLDecoder.decode(request.replace(" ", "").split("GET")[1].split("HTTP/")[0], StandardCharsets.UTF_8.name());
		
			System.out.println("Path: " + path);
			StringBuilder response = new StringBuilder();

			
	                
			 if(path.equals("/")){
				 response.append(getHeader("Content-Type: text/html"));
				 response.append(readFile("C:\\Users\\achtniel\\Downloads\\HTML5 Test Page.htm"));
				}
			 else{
				 response.append(getHeader("Content-Type: image/jpeg"));
				// response.append(readFile("C:\\Users\\achtniel\\Downloads\\" + path));
				 clientSocket.write(response.toString());
				 byte [] im = extractBytes("C:\\Users\\achtniel\\Downloads\\" + path);
				 clientSocket.write(im,im.length);
			 }

			return response.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "HTTP/1.1 404 SITE NOT FOUND\r\n";
	}

	private String readFile(String url) throws IOException{
		File file = new File(url);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		StringBuilder response = new StringBuilder();
		int r = 0;
		
		while ((r = br.read()) != -1) {

			response.append((char) r);
		}
		return response.toString();
	}
	
	private String getHeader(String... header){
		 String returnHeader = "HTTP/1.1 200 OK\r\n" + 
                 "Server: HTTPServerDK: 1.0\r\n" + 
                 "Connection: keep-alive\r\n" ;
		 
		for (String string : header) {
			returnHeader+=string+"\r\n";
		}
		
		returnHeader+="\r\n";
		
		return returnHeader;
	}
	
	public byte[] extractBytes (String ImageName) throws IOException {
		 // open image
		 File imgPath = new File(ImageName);
		 BufferedImage bufferedImage = ImageIO.read(imgPath);

		 // get DataBufferBytes from Raster
		 WritableRaster raster = bufferedImage .getRaster();
		 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

		 return ( data.getData() );
		}
	
	public void beendeServer() {

	}
}

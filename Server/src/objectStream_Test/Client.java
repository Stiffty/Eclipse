package objectStream_Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static ObjectInputStream in;
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket client = new Socket("localhost",333);
			System.out.println("t1");
			in = new ObjectInputStream(client.getInputStream());
			System.out.println("t");
			
			try {
				while(true) {
					Test t = (Test) in.readObject();
					int test = t.getValue();
					System.out.println(test);
				}
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

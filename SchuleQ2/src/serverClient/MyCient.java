package serverClient;

import java.io.IOException;

public class MyCient {
 private Socket cs;

public MyCient(String host,int port) throws IOException {
	super();
	this.cs = new Socket(host,port);
	
}
 public void startListener(){
	 new Thread(()->{
		 while(true){
			 
		 }
	 }).start();
 }
 public void startSender(){
	 
 }
}

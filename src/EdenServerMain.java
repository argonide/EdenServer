import java.net.*;
import java.io.*;

public class EdenServerMain implements Runnable{
	EdenServerMain(){
		
	}
	
	
	public void run() {
		ServerSocket ssock = null;
		try {
			ssock = new ServerSocket(2555);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			try {
				Socket sock=ssock.accept();
				System.out.println("got connection");
				DataInputStream din=new DataInputStream(sock.getInputStream());
				String s=din.readLine();
				System.out.println(s);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args){
		EdenServerMain esm=new EdenServerMain();
		new Thread(esm).start();
	}
}

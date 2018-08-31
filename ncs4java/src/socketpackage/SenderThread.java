package socketpackage;

import java.net.*;
import java.io.*;

public class SenderThread extends Thread{
	Socket socket;
	String name;
	SenderThread(Socket socket, String name){
		this.socket = socket;
		this.name = name;
		
	}
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer= new PrintWriter(socket.getOutputStream());
			writer.println(name);
			writer.flush();
			while(true) {
				String str = reader.readLine();
				if(str.equals("bye"))
					break;
				writer.println(str);
				writer.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

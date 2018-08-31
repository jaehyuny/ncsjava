package socketpackage;

import java.io.*;
import java.net.*;

public class ReceiverThread extends Thread {
	Socket socket;
	ReceiverThread(Socket socket){
		this.socket = socket;
		
	}
	public void run() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String str = reader.readLine();
				if(str == null)
					break;
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

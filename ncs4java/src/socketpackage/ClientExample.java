package socketpackage;

import java.io.IOException;
import java.net.*;

public class ClientExample {
	public static void main(String[] args) {
		if(args.length !=1) {
			System.out.println("Usage: java ClientExample4 <user-name>");
			return;
		}
		try {
			Socket socket = new Socket("58.224.18.155", 9002);
			Thread thread1 = new SenderThread(socket, args[0]);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}

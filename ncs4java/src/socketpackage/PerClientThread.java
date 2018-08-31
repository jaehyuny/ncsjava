package socketpackage;

import java.io.*;
import java.net.*;
import java.util.*;

public class PerClientThread extends Thread{
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	Socket socket;
	PrintWriter writer;
	PerClientThread(Socket socket){
		this.socket=socket;
		try {
			writer = new PrintWriter(socket.getOutputStream());
			list.add(writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine();
			sendAll("#"+name+"´ÔÀÌ µé¾î¿À¼Ì½À´Ï´Ù");
			while(true) {
				String str = reader.readLine();
				if(str == null)
					break;
				sendAll(name+">"+str);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			list.remove(writer);
			sendAll("#"+name+"´ÔÀÌ ³ª°¡¼Ì½À´Ï´Ù");
			try {
				socket.close();
			} catch (Exception ignored) {
				
			}
		}
	}
	private void sendAll(String str) {
		for(PrintWriter writer:list) {
			writer.println(str);
			writer.flush();
		}
	}
}

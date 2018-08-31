package socketpackage;

import java.io.*;
import java.net.*;

public class SocketPractice {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("58.224.18.155",9000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			String str = "채팅프로그램";
			out.write(str.getBytes());
			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

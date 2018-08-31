package threadpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadThread extends Thread{
	FileReader fr = null;
	BufferedReader br = null;
	public void run() {
		try {
			fr = new FileReader("D:\\FILEFOLDER\\myfile.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			try {
				int data = fr.read();
				if(data==-1)
					fr = new FileReader("D:\\FILEFOLDER\\myfile.txt");
//				char ch = (char) data;
//				System.out.println(ch);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				br = new BufferedReader(fr);
				String line;
				while((line = br.readLine()) != null) {
					System.out.println(line);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}
}

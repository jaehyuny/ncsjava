package filereadwrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileSearch {
	BufferedReader br = null;
	void fileSearch() {
		File dir = new File("D:\\FILETEST");
		File[] filelist = dir.listFiles();
		try {
			FileReader fr = new FileReader("D:\\FILETEST\\a.txt");
			while(true) {
				try {
					int data = fr.read();
					if(data == -1)
						break;
					char ch = (char) data;
					System.out.println(ch);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}catch (Exception e) {
		}
		for(File filelist1:filelist) {
			if(filelist1.isFile()) {
				System.out.println(filelist1.getName());
				try {
					br = new BufferedReader(new FileReader("D:\\FILETEST\\"+filelist1.getName()));
					String line;
					while((line = br.readLine()) != null) {
						System.out.println(line);
					}
					br.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}

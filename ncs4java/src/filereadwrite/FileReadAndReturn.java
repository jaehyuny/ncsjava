package filereadwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReadAndReturn {
	FileReader fr = null;
	FileReader fileReadAndReturn() {
		File dir = new File("D:\\FILEFOLDER\\");
		File[] filelist = dir.listFiles();
		for(File filelist1:filelist) {
			if(filelist1.isFile()) {
				try {
					fr = new FileReader("D:\\FILEFOLDER\\"+filelist1.getName());
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return fr;
	}
}

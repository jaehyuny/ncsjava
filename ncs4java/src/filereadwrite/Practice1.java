package filereadwrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Practice1 {
	final String FILENAME = "d:\\FILETEST\\";
	FileWriter fw = null;
	BufferedWriter bw = null;
	void nameWriter(String filename, String content) {
		String savefilename = FILENAME+filename+".txt";
		try {
			bw = new BufferedWriter(new FileWriter(savefilename));
			bw.write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(bw != null)
						bw.close();
					if(fw != null)
						fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}

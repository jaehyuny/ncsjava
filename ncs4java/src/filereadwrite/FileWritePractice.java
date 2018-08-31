package filereadwrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritePractice {
	final String FILENAME = "d:\\FILETEST\\output.txt";
	BufferedWriter bw =null;
	FileWriter fw = null;
	void fileWriteRec(String filename, String content) {
		String savefilepath = "d:\\FILETEST\\"+filename+".txt";
		System.out.println(filename);
		System.out.println(content);
		try {
			fw = new FileWriter(savefilepath);
			bw = new BufferedWriter(fw);
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
	void fileWriter() {
		String txt = "hello java file write \r\n";
				txt += "I love java because to powerfull \r\n";
		try {
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(txt);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(bw !=null)
					bw.close();
				if(fw !=null)
					fw.close();
			}catch (Exception e2) {
				
			}
		}
	}
}

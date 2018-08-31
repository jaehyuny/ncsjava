package filereadwrite;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReadAndReturnMain {
	static BufferedReader br = null;
	public static void main(String[] args) {
		FileReadAndReturn obj = new FileReadAndReturn();
		try {
			br = new BufferedReader(obj.fileReadAndReturn());
			String line;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

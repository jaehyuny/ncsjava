package filereadwrite;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReadAndReturn1 {
	static BufferedReader br = null;
	public static void main(String[] args) {
		FileReadAndReturnMain1 obj = new FileReadAndReturnMain1();
		try {
			br = new BufferedReader(obj.fileReadAndReturnMain1());
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

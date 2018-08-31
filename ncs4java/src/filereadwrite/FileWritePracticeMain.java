package filereadwrite;

import java.util.Scanner;

public class FileWritePracticeMain {

	public static void main(String[] args) {
		FileWritePractice obj = new FileWritePractice();
		obj.fileWriter();
		Practice1 obj2 = new Practice1();
		Scanner sc = new Scanner(System.in);
		String filename;
		String content;
		System.out.println("file name:");
		filename=sc.nextLine();
		System.out.println("content:");
		content=sc.nextLine();
		obj.fileWriteRec(filename, content);
	}

}

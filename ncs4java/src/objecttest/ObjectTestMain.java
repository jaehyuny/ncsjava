package objecttest;

import java.io.File;

public class ObjectTestMain {
	public static void main(String[] args) {
		ObjectTest obj = new ObjectTest();
		int num = 200;
		File file = new File("D:\\text.txt");
		obj.methodCalled(file);
	}
}

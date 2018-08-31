package threadpackage;

public class ThreadPracticeMain {
	public static void main(String[] args) {
		Thread thread1 = new RandomDigitThread();
		Thread thread2 = new DigitSequenceThread();
		Thread thread3 = new FileReadThread();
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

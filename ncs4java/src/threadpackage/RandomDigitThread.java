package threadpackage;

import java.util.Random;

public class RandomDigitThread extends Thread{
	Random random = new Random();
	public void run() {
		while(true) {
			int result = random.nextInt(500);
			System.out.println("after:"+result);
			try {
				Thread.sleep(1000);
				if(result == 300)
					Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

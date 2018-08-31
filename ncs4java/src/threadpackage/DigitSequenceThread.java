package threadpackage;

public class DigitSequenceThread extends Thread{
	public void run() {
		int i = 0;
		while(true) {
			System.out.println("digit:"+i);
			i++;
			try {
				Thread.sleep(1000);
				if(i==500)
					i=0;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

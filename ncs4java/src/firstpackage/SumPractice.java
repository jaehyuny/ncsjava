package firstpackage;

public class SumPractice {
	public static void main(String[] args) {
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i<=100; i++) {
			switch(i%2) {
				case 1:
					sum1 += i;
					break;
				case 0:
					sum2 += i;
					break;
			}
		}
		System.out.println("È¦¼ö\t"+sum1);
		System.out.println("Â¦¼ö\t"+sum2);
		System.out.println("ÇÕ°è\t"+(sum1+sum2));
	}
}

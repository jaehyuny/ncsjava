package firstpackage;

public class MissionMeth {
	private int sum;
	public static void main(String[] args) {
		final int myage=30;
		int sm = sumMeth();
		int em = evenMeth();
		int om = oddMeth();
		System.out.println(sm+"  "+em+"  "+om);
	}
	static int sumMeth() {
		int sum = 0;
		for(int i = 0; i<=100; i++) {
			sum += i;
		}
		System.out.println("1~100 ÇÕ :"+sum);
		return sum;
	}
	static int evenMeth() {
		int even = 0;
		for(int j =0; j<=100; j++) {
			if(j%2==0)
				even += j;
		}
		System.out.println("Â¦¼ö ÇÕ :"+even);
		return even;
	}
	static int oddMeth() {
		int odd = 0;
		for(int k =0 ; k<=100; k++) {
			if(k%2!=0)
				odd += k;
		}
		System.out.println("È¦¼ö ÇÕ :"+odd);
		return odd;
	}
}

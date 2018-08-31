package objectpackage;

public class RecursionFunctionDemo {
	public static void main(String[] args) {
		RecursionFunction obj = new RecursionFunction();
		int a[] = new int[6];
		for(int i=0; i<6; i++) {
			a[i] = obj.getLotto();
			for(int j=0; j<i; j++) {
				if(a[j]==a[i])
					i--;
			}
		}
		for(int k=0; k<6; k++) {
			System.out.println(a[k]);
		}
	}
}

package objectpackage;

public class DigitSumSub {
	
	int sumMeth(int num1,int num2) {
		int sum = num1 + num2;
		return sum;
	}
	int subMeth(int num1,int num2) {
		int sum = num1 - num2;
		return sum;
	}
	int oneMeth(int num1) {
		int sum = 0;
		for(int i=0; i<=num1; i++) {
			sum += i;
		}
		return sum;
	}
	int twoMeth(int num1) {
		boolean sum = true;
		while(sum) {
			num1 += 1;
			System.out.print(num1+"\t");
			if(num1==10)
				sum = false;
		}
			
		return num1;
	}
}

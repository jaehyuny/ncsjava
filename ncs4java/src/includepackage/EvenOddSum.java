package includepackage;

public class EvenOddSum {
	public int[] evenOddSum(int begin, int end) {
		int even = 0;
		int odd = 0;
		for(int i=begin; i<= end; i++) {
			if(i%2==0)
				even += i;
			if(i%2 != 0)
				odd += i;
		}
		int[] arr = {even, odd};
		return arr;
	}
}

package includepackage;

public class BeginEndSum {
	public int beginEndSum(int begin, int end) {
		int sum = 0;
		for(int i = begin; i <= end; i++) {
			sum += i;
		}
		return sum;
	}
}

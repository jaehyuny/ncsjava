package objecttest;

import java.io.File;

import includepackage.BeginEndSum;
import includepackage.EvenOddSum;

public class ObjectDigitCallMain {
	public static void main(String[] args) {
		int begin =1;
		int end =100;
		BeginEndSum obj = new BeginEndSum();
		int result = obj.beginEndSum(begin, end);
		System.out.println(result);
		EvenOddSum obj1 = new EvenOddSum();
		int[] result1 = obj1.evenOddSum(begin, end);
		System.out.println("Â¦¼ö ÇÕ: "+result1[0]);
		System.out.println("È¦¼ö ÇÕ: "+result1[1]);
	}
}

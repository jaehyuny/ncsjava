package objectpackage;

public class ObjectPracticeMain {
	public static void main(String[] args) {
		DigitSumSub obj = new DigitSumSub();
		CallObject str = new CallObject();
		DigitSum obj2 = new DigitSum();
		int result = obj.subMeth(100, 200);
		System.out.println(result);
		int result2 = obj.sumMeth(100, 200);
		System.out.println(result2);
		int result3 = obj.oneMeth(10);
		System.out.println(result3);
		obj.twoMeth(2);
		System.out.println();
		String result4 = str.strMeth("hello", "java");
		System.out.println(result4);
		obj2.sumMeth(200);
	}
}

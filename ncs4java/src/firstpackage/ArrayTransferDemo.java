package firstpackage;

public class ArrayTransferDemo {
	public static void main(String[] args) {
		int result1 = firstMeth();
		secondMeth();
		System.out.println();
		System.out.println(result1);
		int result3 = thirdMeth();
		System.out.println("1~50 гу:"+result3);
	}
	static int firstMeth() {
		int first = 1;
		int sum = 0;
		System.out.println(first);
		sum = first+1+2+3+4;
		return sum;
	}
	static void secondMeth() {
		int arr[] = {30,20,90,10,60};
		for(int aaa:arr) {
			System.out.print(aaa+"\t");
		}
	}
	static int thirdMeth() {
		int third = 3;
		int sum = 0;
		for(int i = 0; i<=50; i++) {
			sum += i;
		}
		System.out.println(third);
		return sum;
	}
}

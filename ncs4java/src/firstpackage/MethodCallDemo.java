package firstpackage;

public class MethodCallDemo {
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 200;
		int result=calledMeth(num1,num2);
		System.out.println(result);
	}
	static int calledMeth(int fir, int sec) {
		System.out.println("called..."+fir+"  "+sec);
		return 500;
	}
}

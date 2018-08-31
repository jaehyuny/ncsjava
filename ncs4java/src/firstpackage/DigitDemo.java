package firstpackage;

public class DigitDemo {
	public static void main(String[] args) {
		int num1 = 2+3*4+5;
		int num2 = (2+3)*4+5;
		
		if(num1 < num2) {
			System.out.println("num1이 크다");
			System.out.println("따라서 출력");
		}
		if(num1 > num2)
			System.out.println("num1이 크다");
		else
			System.out.println("num2이 크다");
		if(num1 > num2)
			System.out.println("num1이 크다");
		else if(num1 == num2)
			System.out.println("두수는 같다");
		else
			System.out.println("num2이 크다");
		System.out.println(num1+"\t"+num2);
		System.out.println(num2);
		
	}
}

package firstpackage;

public class IfDemo {
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 200;
		
		if (num1 == 100) {
			if (num2 == 200) {
				System.out.println("만족..");
			}else {
				System.out.println("불만족..");
			}
		}else {
			System.out.println("불만족..");
		}
		if (num1 == 100 && num2 == 200) {
			System.out.println("또 만족..");
		}else {
			System.out.println("또 불만족..");
		}
	}
}

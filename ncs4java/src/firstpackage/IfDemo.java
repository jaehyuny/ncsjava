package firstpackage;

public class IfDemo {
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 200;
		
		if (num1 == 100) {
			if (num2 == 200) {
				System.out.println("����..");
			}else {
				System.out.println("�Ҹ���..");
			}
		}else {
			System.out.println("�Ҹ���..");
		}
		if (num1 == 100 && num2 == 200) {
			System.out.println("�� ����..");
		}else {
			System.out.println("�� �Ҹ���..");
		}
	}
}

package firstpackage;

public class DigitDemo {
	public static void main(String[] args) {
		int num1 = 2+3*4+5;
		int num2 = (2+3)*4+5;
		
		if(num1 < num2) {
			System.out.println("num1�� ũ��");
			System.out.println("���� ���");
		}
		if(num1 > num2)
			System.out.println("num1�� ũ��");
		else
			System.out.println("num2�� ũ��");
		if(num1 > num2)
			System.out.println("num1�� ũ��");
		else if(num1 == num2)
			System.out.println("�μ��� ����");
		else
			System.out.println("num2�� ũ��");
		System.out.println(num1+"\t"+num2);
		System.out.println(num2);
		
	}
}

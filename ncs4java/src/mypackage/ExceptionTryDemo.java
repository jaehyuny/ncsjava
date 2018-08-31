package mypackage;

public class ExceptionTryDemo {
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 0;
		try {
			int sum = num1/num2;
			System.out.println("------success");
		} catch (Exception e) {
			System.out.println("fail");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("done");
			
		}
		
	}
}

package test;

public class ExceptionExample4 {
	public static void main(String[] args) {
		try {
			int result = devide(3,0);
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("error");
			// TODO: handle exception
		}
	}
	static int devide(int a, int b) {
		int result = a/b;
		return result;
	}
}

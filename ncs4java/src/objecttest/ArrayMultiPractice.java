package objecttest;

public class ArrayMultiPractice {
	public static void main(String[] args) {
		String[][] arr=new String[8][9];
		for(int i=2; i<=9; i++) {
			for(int k=1; k<=9; k++) {
				String txt = i+"x"+k+"="+(i*k)+"\t";
				arr[i-2][k-1]=txt;
//				System.out.print(arr[i][k]);
			}
//			System.out.println();
		}
		for(String[] arr1:arr) {
			for(String arr2:arr1) {
				System.out.print(arr2);
			}
			System.out.println();
		}
	}
}

package firstpackage;

public class ForPractice {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int[] arr= {90,70,40,50,30,20,10,60,80};
		for(int i=0; i<arr.length; i++) {
			switch(arr[i]) {
				case 50:
					a = i;
					break;
				case 80:
					b = i;
					break;
			}
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		for(int aaa:arr) {
			
			System.out.print(aaa+"\t");
		}
	}
}

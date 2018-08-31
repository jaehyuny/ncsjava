package firstpackage;

public class WhilePractice {
	public static void main(String[] args) {
		int[] arr = {90,70,40,50,30,20,10,60,80};
		int i=0;
		int room50 = 0;
		int room80 = 0;
		while(i<arr.length) {
			switch(arr[i]) {
				case 50:
					room50 = i;
					break;
				case 80:
					room80 = i;
					break;
			}
			i++;
		}
		int temp = arr[room50];
		arr[room50] = arr[room80];
		arr[room80] = temp;
		i = 0;
		while(i<arr.length) {
			System.out.print("-->"+arr[i]);
			i++;
			
		}
	}
}

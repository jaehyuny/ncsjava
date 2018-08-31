package objectpackage;

public class RandomDigitCurrentMain {

	public static void main(String[] args) {
		RandomDigitCurrent obj = new RandomDigitCurrent();
		int lotto[] = new int[6];
		for(int i=0; i<6; i++) {
			lotto[i] = obj.digitCurrent();
			for(int j=0; j<i; j++) {
				if(lotto[j]==lotto[i]) {
					i--;
				}
			}
		}
		for(int k=0; k<6; k++) {
			System.out.println(lotto[k]);
		}
	}

}

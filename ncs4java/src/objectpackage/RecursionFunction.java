package objectpackage;

import java.util.Random;

public class RecursionFunction {
	Random random;
	int getLotto() {
		random = new Random();
		int lottono = random.nextInt(45);
		if(lottono != 0)
			return lottono;
		else
		return getLotto();
	}
}

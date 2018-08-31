package objectpackage;

import java.util.Random;

public class RandomDigitCurrent {
	int digitCurrent() {
		Random random = new Random();
		return random.nextInt(46);
	}
}

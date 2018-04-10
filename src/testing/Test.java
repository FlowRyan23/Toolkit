package testing;

import java.math.BigDecimal;

import basic.MathyStuff;
import fileSystem.Logger;

public class Test {
	public static void main(String[] args) {
//		double sum = 0;
//		for(int i=1; i<25; i++)
//			sum += MathyStuff.binomialCoefficient(24, i);
//		System.out.println(sum);
		
		BigDecimal n = new BigDecimal(2);
		BigDecimal two = new BigDecimal(2);
		for(int i=0; i<3500; i++) {
			n = n.multiply(two);
			if(i%500 == 0)
				System.out.println(i);
		}
		
		Logger logger = new Logger("./number.txt");
		logger.log(n.toString());
	}
}

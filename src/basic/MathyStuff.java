package basic;

public class MathyStuff {

	public static double binomialCoefficient(int n, int k) {
		return factorial(n) / (factorial(k)*factorial(n-k));
	}
	
	public static double factorial(int n) {
		double res = 1.0d;
		while(n > 1) {
			res *= n;
			n--;
		}
		return res;
	}
	
}

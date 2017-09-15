package basic;

public class BaseKit {

	public static <T extends Comparable<T>> T min(T...ts) {
		T min = null;
		for(T a: ts)
			if(min == null || a.compareTo(min) < 0)
				min = a;
		return min;		
	}
	
	public static <T extends Comparable<T>> T max(T...ts) {
		T max = null;
		for(T a: ts)
			if(max == null || a.compareTo(max) > 0)
				max = a;
		return max;		
	}
	
	public static <T extends Comparable<T>> T bound(T min, T val, T max) {
		if(val.compareTo(min) < 0) return min;
		if(val.compareTo(max) > 0) return max;
		return val;
	}
	
	public static double wrappingIncrement(double val, double min, double max, long amount) {
		for(int i=0; i<amount; i++) {
			val++;
			if(val > max) val = min;
		}
		return val;
	}
	
	public static double wrappingDecrement(double val, double min, double max, long amount) {
		for(int i=0; i<amount; i++) {
			val--;
			if(val < min) val = max;
		}
		return val;
	}
	
	public static boolean inBounds(long val, long min, long max) {
		return val >= min && val <= max;
	}
	
}

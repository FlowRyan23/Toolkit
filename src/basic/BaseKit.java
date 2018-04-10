package basic;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

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
	
	public static Image copyImage(Image img) {
		double width = img.getWidth();
		double height = img.getHeight();
		WritableImage res = new WritableImage(img.getPixelReader(), (int)width, (int)height);
		return res;
	}
	
	public static byte[][][] imageToByteArray(Image image) {
		byte[][][] res = new byte[(int) image.getWidth()][(int) image.getHeight()][4];
		PixelReader reader = image.getPixelReader();
		
		for(int x=0; x<image.getWidth(); x++)
			for(int y=0; y<image.getHeight(); y++)
				res[x][y] = argbUnpack(reader.getArgb(x, y));
		
		return res;
	}
	
	public static byte[] argbUnpack(int argb) {
		int alpha = (0xff<<24 & argb)>>>24;
		int red = (0xff<<16 & argb)>>>16;
		int green = (0xff<<8 & argb)>>>8;
		int blue = 0xff & argb;
		
		return new byte[] {(byte) alpha, (byte) red, (byte) green, (byte) blue};
	}
	
}

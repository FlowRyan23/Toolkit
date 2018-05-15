package basic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

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
	
	public static <T extends Comparable<T>> boolean inBounds(T val, T min, T max) {
		boolean low = val.compareTo(min) == -1;
		boolean high = val.compareTo(max) == 1;
		return !low && !high;
	}
	
	public static Image copyImage(Image img) {
		double width = img.getWidth();
		double height = img.getHeight();
		WritableImage res = new WritableImage(img.getPixelReader(), (int)width, (int)height);
		return res;
	}
	
	public static int[][][] imageToByteArray(Image image) {
		int[][][] res = new int[(int) image.getWidth()][(int) image.getHeight()][4];
		PixelReader reader = image.getPixelReader();
		
		for(int x=0; x<image.getWidth(); x++)
			for(int y=0; y<image.getHeight(); y++)
				res[x][y] = argbUnpack(reader.getArgb(x, y));
		
		return res;
	}
	
	public static int[] argbUnpack(int argb) {
		int alpha = (0xff<<24 & argb)>>>24;
		int red = (0xff<<16 & argb)>>>16;
		int green = (0xff<<8 & argb)>>>8;
		int blue = 0xff & argb;
		
		return new int[] {alpha, red, green, blue};
	}
	
	public static int getARGB(Color color) {
		int alpha = (int) (color.getOpacity() * 255);
		int red = (int) (color.getRed() * 255);
		int green = (int) (color.getGreen() * 255);
		int blue = (int) (color.getBlue() * 255);
		
		return (alpha<<24) + (red<<16) + (green<<8) + blue;
	}
	
	public static Color getColor(int argb) {
		int[] argbList = BaseKit.argbUnpack(argb);
		return Color.rgb(argbList[1], argbList[2], argbList[3], ((double) argbList[0])/255);
	}
	
	public static boolean isWithinToleranz(Color a, Color b, double toleranz) {
		int[] argbListA = argbUnpack(getARGB(a));
		int[] argbListB = argbUnpack(getARGB(b));
		
		for(int i=0; i<4; i++)
			if(!(inBounds(argbListA[i]*toleranz, (double) argbListB[i], (double) argbListB[i]) || inBounds(argbListA[i]*(1-toleranz), (double) argbListB[i], (double) argbListB[i])))
				return false;
		return true;
	}
	
	public static <E> List<E> copie(List<E> template) {
		ArrayList<E> copie = new ArrayList<>(template.size());
		copie.addAll(template);
		return (List<E>) copie;
	}
	
	public static boolean isImageFile(File file) {
		if(!file.isFile()) {
			return false;
		}
		String name = file.getName();
		System.out.println(name);
		String extension = name.substring(name.lastIndexOf("."));
		if(extension.equals(".jpg") || extension.equals(".png"))
			return true;
		return false;
	}
	
}

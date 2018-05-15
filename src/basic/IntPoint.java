package basic;

import basic.BaseKit;

public class IntPoint {
	public int x, y;
	
	public IntPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean inBounds(IntPoint max, IntPoint min) {
		return BaseKit.inBounds(x, min.x, max.x) && BaseKit.inBounds(y, min.y, max.y);
	}
	
	public boolean inBounds(IntPoint max) {
		return BaseKit.inBounds(x, 0, max.x) && BaseKit.inBounds(y, 0, max.y);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

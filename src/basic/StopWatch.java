package basic;

public class StopWatch {

	private long startMs=0;
	private long endMs=0;
	
	public void start() {
		startMs = System.currentTimeMillis();
	}
	
	public void stop() {
		endMs = System.currentTimeMillis();
	}
	
	public long getTime() {
		return endMs-startMs;
	}
	
}

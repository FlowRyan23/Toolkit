package search;

public interface Heuristic {

	public abstract <T> int heuristic(T start, T dest);
	
}
